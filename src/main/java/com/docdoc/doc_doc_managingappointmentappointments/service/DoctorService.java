package com.docdoc.doc_doc_managingappointmentappointments.service;

import com.docdoc.doc_doc_managingappointmentappointments.model.db.DoctorAppointment;
import com.docdoc.doc_doc_managingappointmentappointments.model.dto.db.ReserveTimeResponse;
import com.docdoc.doc_doc_managingappointmentappointments.openfeign.DoctorRequest;
import com.docdoc.doc_doc_managingappointmentappointments.repository.DoctorAppointmentRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
@Log4j2
public class DoctorService {

    private DoctorRequest doctorRequest;
    private final DoctorAppointmentRepository doctorAppointmentRepository;

    @Autowired
    public DoctorService(DoctorRequest doctorRequest, DoctorAppointmentRepository doctorAppointmentRepository) {
        this.doctorRequest = doctorRequest;
        this.doctorAppointmentRepository = doctorAppointmentRepository;
    }

    public long reserveTimeDoctor(LocalDateTime date, long doctorId, long clinicId, long userId) throws Exception {
        ReserveTimeResponse timeTo = doctorRequest.reserveTime(date, doctorId, clinicId);
        if (timeTo == null) {
            throw new Exception("timeTo == null");
        }
        DoctorAppointment doctorAppointment = DoctorAppointment.builder()
                .appointmentStatus(DoctorAppointment.AppointmentStatus.NEW)
                .timeFrom(date.toLocalTime())
                .timeTo(timeTo.getReserveTimeTo())
                .doctorId(doctorId)
                .clinicId(clinicId)
                .userId(userId)
                .date(date)
                .build();
        return doctorAppointmentRepository.save(doctorAppointment).getId();
    }

    public Boolean cancelReserveTimeDoctor(long appointmentId, DoctorAppointment.AppointmentStatus appointmentStatus) {
        doctorAppointmentRepository
                .findById(appointmentId).ifPresentOrElse((doctorAppointmentCanceled) -> {
                            doctorRequest.cancelReserve(doctorAppointmentCanceled.getDate(),
                                    doctorAppointmentCanceled.getDoctorId(),
                                    doctorAppointmentCanceled.getClinicId());
                            doctorAppointmentRepository.cancelReserveTimeDoctor(appointmentId, appointmentStatus);
                        },
                        () -> log.info("doctorAppointment not found")
                );


        return true;
    }

    public List<DoctorAppointment> getFutureAppointment(long idDoctor) {
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        return doctorAppointmentRepository.getFutureAppointment(date,time,idDoctor);
    };
}

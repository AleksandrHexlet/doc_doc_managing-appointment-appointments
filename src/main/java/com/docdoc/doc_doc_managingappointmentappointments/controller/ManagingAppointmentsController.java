package com.docdoc.doc_doc_managingappointmentappointments.controller;

import com.docdoc.doc_doc_managingappointmentappointments.model.db.DoctorAppointment;
import com.docdoc.doc_doc_managingappointmentappointments.model.db.FeedBack;
import com.docdoc.doc_doc_managingappointmentappointments.model.dto.db.ClinicProfitsByPeriod;
import com.docdoc.doc_doc_managingappointmentappointments.service.DoctorService;
import com.docdoc.doc_doc_managingappointmentappointments.service.FeedBackService;
import com.docdoc.doc_doc_managingappointmentappointments.service.VisitDoctorService;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("maa/appointment")
public class ManagingAppointmentsController {
    private final DoctorService doctorService;
    private final VisitDoctorService visitDoctorService;

    @Autowired
    public ManagingAppointmentsController(FeedBackService feedBackService, DoctorService doctorService,
                                          VisitDoctorService visitDoctorService) {
        this.doctorService = doctorService;
        this.visitDoctorService = visitDoctorService;
    }

    @PostMapping("/reserve_time_doctor")
    public long reserveTimeDoctor(@RequestParam LocalDateTime date,
                                  @RequestParam long doctorId, @RequestParam long clinicId,
                                  @RequestParam long userId) {
        try {
            return doctorService.reserveTimeDoctor(date,
                    doctorId, clinicId, userId);
        } catch (Exception exception) {
            throw new ResponseStatusException(HttpStatusCode.valueOf(500), exception.getMessage());
        }

    }

    @PutMapping("/cancel_time_doctor")
    public Boolean cancelReserveTimeDoctor(@RequestParam long appointmentId, @RequestParam DoctorAppointment.AppointmentStatus appointmentStatus) {
        return doctorService.cancelReserveTimeDoctor(appointmentId, appointmentStatus);
    }

    /**
     * Отдаёт список будущих записей
     * по идентификатору врача
     *
     * @param idDoctor
     * @return List<DoctorAppointment>
     */
    @GetMapping("/appointment/doctor/{idDoctor}/future")
    public List<DoctorAppointment> getFutureAppointment(@PathVariable() @Positive long idDoctor) {
        return doctorService.getFutureAppointment(idDoctor);
    }

    ;

    @GetMapping("/profit")
    public List<ClinicProfitsByPeriod> getProfitByClinicIds(@RequestParam LocalDateTime dateFrom,
                                                            @RequestParam LocalDateTime dateTo,
                                                            @RequestParam List<Long> clinicIds) {
        return visitDoctorService.getProfitByClinicIds(dateFrom, dateTo, clinicIds);
    }


}



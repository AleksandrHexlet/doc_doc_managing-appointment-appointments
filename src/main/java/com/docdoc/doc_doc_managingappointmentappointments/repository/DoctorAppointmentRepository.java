package com.docdoc.doc_doc_managingappointmentappointments.repository;


import com.docdoc.doc_doc_managingappointmentappointments.model.db.DoctorAppointment;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public interface DoctorAppointmentRepository extends JpaRepository<DoctorAppointment,Long> {
   @Transactional
   @Modifying
   @Query(nativeQuery = true,value = "UPDATE doctor_appointment set doctor_appointment.appointment_status = :appointmentStatus " +
           "WHERE doctor_appointment.id  = :appointmentId")
   Boolean cancelReserveTimeDoctor(long appointmentId, DoctorAppointment.AppointmentStatus appointmentStatus);

   @Query(nativeQuery = true,value = "SELECT * FROM doctor_appointment " +
           "WHERE doctor_appointment.id = :idDoctor " +
           "AND doctor_appointment.date >= :date " +
           "AND doctor_appointment.time_from > :time " +
           "AND doctor_appointment.appointment_status = 'NEW'")
   List<DoctorAppointment> getFutureAppointment(LocalDate date, LocalTime time,long idDoctor);
}



//Отдаёт количество отзывов на каждого доктора по идентификатору клиники
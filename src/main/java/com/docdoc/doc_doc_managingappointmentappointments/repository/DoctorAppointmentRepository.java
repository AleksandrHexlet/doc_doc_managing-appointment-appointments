package com.docdoc.doc_doc_managingappointmentappointments.repository;


import com.docdoc.doc_doc_managingappointmentappointments.model.db.DoctorAppointment;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface DoctorAppointmentRepository extends JpaRepository<DoctorAppointment,Long> {
   @Transactional
   @Modifying
   @Query(nativeQuery = true,value = "UPDATE doctor_appointment set doctor_appointment.appointment_status = :appointmentStatus " +
           "WHERE doctor_appointment.id  = :appointmentId")
   Boolean cancelReserveTimeDoctor(long appointmentId, DoctorAppointment.AppointmentStatus appointmentStatus);
}

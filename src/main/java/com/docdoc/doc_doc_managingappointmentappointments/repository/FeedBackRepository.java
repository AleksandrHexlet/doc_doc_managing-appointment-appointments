package com.docdoc.doc_doc_managingappointmentappointments.repository;

import com.docdoc.doc_doc_managingappointmentappointments.model.db.FeedBack;
import com.docdoc.doc_doc_managingappointmentappointments.model.dto.db.FeedBackRepositoryResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FeedBackRepository extends JpaRepository<FeedBack,Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM feedback " +
            "JOIN visit_doctor on feedback.visit_doctor_id = visit_doctor.id " +
            "JOIN doctor_appointment on doctor_appointment.id = visit_doctor.doctor_appointment_id " +
            "WHERE doctor_appointment.clinic_id = :clinicId")
    List<FeedBack> findAllByClinicId(long clinicId);

    @Query(nativeQuery = true,value = "SELECT sum(fbd.id) as doctor_feed_back_ids_sum, " +
            "da.clinic_id as clinic_id" +
            "count(fdb.id) as doctor_feed_back_count, " +
            "da.doctor_id as doctor_id " +
            "FROM feedback fdb JOIN visit_doctor vd on fdb.visit_doctor_id = vd.id " +
            "JOIN doctor_appointment da on da.id = vd.doctor_appointment_id " +
            "WHERE da.clinic_id = :clinicId " +
            "group by da.doctor_id, " +
            "da.clinic_id " +
            "having count(fbd.id) > 10 " +
            "AND count(fbd.id) < 100 " +
            "OR sum(fbd.id) > 1000 " +
            "OR clinic.id > 10000 " +
            "clinic.id is NOT NULL " +
            "clinic.id != 15 " +
            "OR clinic.id BETWEEN 10 AND 20 " +
            "OR clinic.id in(123)" +
            "order by count(fbd.id) asc")
    List<FeedBackRepositoryResponse> getFeedbackDoctorsCountByClinicId(Long clinicId);


}
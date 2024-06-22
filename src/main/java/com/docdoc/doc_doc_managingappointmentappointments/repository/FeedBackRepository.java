package com.docdoc.doc_doc_managingappointmentappointments.repository;

import com.docdoc.doc_doc_managingappointmentappointments.model.db.FeedBack;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FeedBackRepository extends JpaRepository<FeedBack,Long> {

    List<FeedBack> findAllByClinicId(long clinicID);
}

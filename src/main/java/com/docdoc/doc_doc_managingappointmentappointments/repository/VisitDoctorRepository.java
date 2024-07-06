package com.docdoc.doc_doc_managingappointmentappointments.repository;


import com.docdoc.doc_doc_managingappointmentappointments.model.db.VisitDoctor;
import com.docdoc.doc_doc_managingappointmentappointments.model.dto.db.ClinicProfitsByPeriod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface VisitDoctorRepository extends JpaRepository<VisitDoctor,Long> {


    /**
     *
     * @param clinicIds
     * @param dateFrom
     * @param dateTo
     * @return
     */
    @Query(nativeQuery = true, value = "SELECT sum(da.price) as profit_by_clinic, " +
            "da.clinic.id as clinic_id " +
            "FROM visit_doctor vd " +
            "JOIN doctor_appointment da on vd.doctor_appointment_id = da.id " +
            "WHERE da.clinic_id in :clinicsIds " +
            "AND da.date > :dateFrom " +
            "AND da.date < :dateTo " +
            "group by da.clinic.id " +
            "order by sum(da.price) desc")
    List<ClinicProfitsByPeriod> getProfitByClinicId(List<Long>clinicIds, LocalDateTime dateFrom,
                                                    LocalDateTime dateTo);
}
//long getClinicId();
//double getProfitByClinic();
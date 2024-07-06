package com.docdoc.doc_doc_managingappointmentappointments.service;

import com.docdoc.doc_doc_managingappointmentappointments.model.dto.db.ClinicProfitsByPeriod;
import com.docdoc.doc_doc_managingappointmentappointments.repository.VisitDoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class VisitDoctorService {
    VisitDoctorRepository visitDoctorRepository;

    @Autowired
    public VisitDoctorService(VisitDoctorRepository visitDoctorRepository) {
        this.visitDoctorRepository = visitDoctorRepository;
    }

    public List<ClinicProfitsByPeriod> getProfitByClinicIds(LocalDateTime dateFrom,
                                                            LocalDateTime dateTo,
                                                            List<Long> clinicIds) {
        return visitDoctorRepository.getProfitByClinicId(clinicIds,dateFrom,dateTo);
    }

}

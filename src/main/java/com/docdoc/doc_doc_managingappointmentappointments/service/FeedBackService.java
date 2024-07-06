package com.docdoc.doc_doc_managingappointmentappointments.service;

import com.docdoc.doc_doc_managingappointmentappointments.model.db.FeedBack;
import com.docdoc.doc_doc_managingappointmentappointments.model.dto.db.FeedBackRepositoryResponse;
import com.docdoc.doc_doc_managingappointmentappointments.repository.FeedBackRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FeedBackService {
    private FeedBackRepository feedBackRepository;


    public List<FeedBack> feedBackList(long clinicID){
        return feedBackRepository.findAllByClinicId(clinicID);
    }

    public Map<Long, List<FeedBack>> getFeedbackDoctorsByClinicId(Long clinicId) {
      List<FeedBackRepositoryResponse> feedBackRepositoryResponses = feedBackRepository.getFeedbackDoctorsCountByClinicId(clinicId);
        return  null;
    }
}

package com.docdoc.doc_doc_managingappointmentappointments.service;

import com.docdoc.doc_doc_managingappointmentappointments.model.db.FeedBack;
import com.docdoc.doc_doc_managingappointmentappointments.repository.FeedBackRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
}

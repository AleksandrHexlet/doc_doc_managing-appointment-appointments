package com.docdoc.doc_doc_managingappointmentappointments.controller;

import com.docdoc.doc_doc_managingappointmentappointments.model.db.FeedBack;
import com.docdoc.doc_doc_managingappointmentappointments.service.FeedBackService;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("maa/feedback")

public class FeedBackController {
    private FeedBackService feedBackService;

    @Autowired
    public FeedBackController(FeedBackService feedBackService) {
        this.feedBackService = feedBackService;
    }


    @GetMapping("/doctor/count/")
    public Map<Long, List<FeedBack>> getFeedbackDoctorsByClinicId(@RequestParam @Positive Long clinicId){
        return feedBackService.getFeedbackDoctorsByClinicId(clinicId);
    }
    @GetMapping
    public List<FeedBack> getFeedBackClinicByClinicId(@RequestParam(name = "clinic_id") long clinicId) {
        return feedBackService.feedBackList(clinicId);
    }

}

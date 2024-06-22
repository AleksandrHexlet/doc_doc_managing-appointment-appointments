package com.docdoc.doc_doc_managingappointmentappointments.controller;

import com.docdoc.doc_doc_managingappointmentappointments.model.db.DoctorAppointment;
import com.docdoc.doc_doc_managingappointmentappointments.model.db.FeedBack;
import com.docdoc.doc_doc_managingappointmentappointments.service.DoctorService;
import com.docdoc.doc_doc_managingappointmentappointments.service.FeedBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/managing/appointment")
public class ManagingAppointmentsController {
    private final FeedBackService feedBackService;
    private final DoctorService doctorService;

    @Autowired
    public ManagingAppointmentsController(FeedBackService feedBackService, DoctorService doctorService) {
        this.feedBackService = feedBackService;
        this.doctorService = doctorService;
    }

    @GetMapping("/feedback")
    public List<FeedBack> getFeedBackClinicByClinicId(@RequestParam(name = "clinic_id") long clinicId) {
        return feedBackService.feedBackList(clinicId);
    }

    @PostMapping("reserve_time_doctor")
    public long reserveTimeDoctor(@RequestParam LocalDateTime date,
                                     @RequestParam long doctorId, @RequestParam long clinicId,
                                  @RequestParam long userId) {
        try{
            return doctorService.reserveTimeDoctor(date,
                    doctorId, clinicId,userId);
        } catch (Exception exception){
            throw new ResponseStatusException(HttpStatusCode.valueOf(500),exception.getMessage());
        }

    }
    @PutMapping("cancel_time_doctor")
    public Boolean cancelReserveTimeDoctor(@RequestParam long appointmentId, @RequestParam DoctorAppointment.AppointmentStatus appointmentStatus) {
        return doctorService.cancelReserveTimeDoctor(appointmentId,appointmentStatus);
    }


}
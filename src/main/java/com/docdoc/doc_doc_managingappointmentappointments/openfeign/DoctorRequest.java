package com.docdoc.doc_doc_managingappointmentappointments.openfeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.time.LocalTime;

@FeignClient(value = "Doctor", url = "http://localhost:8080/doctor")
public interface DoctorRequest {

    @PutMapping("/reserve_time")
    LocalTime reserveTime(@RequestParam LocalDateTime date,
                          @RequestParam long doctorId, @RequestParam long clinicId);

    @PutMapping("/cancel_reserve")
    boolean cancelReserve(@RequestParam LocalDateTime date,
                          @RequestParam long doctorId, @RequestParam long clinicId);
}

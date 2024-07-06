package com.docdoc.doc_doc_managingappointmentappointments.model.dto.db;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReserveTimeResponse {
    private LocalTime reserveTimeTo;
    private long idDailySchedule;
}

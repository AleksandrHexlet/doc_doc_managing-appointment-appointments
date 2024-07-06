package com.docdoc.doc_doc_managingappointmentappointments.model.dto.db;

public interface ClinicProfitsByPeriod {
    long getClinicId();
    double getProfitByClinic();
}
//Реализуем подтверждение записи.
//Если в течение 10 минут пользователь не подтверждает запись, она автоматически отменяется
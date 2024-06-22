package com.docdoc.doc_doc_managingappointmentappointments.model.db;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity

@Table(name = "doctor_appointment")
public class DoctorAppointment {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @Column(name ="date")
    @NotNull
    private LocalDateTime date;

    @Column(name ="time_to")
    @NotNull
    private LocalTime timeTo;
    @Column(name ="time_from")
    @NotNull
    private LocalTime timeFrom;

    @JoinColumn(name ="doctor_id")
    @Positive
    private long doctorId;

    @JoinColumn(name = "clinic_id")
    @Positive
    private long clinicId;

    @JoinColumn(name = "user_id")
    @Positive
    private long userId;


    @Enumerated(EnumType.STRING)
    @Column(name = "appointment_status")
    @NotNull
    private AppointmentStatus appointmentStatus;

    public enum AppointmentStatus {
        NEW,
        APPOINTMENT_COMPLETED,
        DOCTOR_CANCELLED,
        PATIENT_CANCELED,
        CANCELLED
    }
}



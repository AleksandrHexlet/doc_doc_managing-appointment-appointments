package com.docdoc.doc_doc_managingappointmentappointments.model.db;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity

@Table(name = "visit_doctor")
public class VisitDoctor {
    @Id
    @GeneratedValue
    private long id;

    @Column(name = "diagnosis")
    @NotEmpty
    @Size(min = 1, max = 500)
    private String diagnosis;

    @Column(name = "recommendations", columnDefinition = "text[]")
    @JdbcTypeCode(SqlTypes.ARRAY)
    private ArrayList<@NotEmpty @NotNull @NotBlank String> recommendations;

    @OneToOne
    @JoinColumn(name = "doctor_appointment_id")
    @NotNull
    @Valid
    private DoctorAppointment doctorAppointment;

    @OneToOne(mappedBy = "visitDoctor")
    private FeedBack feedBack;

}

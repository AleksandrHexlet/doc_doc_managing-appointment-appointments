package com.docdoc.doc_doc_managingappointmentappointments.model.db;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity

@Table(name = "feedback",indexes = @Index(name = "doctor_id_index", columnList = "doctorId"))
public class FeedBack {

    @Id
    @GeneratedValue
    private Long id;
//    mappedBy  для OneToOne; OneToMany; ManyToMany и в этой таблице не будет такого поля, это обраная сторона. Будет только у владельца связи, там где @JoinColumn

    @NonNull
    @Size(min = 1, max = 500)
    @Column(name ="text", length = 500)
    private String text;
    @NonNull
    private LocalDateTime date;


    @OneToOne
    @JoinColumn(name = "visit_doctor")
    private VisitDoctor visitDoctor;

}

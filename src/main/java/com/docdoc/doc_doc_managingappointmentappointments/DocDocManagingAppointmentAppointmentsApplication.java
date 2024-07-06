package com.docdoc.doc_doc_managingappointmentappointments;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DocDocManagingAppointmentAppointmentsApplication {

    public static void main(String[] args) {
        SpringApplication.run(DocDocManagingAppointmentAppointmentsApplication.class, args);
        System.out.println("Server is RUN");
    }

}

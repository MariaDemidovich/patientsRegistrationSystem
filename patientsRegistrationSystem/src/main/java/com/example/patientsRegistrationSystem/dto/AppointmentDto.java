package com.example.patientsRegistrationSystem.dto;

import com.example.patientsRegistrationSystem.common.Status;
import com.example.patientsRegistrationSystem.domains.Doctor;
import com.example.patientsRegistrationSystem.domains.Patient;
import com.example.patientsRegistrationSystem.domains.Schedule;
import lombok.Data;

@Data
public class AppointmentDto {

    private Long id;
    private Patient patient;
    private Doctor doctor;
    private Schedule schedule;
    private Status status;

}

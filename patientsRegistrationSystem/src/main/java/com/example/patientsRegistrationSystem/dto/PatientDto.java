package com.example.patientsRegistrationSystem.dto;

import com.example.patientsRegistrationSystem.domains.Appointment;
import com.example.patientsRegistrationSystem.domains.FullName;
import com.example.patientsRegistrationSystem.domains.MedRecords;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class PatientDto {

    private Long id;
    private FullName fullName;
    private String email;
    private LocalDate dateOfBirth;
    private String address;
    private List<MedRecords> medRecords;
    private List<Appointment> appointments;

}

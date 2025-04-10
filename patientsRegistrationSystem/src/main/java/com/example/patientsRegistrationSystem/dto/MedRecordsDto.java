package com.example.patientsRegistrationSystem.dto;
import com.example.patientsRegistrationSystem.domains.Doctor;
import com.example.patientsRegistrationSystem.domains.Patient;
import com.example.patientsRegistrationSystem.domains.TestResults;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class MedRecordsDto {

    private Long id;
    private Patient patient;
    private Doctor doctor;
    private LocalDateTime data;
    private String diagnosis;
    private String treatment;
    private List<TestResults> testResults;

}

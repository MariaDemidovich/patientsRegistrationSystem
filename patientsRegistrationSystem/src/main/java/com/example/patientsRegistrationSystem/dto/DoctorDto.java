package com.example.patientsRegistrationSystem.dto;

import com.example.patientsRegistrationSystem.common.Major;
import com.example.patientsRegistrationSystem.domains.Appointment;
import com.example.patientsRegistrationSystem.domains.FullName;
import com.example.patientsRegistrationSystem.domains.MedRecords;
import com.example.patientsRegistrationSystem.domains.Schedule;
import lombok.Data;

import java.util.List;

@Data
public class DoctorDto {

    private Long id;
    private FullName fullName;
    private String email;
    private Major major;
    private List<MedRecords> medRecords;
    private List<Schedule> schedules;
    private List<Appointment> appointments;

}

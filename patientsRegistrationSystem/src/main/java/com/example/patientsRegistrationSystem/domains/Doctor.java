package com.example.patientsregistrationsystem.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "doctors")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullname;
    private String email;
    private String password;
    private String major;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
    private List<com.example.patientsregistrationsystem.domain.MedRecords> medRecords;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
    private List<com.example.patientsregistrationsystem.domain.Schedule> schedules;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
    private List<com.example.patientsregistrationsystem.domain.Appointment> appointments;
}

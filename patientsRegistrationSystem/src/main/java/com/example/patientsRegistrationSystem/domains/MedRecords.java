package com.example.patientsregistrationsystem.domain;

import com.example.patientsRegistrationSystem.domains.Patient;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "med_records")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MedRecords {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private com.example.patientsregistrationsystem.domain.Doctor doctor;

    private String data;
    private String diagnosis;
    private String treatment;

    @OneToMany(mappedBy = "medRecords", cascade = CascadeType.ALL)
    private List<com.example.patientsregistrationsystem.domain.TestResults> testResults;
}

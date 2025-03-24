package com.example.patientsregistrationsystem.domain;

import com.example.patientsRegistrationSystem.domains.Patient;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "appointments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private com.example.patientsregistrationsystem.domain.Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "schedule_id", nullable = false)
    private com.example.patientsregistrationsystem.domain.Schedule schedule;

    private String status;
}

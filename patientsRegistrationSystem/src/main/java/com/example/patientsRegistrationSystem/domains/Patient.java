package com.example.patientsRegistrationSystem.domains;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "patients")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullname;
    private String email;
    private String password;
    private String dateOfBirth;
    private String address;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private List<com.example.patientsregistrationsystem.domain.MedRecords> medRecords;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private List<com.example.patientsregistrationsystem.domain.Appointment> appointments;
}

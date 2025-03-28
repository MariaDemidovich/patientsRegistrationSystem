package com.example.patientsRegistrationSystem.domains;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "med_records", schema = "public")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MedRecords {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", referencedColumnName = "id", nullable = false)
    private Patient patient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id", referencedColumnName = "id", nullable = false)
    private Doctor doctor;

    @Column(nullable = false)
    private LocalDateTime data;

    @Column(nullable = false, length = 500)
    private String diagnosis;

    @Column(nullable = false, length = 1000)
    private String treatment;

    @OneToMany(mappedBy = "medRecords", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<TestResults> testResults;
}
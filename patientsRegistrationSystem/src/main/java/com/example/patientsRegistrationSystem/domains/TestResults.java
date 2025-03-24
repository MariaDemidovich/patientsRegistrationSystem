package com.example.patientsregistrationsystem.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "test_results")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TestResults {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "medRecords_id", nullable = false)
    private com.example.patientsregistrationsystem.domain.MedRecords medRecords;

    private String testType;
    private String results;
    private String data;
}

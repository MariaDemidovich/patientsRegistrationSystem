package com.example.patientsRegistrationSystem.domains;

import com.example.patientsRegistrationSystem.common.TestType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "test_results", schema = "public")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TestResults {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medRecords_id", referencedColumnName = "id", nullable = false)
    private MedRecords medRecords;

    @Enumerated(EnumType.STRING)
    private TestType testType;
    private String results;
    private String data;
}

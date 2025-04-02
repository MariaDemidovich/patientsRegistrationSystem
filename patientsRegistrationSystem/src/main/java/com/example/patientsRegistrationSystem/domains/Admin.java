package com.example.patientsRegistrationSystem.domains;

import com.example.patientsRegistrationSystem.common.AccessLevel;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "admin", schema = "public")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private FullName fullName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AccessLevel accessLevel;
}
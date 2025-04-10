package com.example.patientsRegistrationSystem.repository;

import com.example.patientsRegistrationSystem.domains.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
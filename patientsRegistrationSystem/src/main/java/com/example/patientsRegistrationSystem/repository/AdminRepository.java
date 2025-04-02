package com.example.patientsRegistrationSystem.repository;

import com.example.patientsRegistrationSystem.domains.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}

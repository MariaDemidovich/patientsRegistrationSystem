package com.example.patientsRegistrationSystem.controller;

import com.example.patientsRegistrationSystem.common.AccessLevel;
import com.example.patientsRegistrationSystem.domains.Admin;
import com.example.patientsRegistrationSystem.domains.Schedule;
import com.example.patientsRegistrationSystem.dto.AdminDto;
import com.example.patientsRegistrationSystem.dto.DoctorDto;
import com.example.patientsRegistrationSystem.domains.Doctor;
import com.example.patientsRegistrationSystem.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admins")
public class AdminController {

    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/patients")
    public ResponseEntity<?> addPatient(@RequestBody AdminDto adminDto) {
        try {
            adminService.addPatient(adminDto);
            return ResponseEntity.status(HttpStatus.CREATED).body("Patient added successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to add patient");
        }
    }

    @PutMapping("/patients/{patientId}")
    public ResponseEntity<?> updatePatient(@PathVariable Long patientId, @RequestBody AdminDto adminDto) {
        try {
            adminService.updatePatient(adminDto);
            return ResponseEntity.ok("Patient updated successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to update patient");
        }
    }

    @DeleteMapping("/patients/{patientId}")
    public ResponseEntity<?> deletePatient(@PathVariable Long patientId) {
        try {
            adminService.deletePatient(patientId);
            return ResponseEntity.ok("Patient deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Patient not found");
        }
    }

    @GetMapping("/patients")
    public ResponseEntity<List<Admin>> getAllPatients() {
        List<Admin> admins = adminService.getAllPatients();
        return ResponseEntity.ok(admins);
    }

    @PutMapping("/role/{userId}")
    public ResponseEntity<?> assignRole(@PathVariable Long userId, @RequestParam AccessLevel newRole) {
        try {
            adminService.RoleAssign(userId, newRole);
            return ResponseEntity.ok("Role assigned successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
    }

    @PostMapping("/doctors")
    public ResponseEntity<?> addDoctor(@RequestBody Doctor doctor) {
        try {
            adminService.addDoctor(doctor);
            return ResponseEntity.status(HttpStatus.CREATED).body("Doctor added successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to add doctor");
        }
    }

    @PutMapping("/doctors/{doctorId}")
    public ResponseEntity<?> updateDoctor(@PathVariable Long doctorId, @RequestBody DoctorDto doctorDto) {
        try {
            adminService.updateDoctor(doctorId, doctorDto);
            return ResponseEntity.ok("Doctor updated successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Doctor not found");
        }
    }

    @DeleteMapping("/doctors/{doctorId}")
    public ResponseEntity<?> deleteDoctor(@PathVariable Long doctorId) {
        try {
            adminService.deleteDoctor(doctorId);
            return ResponseEntity.ok("Doctor deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Doctor not found");
        }
    }

    @GetMapping("/doctors")
    public ResponseEntity<List<Doctor>> getAllDoctors() {
        List<Doctor> doctors = adminService.getAllDoctors();
        return ResponseEntity.ok(doctors);
    }

    @PutMapping("/doctors/{doctorId}/schedule")
    public ResponseEntity<?> updateDoctorSchedule(@PathVariable Long doctorId, @RequestBody Schedule schedule) {
        try {
            adminService.updateDoctorSchedule(doctorId, schedule);
            return ResponseEntity.ok("Doctor's schedule updated successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Doctor not found or failed to update schedule");
        }
    }
}
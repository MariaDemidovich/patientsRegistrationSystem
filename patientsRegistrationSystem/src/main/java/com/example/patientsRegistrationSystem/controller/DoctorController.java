package com.example.patientsRegistrationSystem.controller;

import com.example.patientsRegistrationSystem.dto.AppointmentDto;
import com.example.patientsRegistrationSystem.dto.MedRecordsDto;
import com.example.patientsRegistrationSystem.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    private final DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping("/patients/{patientId}")
    public ResponseEntity<?> getPatientById(@PathVariable Long patientId) {
        try {
            doctorService.getPatientById(patientId);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Patient not found");
        }
    }

    @GetMapping("/patients")
    public ResponseEntity<?> getAllPatients() {
        try {
            doctorService.getAllPatients();
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to fetch patients");
        }
    }

    @PostMapping("/patients/{patientId}/medical-records")
    public ResponseEntity<?> addMedicalRecord(
            @PathVariable Long patientId,
            @RequestBody MedRecordsDto medRecordDto) {
        try {
            doctorService.addMedicalRecord(patientId, medRecordDto);
            return ResponseEntity.status(HttpStatus.CREATED).body("Medical record added successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to add medical record");
        }
    }

    @PutMapping("/patients/{patientId}/treatment")
    public ResponseEntity<?> assignTreatment(
            @PathVariable Long patientId,
            @RequestBody MedRecordsDto treatment) {
        try {
            doctorService.assignTreatment(patientId, treatment);
            return ResponseEntity.ok("Treatment assigned successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to assign treatment");
        }
    }

    @PostMapping("/patients/{patientId}/appointments")
    public ResponseEntity<?> scheduleAppointment(
            @PathVariable Long patientId,
            @RequestBody AppointmentDto appointment) {
        try {
            doctorService.scheduleAppointment(patientId, appointment);
            return ResponseEntity.status(HttpStatus.CREATED).body("Appointment scheduled successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to schedule appointment");
        }
    }
}

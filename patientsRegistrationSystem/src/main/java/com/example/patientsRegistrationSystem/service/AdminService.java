package com.example.patientsRegistrationSystem.service;

import com.example.patientsRegistrationSystem.common.AccessLevel;
import com.example.patientsRegistrationSystem.domains.Admin;
import com.example.patientsRegistrationSystem.domains.Doctor;
import com.example.patientsRegistrationSystem.domains.Schedule;
import com.example.patientsRegistrationSystem.dto.AdminDto;
import com.example.patientsRegistrationSystem.dto.DoctorDto;
import com.example.patientsRegistrationSystem.mapper.AdminMapper;
import com.example.patientsRegistrationSystem.mapper.DoctorMapper;
import com.example.patientsRegistrationSystem.repository.AdminRepository;
import com.example.patientsRegistrationSystem.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 *
 * Service can have Repository level classes
 * ------------------------------------------
 *
 * Controller can have service and api levels classes
 * ------------------------------------------
 *
 * You must use dto classes for data transporting
 * For creating dto from entity you can and should use Mapper
 * -----------------------------------------
 *
 * When you write create method or update method you should receive as param Creation or Update Request,
 * so I have already created package for that classes
 * -----------------------------------------
 * */
@Service
public class AdminService {

    private final AdminRepository adminRepository;
    private final AdminMapper adminMapper;
    private final DoctorRepository doctorRepository;
    private final DoctorMapper doctorMapper;

    @Autowired
    public AdminService(AdminRepository adminRepository, AdminMapper adminMapper, DoctorRepository doctorRepository, DoctorMapper doctorMapper) {
        this.adminRepository = adminRepository;
        this.adminMapper = adminMapper;
        this.doctorRepository = doctorRepository;
        this.doctorMapper = doctorMapper;
    }

    public void addPatient(AdminDto adminDto) {
        Admin admin = adminMapper.toDomain(adminDto);
        adminRepository.save(admin);
    }

    public void updatePatient(AdminDto adminDto) {
        //todo
    }

    public void deletePatient(Long patientId) {
        Optional<Admin> optionalAdmin = adminRepository.findById(patientId);

        if (optionalAdmin.isPresent()) {
            adminRepository.delete(optionalAdmin.get());
        } else {
            throw new RuntimeException("Patient not found with id: " + patientId);
        }
    }


    public List<Admin> getAllPatients() {
        return adminRepository.findAll();
    }

    public void RoleAssign(Long userId, AccessLevel newRole) {
        Optional<Admin> optional = adminRepository.findById(userId);
        optional.ifPresent(admin -> {
            admin.setAccessLevel(newRole);
            adminRepository.save(admin);
        });
    }

    public void addDoctor(Doctor doctor) {
        // todo
    }

    public void updateDoctor(Long doctorId, DoctorDto updatedDoctor) {
        Doctor existingDoctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new RuntimeException("Doctor not found"));

        doctorMapper.updateDoctorFromDto(updatedDoctor, existingDoctor);
        doctorRepository.save(existingDoctor);
    }

    public void deleteDoctor(Long doctorId) {
        if (!doctorRepository.existsById(doctorId)) {
            throw new RuntimeException("Doctor not found with id: " + doctorId);
        }

        doctorRepository.deleteById(doctorId);
    }

    public List<Doctor> getAllDoctors() {
        // todo
        return null;
    }

    public void setAccessLevel(Long userId, AccessLevel accessLevel) {
        // todo
    }

    public void updateDoctorSchedule(Long doctorId, Schedule schedule) {
        // todo
    }

}

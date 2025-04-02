package com.example.patientsRegistrationSystem.service;

import com.example.patientsRegistrationSystem.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
@RequiredArgsConstructor
@Service
public class AdminService {

    private final AdminRepository adminRepository;

//    TODO WRITE METHODS
}

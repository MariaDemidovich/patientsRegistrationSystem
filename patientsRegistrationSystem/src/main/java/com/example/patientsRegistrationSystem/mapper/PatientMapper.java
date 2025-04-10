package com.example.patientsRegistrationSystem.mapper;

import com.example.patientsRegistrationSystem.domains.Patient;
import com.example.patientsRegistrationSystem.dto.PatientDto;
import org.mapstruct.Mapper;

import javax.swing.*;
import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface PatientMapper extends BaseMapper <Patient, PatientDto>{

    @Override
    Patient toDomain(PatientDto dto);

    @Override
    PatientDto toDto(Patient domain);

    @Override
    List<Patient> toDomains(List<PatientDto> dtos);

    @Override
    List<PatientDto> toDtos(List<Patient> domains);

    @Override
    Set<PatientDto> toDtos(Set<Patient> domains);

    @Override
    Set<Patient> toDomains(Set<PatientDto> dtos);

}

package com.example.patientsRegistrationSystem.mapper;

import com.example.patientsRegistrationSystem.domains.Doctor;
import com.example.patientsRegistrationSystem.dto.DoctorDto;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface DoctorMapper extends BaseMapper<Doctor, DoctorDto>{

    @Override
    Doctor toDomain(DoctorDto dto);

    @Override
    DoctorDto toDto(Doctor domain);

    @Override
    List<Doctor> toDomains(List<DoctorDto> dtos);

    @Override
    List<DoctorDto> toDtos(List<Doctor> domains);

    @Override
    Set<DoctorDto> toDtos(Set<Doctor> domains);

    @Override
    Set<Doctor> toDomains(Set<DoctorDto> dtos);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateDoctorFromDto(DoctorDto dto, @MappingTarget Doctor entity);

}

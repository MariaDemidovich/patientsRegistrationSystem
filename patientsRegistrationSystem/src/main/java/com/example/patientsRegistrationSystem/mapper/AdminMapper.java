package com.example.patientsRegistrationSystem.mapper;

import com.example.patientsRegistrationSystem.domains.Admin;
import com.example.patientsRegistrationSystem.dto.AdminDto;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface AdminMapper extends BaseMapper<Admin, AdminDto> {

    @Override
    Admin toDomain(AdminDto dto);

    @Override
    AdminDto toDto(Admin domain);

    @Override
    List<Admin> toDomains(List<AdminDto> dtos);

    @Override
    List<AdminDto> toDtos(List<Admin> domains);

    @Override
    Set<AdminDto> toDtos(Set<Admin> domains);

    @Override
    Set<Admin> toDomains(Set<AdminDto> dtos);
}
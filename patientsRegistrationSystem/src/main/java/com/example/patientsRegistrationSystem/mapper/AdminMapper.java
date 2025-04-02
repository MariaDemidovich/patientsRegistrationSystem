package com.example.patientsRegistrationSystem.mapper;

import com.example.patientsRegistrationSystem.domains.Admin;
import com.example.patientsRegistrationSystem.dto.AdminDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AdminMapper extends BaseMapper<Admin, AdminDto>{
}

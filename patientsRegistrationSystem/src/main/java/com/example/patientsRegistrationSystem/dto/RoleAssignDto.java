package com.example.patientsRegistrationSystem.dto;

import com.example.patientsRegistrationSystem.common.AccessLevel;
import lombok.Data;

@Data
public class RoleAssignDto {
    private Long userId;
    private AccessLevel newRole;
}
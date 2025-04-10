package com.example.patientsRegistrationSystem.dto;

import com.example.patientsRegistrationSystem.common.AccessLevel;
import com.example.patientsRegistrationSystem.domains.FullName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AdminDto {
    private Long id;
    private FullName fullName;
    private String email;
    private AccessLevel accessLevel;
}

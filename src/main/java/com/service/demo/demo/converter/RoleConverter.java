package com.service.demo.demo.converter;

import com.service.demo.demo.dto.role.RoleResponse;
import com.service.demo.demo.dto.role.RoleSaveRequest;
import com.service.demo.demo.dto.role.RoleUpdateRequest;
import com.service.demo.demo.entity.Role;
import org.springframework.stereotype.Component;

@Component
public class RoleConverter {

    public Role convert(RoleSaveRequest roleSaveRequest) {
        return Role.builder()
                .name(roleSaveRequest.getName())
                .build();
    }

    public RoleResponse convert(Role role) {
        return RoleResponse.builder()
                .id(role.getId())
                .name(role.getName())
                .build();
    }

    public Role convert(RoleUpdateRequest roleUpdateRequest) {
        return Role.builder()
                .id(roleUpdateRequest.getId())
                .name(roleUpdateRequest.getName())
                .build();
    }
}

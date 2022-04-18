package com.service.demo.demo.dto.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.service.demo.demo.dto.role.RoleResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class UserResponse {

    private Long id;
    private String username;
    @JsonProperty(value = "role")
    private RoleResponse roleResponse;
}

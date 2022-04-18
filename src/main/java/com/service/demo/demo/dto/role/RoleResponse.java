package com.service.demo.demo.dto.role;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RoleResponse {
    private Long id;
    private String name;
}

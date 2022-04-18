package com.service.demo.demo.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Builder
@AllArgsConstructor
@Data
public class UserSaveRequest {

    @NotNull
    private String username;

    @NotNull
    private String password;
}

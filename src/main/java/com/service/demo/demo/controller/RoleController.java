package com.service.demo.demo.controller;

import com.service.demo.demo.converter.RoleConverter;
import com.service.demo.demo.dto.role.RoleResponse;
import com.service.demo.demo.dto.role.RoleSaveRequest;
import com.service.demo.demo.dto.role.RoleUpdateRequest;
import com.service.demo.demo.entity.Role;
import com.service.demo.demo.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/roles")
public class RoleController {

    private final RoleService roleService;
    private final RoleConverter roleConverter;

    @GetMapping
    public ResponseEntity<Set<RoleResponse>> findAll() {
        return ResponseEntity.ok(roleService.findAll()
                .stream()
                .map(roleConverter::convert)
                .collect(Collectors.toSet()));
    }

    @PostMapping
    public ResponseEntity<RoleResponse> save(@RequestBody @Valid RoleSaveRequest roleSaveRequest) {
        Role role = roleConverter.convert(roleSaveRequest);
        Role savedRole = roleService.save(role);
        RoleResponse response = roleConverter.convert(savedRole);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping
    public ResponseEntity<RoleResponse> update(@RequestBody @Valid RoleUpdateRequest roleUpdateRequest) {
        Role role = roleConverter.convert(roleUpdateRequest);
        Role updatedRole = roleService.update(role, role.getId());
        return ResponseEntity.ok(roleConverter.convert(updatedRole));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Long id) {
        roleService.delete(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/name/{name}")
    public ResponseEntity<HttpStatus> delete(@PathVariable String name) {
        roleService.delete(name);
        return ResponseEntity.ok().build();
    }
}

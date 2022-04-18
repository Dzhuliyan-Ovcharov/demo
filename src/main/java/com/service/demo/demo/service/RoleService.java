package com.service.demo.demo.service;

import com.service.demo.demo.entity.Role;
import com.service.demo.demo.exception.DuplicateRecordException;
import com.service.demo.demo.exception.RecordNotFoundException;
import com.service.demo.demo.repository.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Service
@AllArgsConstructor
@Transactional
public class RoleService {

    private final RoleRepository roleRepository;

    public Set<Role> findAll() {
        return new HashSet<>(roleRepository.findAll());
    }

    public Role findByName(String name) {
        return roleRepository.findByName(name)
                .orElseThrow(() -> new RecordNotFoundException(
                        String.format("Role %s not found.", name)
                ));
    }

    public Role findById(Long id) {
        return roleRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException(
                        String.format("Role with id: %s not found.", id)
                ));
    }

    public Role update(Role updatedRole, Long id) {
        Objects.requireNonNull(id);
        Objects.requireNonNull(updatedRole);

        Role dbRole = findById(id);
        dbRole.setName(updatedRole.getName());
        return dbRole;
    }

    public Role save(Role role) {
        try {
            return roleRepository.save(role);
        } catch (DataIntegrityViolationException ex) {
            throw new DuplicateRecordException(
                    String.format("Role name: %s already exists.", role.getName())
            );
        }
    }

    public void delete(Long id) {
        roleRepository.deleteById(id);
    }

    public void delete(String name) throws IllegalArgumentException {
        roleRepository.deleteByName(name);
    }
}

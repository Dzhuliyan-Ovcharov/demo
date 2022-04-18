package com.service.demo.demo.service;

import com.service.demo.demo.entity.Role;
import com.service.demo.demo.entity.User;
import com.service.demo.demo.exception.DuplicateRecordException;
import com.service.demo.demo.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final RoleService roleService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public Set<User> findAll() {
        return new HashSet<>(userRepository.findAll());
    }

    public User save(User user) {
        try {
            Role role = roleService.findByName("CUSTOMER");
            user.setRole(role);
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            return userRepository.save(user);
        } catch (DataIntegrityViolationException ex) {
            throw new DuplicateRecordException(
                    String.format("Username %s already exists.", user.getUsername())
            );
        }
    }
}

package com.service.demo.demo.starter;

import com.service.demo.demo.entity.Role;
import com.service.demo.demo.entity.User;
import com.service.demo.demo.service.RoleService;
import com.service.demo.demo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DemoStarter implements CommandLineRunner {

    private final RoleService roleService;
    private final UserService userService;

    @Override
    public void run(String... args) throws Exception {
//        Role firstRole = new Role();
//        firstRole.setName("ADMIN");
//        Role secondRole = new Role();
//        secondRole.setName("CUSTOMER");
//        roleService.save(firstRole);
//        roleService.save(secondRole);
//        Role updateSecondRole = new Role();
//        updateSecondRole.setName("UPDATE_CUSTOMER");
//        roleService.update(updateSecondRole, secondRole.getId());
//
//        User user = new User();
//        user.setUsername("Gosho");
//        user.setPassword("12345");
//        userService.save(user);
    }
}

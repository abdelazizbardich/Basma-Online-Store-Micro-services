package com.basmaonlinestore.authorisationserver;

import com.basmaonlinestore.authorisationserver.models.Role;
import com.basmaonlinestore.authorisationserver.models.User;
import com.basmaonlinestore.authorisationserver.services.RoleService;
import com.basmaonlinestore.authorisationserver.services.UDService;
import com.basmaonlinestore.authorisationserver.services.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class MyWebApplication {

    public static void main(String[] args) {
        ApplicationContext context =  SpringApplication.run(MyWebApplication.class, args);

        // Create an admin role if not exist
        RoleService roleService = context.getBean(RoleService.class);
        Role role = new Role();
        role.setName("ROLE_ADMIN");
        roleService.add(role);
        role = new Role();
        role.setName("ROLE_USER");
        roleService.add(role);

        // Create an admin if not exist
        UserService userService = context.getBean(UserService.class);
        User user = new User();
        user.setRole(roleService.getByName("ROLE_ADMIN"));
        user.setLogin("admin");
        PasswordEncoder passwordEncoder = context.getBean(PasswordEncoder.class);
        user.setPassword(passwordEncoder.encode("pass1234"));
        userService.add(user);

    }

}
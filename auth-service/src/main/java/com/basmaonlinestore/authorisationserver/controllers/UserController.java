package com.basmaonlinestore.authorisationserver.controllers;

import com.basmaonlinestore.authorisationserver.services.UserService;
import com.basmaonlinestore.authorisationserver.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping("/user")
@RolesAllowed("ROLE_ADMIN")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public List<User> getAll(){
        return userService.getAll();
    }

    @GetMapping("/find/{id}")
    public User find(@PathVariable("id") Long id){
        return userService.get(id);
    }

    @PutMapping("/update/{id}")
    public User update(@RequestBody User user,@PathVariable("id") Long id){
        user.setUserId(id);
        return userService.update(user);
    }

    @PostMapping("/add")
    public User store(@RequestBody User user){
        return userService.add(user);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@RequestBody User user){
        return userService.delete(user);
    }

    @PostMapping("/login")
    public User login(@RequestBody User user){
        return userService.login(user);
    }

    @PostMapping("/password/reset")
    public User resetPassword(@RequestBody User user){
        return userService.resetPassword(user);
    }
}

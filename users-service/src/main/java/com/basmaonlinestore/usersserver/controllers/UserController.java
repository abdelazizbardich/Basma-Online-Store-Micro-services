package com.basmaonlinestore.usersserver.controllers;

import com.basmaonlinestore.usersserver.models.User;
import com.basmaonlinestore.usersserver.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.status(200).body(userService.getAllUsers());
    }

    @GetMapping("/{idUser}")
    public ResponseEntity<User> getUser(@PathVariable(name = "idUser") Long id){
        return ResponseEntity.status(200).body(userService.getUser(id));
    }

    @PostMapping("")
    public  ResponseEntity<User> addUser(@RequestBody User user){
        return ResponseEntity.status(200).body(userService.addUser(user));
    }

    @PutMapping("")
    public  ResponseEntity<User> updateUser(@RequestBody User user){
        return ResponseEntity.status(200).body(userService.updateUser(user));
    }

    @DeleteMapping("")
    public ResponseEntity deleteUser(@RequestBody User user){
        return ResponseEntity.status(200).body(userService.deleteUser(user.getIdUser()));
    }
}

package com.basmaonlinestore.usersserver.controllers;

import com.basmaonlinestore.usersserver.models.Role;
import com.basmaonlinestore.usersserver.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/role")
public class RoleController {

    private RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("")
    public ResponseEntity<List<Role>> getAllRoles(){
        return ResponseEntity.status(200).body(roleService.getAllRoles());
    }

    @GetMapping("/{idRole}")
    public ResponseEntity<Role> getRole(@PathVariable(name = "idRole") Long id){
        return ResponseEntity.status(200).body(roleService.getRole(id));
    }

    @PostMapping("")
    public  ResponseEntity<Role> addRole(@RequestBody Role user){
        return ResponseEntity.status(200).body(roleService.addRole(user));
    }

    @PutMapping("")
    public  ResponseEntity<Role> updateRole(@RequestBody Role user){
        return ResponseEntity.status(200).body(roleService.updateRole(user));
    }

    @DeleteMapping("")
    public ResponseEntity deleteRole(@RequestBody Role user){
        return ResponseEntity.status(200).body(roleService.deleteRole(user.getIdRole()));
    }
}

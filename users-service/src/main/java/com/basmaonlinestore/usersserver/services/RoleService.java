package com.basmaonlinestore.usersserver.services;

import com.basmaonlinestore.usersserver.models.Role;
import com.basmaonlinestore.usersserver.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    private RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<Role> getAllRoles(){
        try {
            return roleRepository.findAll();
        }catch (Exception e){
            System.err.println(e);
            return null;
        }
    }

    public Role getRole(long id){
        try {
            return roleRepository.findById(id).get();
        }catch (Exception e){
            System.err.println(e);
            return null;
        }
    }

    public Role addRole(Role role){
        try {
            return roleRepository.save(role);
        }catch (Exception e){
            System.err.println(e);
            return null;
        }
    }

    public Role updateRole(Role role){
        try {
            return roleRepository.save(role);
        }catch (Exception e){
            System.err.println(e);
            return null;
        }
    }

    public Boolean deleteRole(Long id){
        try {
            roleRepository.deleteById(id);
            return true;
        }catch (Exception e){
            System.err.println(e);
            return false;
        }
    }
}

package com.basmaonlinestore.authorisationserver.services;

import com.basmaonlinestore.authorisationserver.repositories.RoleRepository;
import com.basmaonlinestore.authorisationserver.models.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService implements Services<Role> {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> getAll() {
        return (List<Role>) roleRepository.findAll();
    }

    public Role getByName(String name){
        return roleRepository.findByName(name);
    }

    @Override
    public Role get(Long id) {
        return roleRepository.findById(id).get();
    }

    @Override
    public Role add(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role update(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public boolean delete(Role role) {
        try {
            roleRepository.delete(role);
            return true;
        }catch (DataAccessException e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}

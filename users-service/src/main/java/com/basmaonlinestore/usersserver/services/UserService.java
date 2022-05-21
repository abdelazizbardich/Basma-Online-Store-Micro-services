package com.basmaonlinestore.usersserver.services;

import com.basmaonlinestore.usersserver.models.User;
import com.basmaonlinestore.usersserver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers(){
        try {
            return userRepository.findAll();
        }catch (Exception e){
            System.err.println(e);
            return null;
        }
    }
    public User getUser(long id){
        try {
            return userRepository.findById(id).get();
        }catch (Exception e){
            System.err.println(e);
            return null;
        }
    }

    public User addUser(User user){
        try {
            return userRepository.save(user);
        }catch (Exception e){
            System.err.println(e);
            return null;
        }
    }

    public User updateUser(User user){
        try {
            return userRepository.save(user);
        }catch (Exception e){
            System.err.println(e);
            return null;
        }
    }

    public Boolean deleteUser(Long id){
        try {
            userRepository.deleteById(id);
            return true;
        }catch (Exception e){
            System.err.println(e);
            return false;
        }
    }
}

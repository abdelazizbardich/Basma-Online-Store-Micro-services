package com.basmaonlinestore.authorisationserver.services;

import com.basmaonlinestore.authorisationserver.repositories.UserRepository;
import com.basmaonlinestore.authorisationserver.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements Services<User>{
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAll() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User get(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User add(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(User user) {
        return userRepository.save(user);
    }

    @Override
    public boolean delete(User user) {
        try {
            userRepository.delete(user);
            return true;
        }catch (DataAccessException e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    public User login(User user){
        return userRepository.findByLogin(user.getLogin()).get();
    }

    public User resetPassword(User user){
        return userRepository.findByLogin(user.getLogin()).get();
    }
}

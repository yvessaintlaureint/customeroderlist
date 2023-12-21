package com.odp297.demo.service;

import com.odp297.demo.model.User;
import com.odp297.demo.repository.UserJPARepository;
import com.odp297.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserJPARepository userJPARepository;

    @Autowired
    public UserService(UserJPARepository userJPARepository){
        this.userJPARepository= userJPARepository;
    }

    public User createUser(User user){
        return userJPARepository.save(user);
    }

    public List<User> getAllUser(){
        return userJPARepository.findAll();
    }

    public Optional<User> getUserById(Long id){
        return userJPARepository.findById(id);
    }

    public User updateUser(Long id, User newUser) {
        Optional<User> optionalCustomer = userJPARepository.findById(id);

        if (optionalCustomer.isPresent()) {
            User user = optionalCustomer.get();
            user.setName(newUser.getName());
            user.setEmail(newUser.getEmail());

            return userJPARepository.save(user);
        } else {
            // Handle case where user with given id is not found
            return null;
        }
    }
}

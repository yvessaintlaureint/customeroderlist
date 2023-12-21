package com.odp297.demo.repository;

import com.odp297.demo.model.User;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {
    private final List<User> users = new ArrayList<>();

    private boolean userExists(Long id){
        return users.stream().anyMatch(user -> user.getId() != null && user.getId().equals(id));
    }

    private Long generateNewId() { return (long) (users.size()+1); }

    public User save(User user) {
        if (user.getId() == null || !userExists(user.getId())) {
            user.setId(generateNewId());
            users.add(user);
            return user;
        } else {
            // Handle case where user with given ID already exists
            return null;
        }
    }

    public List<User> findAll() {
        return users;
    }

    public Optional<User> findById(Long id){
        return users.stream().filter(user -> user.getId().equals(id)).findFirst();
    }
}

package com.demo.matchtap.services;

import com.demo.matchtap.entities.User;
import com.demo.matchtap.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository user;

    public User findById(Long id) {
        return user.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User save(User user) {
        return user.save(user);
    }

    public void delete(Long id) {
        user.deleteById(id);
    }
}


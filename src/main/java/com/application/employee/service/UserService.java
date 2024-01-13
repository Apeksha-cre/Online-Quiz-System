package com.application.employee.service;

import com.application.employee.entity.Users;
import com.application.employee.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Users createUser(Users user) {
        return userRepository.save(user);
    }

    public Users getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
    }


    public Users updateUser(Long id, Users updatedUser) {
        Users user = getUserById(id);
        user.setUsername(updatedUser.getUsername());
        user.setPassword(updatedUser.getPassword());
        user.setEmail(updatedUser.getEmail());
        user.setAdmin(updatedUser.isAdmin());
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        Users user = getUserById(id);
        userRepository.delete(user);
    }

    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }
}

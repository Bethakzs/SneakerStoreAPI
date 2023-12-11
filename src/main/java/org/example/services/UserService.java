package org.example.services;

import org.example.models.User;
import org.example.repo.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Page<User> getAllUsers(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    public User createUser(User user){
        return userRepository.save(user);
    }
    public Optional<User> getUser(Long id){
        return userRepository.findById(id);
    }
//    public Optional<User> removeUser(Long id){
//        Optional<User> user = userRepository.findById(id);
//        return userRepository.delete(user);
//    }
}
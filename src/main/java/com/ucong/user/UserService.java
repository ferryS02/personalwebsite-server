package com.ucong.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll(){
        return  userRepository.findAll();
    }

    public User save(User user){
        return userRepository.save(user);
    }

    public Optional<User> findById(UUID id){
        return userRepository.findById(id);
    }

    public void delete(UUID id) {
        userRepository.deleteById(id);
    }

    public Optional<User> findByUsernameOrEmail(String userName, String email){
        return  userRepository.findByUsernameOrEmail(userName, email);
    }

    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    public boolean existByEmail(String email) {
        return  userRepository.existsByEmail(email);
    }
}

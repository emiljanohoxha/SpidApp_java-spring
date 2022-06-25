package com.example.springapp.service;

//import com.example.springapp.entities.Spid;
import com.example.springapp.entities.User;
import com.example.springapp.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User createUser(User user) throws Exception {
        Boolean existsUser =userRepository
                .selectExistsUser(user.getId());
        if(existsUser){
            throw new Exception(
                    "user" +user.getId()+ "exists");
        }
        userRepository.save(user);
        return user;
    }

    public User updateUser(Long id, String name, String surname ,String username,String cardNo, String email, String password) throws Exception {
        Optional<User> user = userRepository.findById(id);
        if (name != null) {
            user.get().setName(name);
        }
        if (surname != null) {
            user.get().setSurname(surname);
        }
        if (username != null) {
            user.get().setUsername(username);
        }
        if (email != null) {
            user.get().setEmail(email);
        }
        if (password != null) {
            user.get().setPassword(password);
        }
        return userRepository.save(user.get());
    }

    public List<User> getAllUsers() {

        return userRepository.findAll();
    }

    public User getUser(Long id) {

        return userRepository.findById(id).get();
    }

    public void deleteUser(long id) {

        userRepository.deleteById(id);
    }


}
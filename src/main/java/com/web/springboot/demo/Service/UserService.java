package com.web.springboot.demo.Service;

import com.web.springboot.demo.Entities.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;




@Service
public class UserService {
    List<User> str_list = new ArrayList<User>();

    public User createUser(User user) {

        User savedUser = new User(user.getId(), user.getCreatedAt(), user.getCreatedBy(), user.getName(), user.getSurname(), user.getUsername());
        str_list.add(savedUser);
        System.out.println("ArrayList of users : " + str_list.toString());
        return savedUser;
    }


}

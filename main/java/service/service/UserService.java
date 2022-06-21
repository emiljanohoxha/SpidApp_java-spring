package service.service;
import entities.entites.Base;
import entities.entites.User;

import java.util.*;

public class UserService extends Base {

    List<User> str_list = new ArrayList<User>();

    public User createUser(String name, String surname, String username) {

        User user = new User(getId(), getCreatedAt(), getCreatedBy(), name, surname, username);
        str_list.add(user);
        System.out.println("ArrayList of users : " + str_list.toString());
        return user;
    }

}
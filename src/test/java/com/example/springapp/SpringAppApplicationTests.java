package com.example.springapp;


import com.example.springapp.entities.Spid;
import com.example.springapp.entities.StatusEnum;
import com.example.springapp.entities.TypeEnum;
import com.example.springapp.entities.User;
import com.example.springapp.service.SpidService;
import com.example.springapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;


@SpringBootTest(classes = {SpringbootDemoApplication.class})

class SpringAppApplicationTests {

    @Autowired
    private UserService userService;

    @Autowired
    private SpidService spidService;

    @Test
    public void test() {
        try {
            User user = userService.updateUser(1L,"al","pacino","12","alpaco","al@pacino","password");
            Spid spid = spidService.createSpid(new Spid(user, StatusEnum.PENDING, TypeEnum.Level_1));

        } catch (Exception err) {
            System.out.println(err);
        }
    }
}
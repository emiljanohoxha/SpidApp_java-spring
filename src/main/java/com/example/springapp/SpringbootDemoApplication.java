package com.example.springapp;

//import com.example.spid.entites.Spid;
//import com.example.springapp.entities.Spid;
import ch.qos.logback.core.status.Status;
import com.example.springapp.entities.Spid;
import com.example.springapp.entities.User;
import com.example.springapp.repository.UserRepository;
//import com.example.springapp.service.SpidService;
import com.example.springapp.service.SpidService;
import com.example.springapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Optional;

//@ComponentScan("com.example.springapp")
//@Configuration
//@EnableAutoConfiguration

@SpringBootApplication
public class SpringbootDemoApplication  {


    public static void main(String[] args) {
        SpringApplication.run(SpringbootDemoApplication.class, args);
    }



}

package com.web.springboot.demo;

import com.web.springboot.demo.Entities.Spid;
import com.web.springboot.demo.Entities.StatusEnum;
import com.web.springboot.demo.Entities.User;
import com.web.springboot.demo.Service.SpidService;
import com.web.springboot.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@ComponentScan("com.web.springboot.demo")
@Configuration
@EnableAutoConfiguration
public class SpringbootDemoApplication implements CommandLineRunner {

	@Autowired
	public UserService userService;
	@Autowired
	public SpidService spidService;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDemoApplication.class, args);
	}

	@Override
	public void run (String...args) throws Exception{
		SpidService spidService = new SpidService();
		UserService userService = new UserService();

		User newUser = userService.createUser(new User(1,new Date(),"sdfds","fdsfd","sdfd","sdsdfd"));
		System.out.println("newUser"+ newUser);

		Spid newSpid = spidService.createSpid(newUser,"sdsdfsd");
		System.out.println(newSpid.toString());

		try {
			spidService.approveSpid(0);
			spidService.editSpid(1, StatusEnum.READY_FOR_REVIEW);


		}catch(Exception e)
		{
			System.out.println(e);
		}
		spidService.listOfSpids();
	}
}


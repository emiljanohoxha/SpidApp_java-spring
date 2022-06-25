package com.example.springapp.service;

import com.example.springapp.entities.User;
import com.example.springapp.repository.UserRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class UserServiceTests {

    @Mock private UserRepository userRepository;

    private UserService underTest;

    @BeforeEach
    void setUp(){
        underTest = new UserService(userRepository);
    }

    @Test
    void canGetAllUsers(){
        underTest.getAllUsers();
        verify(userRepository).findAll();
    }
    @Test
    void canAddUser() throws Exception {
        // given
        User user = new User(
                1l,
                "John",
                "ben",
                "johnben",
                "243",
                "john@gmail.com",
                "password123"
        );

        // when
        underTest.createUser(user);

        // then
        ArgumentCaptor<User> userArgumentCaptor =
                ArgumentCaptor.forClass(User.class);

        verify(userRepository)
                .save(userArgumentCaptor.capture());

        User capturedUser = userArgumentCaptor.getValue();

        assertThat(capturedUser).isEqualTo(user);
    }

}

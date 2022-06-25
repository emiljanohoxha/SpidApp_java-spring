package com.example.springapp.service;


import com.example.springapp.entities.User;
import com.example.springapp.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
//@AutoConfigureTestDatabase
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryTests {
    @Autowired
    private UserRepository underTest;
    @AfterEach
    void tearDown() {
        underTest.deleteAll();
    }

    @Test
    void ifUserExists() {
        // given
        long id = 12L;
        User user = new User(
                1l,
                "Scarlet",
                "johanson",
                "carletee",
                "243",
                "acrlet@gmail.com",
                "password123"
        );
        underTest.save(user);

        // when
        boolean expected = underTest.selectExistsUser(id);

        // then
        assertThat(expected).isTrue();
    }
/**
 *      Fail tests
 * */

    @Test
    void ifUserDoesNotExists() {
        // given
        long id = 12L;

        // when
        boolean expected = underTest.selectExistsUser(id);

        // then
        assertThat(expected).isTrue();
    }
}

package com.example.springapp.repository;


import com.example.springapp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

//    List<User> findUserById(long id);
    @Query("" +
                "SELECT CASE WHEN COUNT(u) > 0 THEN " +
                "TRUE ELSE FALSE END " +
                "FROM User u " +
                "WHERE u.id = ?1 "
    )
    Boolean selectExistsUser(long id);

}

package com.example.springapp.repository;
import com.example.springapp.entities.Spid;
import com.example.springapp.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SpidRepository extends CrudRepository<Spid, Long> {

   List<Spid> findSpidsByUserId(User user);
    Boolean findSpidByUserId(User user);
}
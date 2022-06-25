package com.example.springapp.repository;//package com.example.springapp.repository;
//
//import com.example.springapp.entities.Spid;
//import com.example.springapp.entities.User;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//import javax.transaction.Transactional;
//import java.util.List;
//
//@Repository
//public interface SpidRepository extends JpaRepository<Spid, Long> {
//
////    List<Spid> findSpidByUser_Id();
//}



//import com.example.spid.entites.Spid;
////import com.example.spid.entites.Users;
import com.example.springapp.entities.Spid;
import com.example.springapp.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface SpidRepository extends CrudRepository<Spid, Long> {

   List<Spid> findSpidsByUserId(User user);
    Boolean findSpidByUserId(User user);
}
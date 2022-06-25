package com.example.springapp.service;


//import com.example.spid.entites.Spid;
//import com.example.springapp.entities.Spid;
import ch.qos.logback.core.status.Status;
import com.example.springapp.entities.Spid;
import com.example.springapp.entities.StatusEnum;
import com.example.springapp.entities.User;
import com.example.springapp.repository.SpidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class SpidService {

    @Autowired
    private SpidRepository spidRepository;


    public Spid getSpidByUserId(User user) {
        List<Spid> spids = spidRepository.findSpidsByUserId(user);
        return spids.get(0);
    }

    public Iterable<Spid> getAllSpids() {
        return spidRepository.findAll();
    }

    public Spid createSpid(Spid spid) throws Exception {
         Boolean existsSpid =spidRepository
                .findSpidByUserId(spid.getUserId());
        if(existsSpid ){
            throw new Exception(
                    "Spid with id:" +spid.getUserId()+ "already exists");
        }
        spid.setCreatedBy(spid.getUserId().getUsername());
      return  spidRepository.save(spid);
    }
    public Spid approveSpid(Spid spid) {
        spid.setStatus(StatusEnum.APPROVED);
        return spidRepository.save(spid);
    }

    public void deleteSpid(Spid spid) throws Exception {
        if (spid.getStatus() != StatusEnum.PENDING) {
            throw new Exception("YOU DONT HAVE PERMISSION TO DELETE THIS SPID");
        }
        spidRepository.delete(spid);
    }

}
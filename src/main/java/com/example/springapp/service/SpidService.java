package com.example.springapp.service;

import com.example.springapp.entities.Spid;
import com.example.springapp.entities.StatusEnum;
import com.example.springapp.entities.User;
import com.example.springapp.repository.SpidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpidService {
    @Autowired
    private SpidRepository spidRepository;

    /***
     *
     * @param user
     *              Get spid by user_id
     * @return
     */

    public Spid getSpidByUserId(User user) {
        List<Spid> spids = spidRepository.findSpidsByUserId(user);
        return spids.get(0);
    }

    /**
     *
     * @return  iteration of all spids
     */

    public Iterable<Spid> getAllSpids() {

        return spidRepository.findAll();
    }

    /**
     *
     * @param spid
     * @return  post method for spid
     * @throws Exception if user has already created a spid
     */

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

    /**
     *
     * @param spid
     * @return   initiliazes status
     */

    public Spid approveSpid(Spid spid) {
        spid.setStatus(StatusEnum.APPROVED);
        return spidRepository.save(spid);
    }

    /**
     *
     * @param spid  delete method for spid
     * @throws Exception if status is not pending
     */

    public void deleteSpid(Spid spid) throws Exception {
        if (spid.getStatus() != StatusEnum.PENDING) {
            throw new Exception("YOU DONT HAVE PERMISSION TO DELETE THIS SPID");
        }
        spidRepository.delete(spid);
    }

}
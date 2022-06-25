package com.example.springapp.service;

import com.example.springapp.entities.Spid;
import com.example.springapp.entities.StatusEnum;
import com.example.springapp.entities.User;
import com.example.springapp.repository.SpidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
     *@return spid by id
     * @throws Exception if spid doesn't exists.
     */

    public Spid findSpidById(long id) throws Exception {

        Optional<Spid> spid = spidRepository.findById(id);

        if (!spid.isPresent()) {
            throw new Exception("Spid doesn't exists!");
        }
        return spid.get();
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
        if(existsSpid){
            throw new Exception(
                    "Spid with id:" +spid.getUserId()+ "already exists");
        }
        spid.setCreatedBy(spid.getUserId().getUsername());
      return  spidRepository.save(spid);
    }

    /**
     *
     * @param
     * @return   initiliazes status
     */

    public Spid approveSpid(long id) throws Exception {
        Spid spid = findSpidById(id);
        spid.setStatus(StatusEnum.APPROVED);
        return spidRepository.save(spid);
    }

    /**
     *
     *
     * @throws Exception if status is not pending
     */

    public void deleteSpid(long id) throws Exception {
        Optional<Spid> spid = spidRepository.findById(id);
        if (spid.isPresent() && spid.get().getStatus() != StatusEnum.PENDING) {
            throw new Exception("YOU DONT HAVE PERMISSION TO DELETE THIS SPID");
        }
        spidRepository.delete(spid.get());
    }

}
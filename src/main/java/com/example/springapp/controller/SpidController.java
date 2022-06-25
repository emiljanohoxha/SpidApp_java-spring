package com.example.springapp.controller;

import com.example.springapp.entities.Spid;
import com.example.springapp.service.SpidService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/api")
public class SpidController {

    SpidService spidService;

    SpidController(SpidService spidService){
        this.spidService = spidService;
    }

    private static final Logger log =   LoggerFactory.getLogger(UserController.class);

    @GetMapping("/spid")
    public ResponseEntity<List<Spid>> getAllSpids() {
        return new ResponseEntity(spidService.getAllSpids(), HttpStatus.OK);
    }

    @GetMapping("/spid/{id}")
    public ResponseEntity<Spid> findSpidById(@PathVariable(name = "id")long id) throws Exception {
        return new ResponseEntity(spidService.findSpidById(id), HttpStatus.OK);
    }


    @PostMapping("create/spid")
    public ResponseEntity<Spid> createSpid(
            @RequestBody Spid spid) throws Exception {
        log.info(spid.getCreatedBy());
        spidService.createSpid(spid);
        return new ResponseEntity(spid, HttpStatus.OK);
    }

    @PutMapping("/spid/{id}")
    public ResponseEntity<Spid> approveSpid(@PathVariable(name = "id")long id) throws Exception {
        return new ResponseEntity(spidService.approveSpid(id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/spid/{id}")
    public ResponseEntity<String> deleteSpid(
            @PathVariable(name = "id") long id) throws Exception {
        spidService.deleteSpid(id);
        return new ResponseEntity("Personi me kete id u fshi", HttpStatus.OK);
    }


}
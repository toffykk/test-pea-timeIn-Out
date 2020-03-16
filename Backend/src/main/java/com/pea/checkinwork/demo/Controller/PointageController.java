package com.pea.checkinwork.demo.Controller;

import com.pea.checkinwork.demo.Repository.*;
import com.pea.checkinwork.demo.Entity.*;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.transaction.annotation.Transactional;
import java.util.Date;


@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class PointageController{

    @Autowired private PointageRepository pointageRepository;

    @GetMapping("/Pointage")
    public Collection<Pointage> pointage(){
        return pointageRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/Pointage/{pointageId}")
    public Optional<Pointage> takeinPointageByid(@PathVariable final Long pointageId ){
        return pointageRepository.findById(pointageId);
    }

    @PostMapping("/Pointage/{firstname}/{lastname}/{date}}")
    @Transactional
    public void CheckinToday(@PathVariable final Long pointageId,@PathVariable final String firstname,@PathVariable final String lastname,@PathVariable final Date date) {
       
        
        final Pointage pointage = pointageRepository.findById(pointageId).get();
       
        
        pointage.setFirstname(firstname);
        pointage.setLastname(lastname);
        pointage.setDate(date);

        pointageRepository.save(pointage);
    } 

}
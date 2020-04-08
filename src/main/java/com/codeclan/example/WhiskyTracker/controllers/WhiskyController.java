package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/whiskies")
public class WhiskyController {

    @Autowired
    WhiskyRepository whiskyRepository;

    @GetMapping(value = "")
    public ResponseEntity<List<Whisky>> findAllWhiskies(){
        return new ResponseEntity<>(whiskyRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/year/{year}")
    public ResponseEntity<List<Whisky>> getWhiskyByYear(@PathVariable int year){
        return new ResponseEntity<>(whiskyRepository.findByYear(year), HttpStatus.OK);
    }

    @GetMapping(value = "/year&distillery")
    public ResponseEntity<List<Whisky>> getWhiskyByDIstilleryAndAge(@RequestParam(name="distillery", required = false) String distellery, @RequestParam(name="age", required = false) int age){
        return new ResponseEntity<>(whiskyRepository.findBYDistilleryAndAge(distellery, age), HttpStatus.OK);
    }



}
//    @GetMapping(value = "/raids")
//    public ResponseEntity<List<Raid>> getAllRaids(@RequestParam(name="location1", required=false) String location1, @RequestParam(name="location2", required=false) String location2){
//        if (location1 != null && location2 != null) {
//            return new ResponseEntity<>(raidRepository.findByLocationOrLocation(location1, location2), HttpStatus.OK);
//        }
//        return new ResponseEntity<>(raidRepository.findAll(), HttpStatus.OK);
//    }

// // http://localhost:8080/raids?location1=Tortuga&location2=Treasure%20Island // url to type to get search with 2 locations
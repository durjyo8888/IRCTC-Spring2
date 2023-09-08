package com.example.IRCTCSystem.Controller;

import com.example.IRCTCSystem.Model.Passenger;
import com.example.IRCTCSystem.Service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/passenger")
public class PassengerController {
    @Autowired
    PassengerService passengerService;

    @PostMapping("/add-passenger")
    public ResponseEntity addPassenger(@RequestBody Passenger passenger){
        passengerService.addPassenger(passenger);
        return new ResponseEntity("Passenger added successfully", HttpStatus.CREATED);
    }

    @GetMapping("/get-passenger")
    public ResponseEntity getNoOfPassenger(@RequestParam String start, @RequestParam String end, @RequestParam Date date){

            int passenger = passengerService.getNoOfPassenger(start, end, date);
            return new ResponseEntity(passenger, HttpStatus.FOUND);

    }

    @GetMapping("/get-female-passenger")
    public ResponseEntity getFemalePassengerBetweenAge(@RequestParam int minAge, @RequestParam int maxAge, @RequestParam String destination){
        int femalePassenger = passengerService.getFemalePassengerBetweenAge(minAge, maxAge, destination);
        return new ResponseEntity(femalePassenger,HttpStatus.FOUND);
    }
}

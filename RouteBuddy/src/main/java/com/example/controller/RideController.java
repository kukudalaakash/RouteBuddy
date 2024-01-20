package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com.example.entity.Ride;
import com.example.repository.RideRepository;

@RestController
@RequestMapping("/rides")
@CrossOrigin
public class RideController {

    @Autowired
    private RideRepository riderepository;
    
    @GetMapping("/all")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<Ride>> getAllrides() {
        // Retrieve all rides from the repository
        List<Ride> allrides = riderepository.findAll();
        return new ResponseEntity<>(allrides, HttpStatus.OK);
    }
    @PostMapping("/add")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public ResponseEntity<Ride> addride(@RequestBody Ride ride) {
        // Save the new ride to the repository
        Ride savedride = riderepository.save(ride);
        return new ResponseEntity<>(savedride, HttpStatus.CREATED);
    }

    @DeleteMapping("/rider/{riderName}")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public ResponseEntity<Void> deleteRideByRiderName(@PathVariable String riderName) {
        // Check if rides with the given riderName exist
        List<Ride> rides = riderepository.findByRiderName(riderName);
        if (!rides.isEmpty()) {
            // Delete rides with the given riderName
            riderepository.deleteByRiderName(riderName);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/passenger/{passengerName}")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public ResponseEntity<Void> deleteRideByPassengerName(@PathVariable String passengerName) {
        // Check if rides with the given passengerName exist
        List<Ride> rides = riderepository.findByPassengerName(passengerName);
        if (!rides.isEmpty()) {
            // Delete rides with the given passengerName
            riderepository.deleteByPassengerName(passengerName);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/rider/{riderName}")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public ResponseEntity<List<Ride>> getRideByRiderName(@PathVariable String riderName) {
        // Retrieve rides by riderName from the repository
        List<Ride> rides = riderepository.findByRiderName(riderName);
        if (!rides.isEmpty()) {
            return new ResponseEntity<>(rides, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/passenger/{passengerName}")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public ResponseEntity<List<Ride>> getRideByPassengerName(@PathVariable String passengerName) {
        // Retrieve rides by passengerName from the repository
        List<Ride> rides = riderepository.findByPassengerName(passengerName);
        if (!rides.isEmpty()) {
            return new ResponseEntity<>(rides, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

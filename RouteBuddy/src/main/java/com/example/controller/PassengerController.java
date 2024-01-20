package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com.example.entity.Passenger;
import com.example.repository.PassengerRepository;

@RestController
@RequestMapping("/passengers")
@CrossOrigin
public class PassengerController {

    @Autowired
    private PassengerRepository passengerrepository;
    
    @GetMapping("/all")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public ResponseEntity<List<Passenger>> getAllpassengers() {
        // Retrieve all passengers from the repository
        List<Passenger> allpassengers = passengerrepository.findAll();
        return new ResponseEntity<>(allpassengers, HttpStatus.OK);
    }

    @PostMapping("/add")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public ResponseEntity<Passenger> addpassenger(@RequestBody Passenger passenger) {
        // Save the new passenger to the repository
        Passenger savedpassenger = passengerrepository.save(passenger);
        return new ResponseEntity<>(savedpassenger, HttpStatus.CREATED);
    }

    @GetMapping("/{passengerName}")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public ResponseEntity<Passenger> getPassengerByName(@PathVariable String passengerName) {
        // Retrieve passenger by passengerName from the repository
        // If the passenger is found, return it with HttpStatus.OK; otherwise, return HttpStatus.NOT_FOUND
        return passengerrepository.findByName(passengerName)
                .map(passenger -> new ResponseEntity<>(passenger, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{passengerName}")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public ResponseEntity<Void> deletePassenger(@PathVariable String passengerName) {
        // Check if a passenger with the given passengerName exists
        Optional<Passenger> passenger = passengerrepository.findByName(passengerName);
        if (passenger.isPresent()) {
            // Delete the passenger with the given passengerName
            passengerrepository.deleteByName(passengerName);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}

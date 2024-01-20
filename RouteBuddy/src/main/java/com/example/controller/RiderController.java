package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com.example.entity.Rider;
import com.example.repository.RiderRepository;

@RestController
@RequestMapping("/riders")
@CrossOrigin
public class RiderController {

    @Autowired
    private RiderRepository riderRepository;
    
    @GetMapping("/all")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public ResponseEntity<List<Rider>> getAllRiders() {
        // Retrieve all riders from the repository
        List<Rider> allRiders = riderRepository.findAll();
        return new ResponseEntity<>(allRiders, HttpStatus.OK);
    }
    @GetMapping("/{riderName}")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public ResponseEntity<Rider> getRiderByName(@PathVariable String riderName) {
        // Retrieve rider by riderId from the repository
        // If the rider is found, return it with HttpStatus.OK; otherwise, return HttpStatus.NOT_FOUND
        return riderRepository.findByName(riderName)
                .map(rider -> new ResponseEntity<>(rider, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/add")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public ResponseEntity<Rider> addRider(@RequestBody Rider rider) {
        // Save the new rider to the repository
        Rider savedRider = riderRepository.save(rider);
        return new ResponseEntity<>(savedRider, HttpStatus.CREATED);
    }

    @DeleteMapping("/{riderName}")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public ResponseEntity<Void> deleteRider(@PathVariable String riderName) {
        // Check if a rider with the given riderId exists
    	Optional<Rider> rider = riderRepository.findByName(riderName);
        if (rider.isPresent()) {
            // Delete the rider with the given riderId
            riderRepository.deleteByName(riderName);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}

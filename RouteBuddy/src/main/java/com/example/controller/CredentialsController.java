package com.example.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.security.JwtService;
import com.example.dto.AuthRequest;
import com.example.entity.Credentials;
import com.example.repository.CredentialsRepository;

@RestController
@RequestMapping("/credentials")
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*", methods = {RequestMethod.POST}, allowCredentials = "true")
public class CredentialsController {
	
	@Autowired
	private PasswordEncoder passwordEncoder;

    @Autowired
    private CredentialsRepository repo;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/test")
    public ResponseEntity<String> testClass() {
        return new ResponseEntity<>("Hello World", HttpStatus.OK);
    }
    
    @PostMapping("/new")
    public ResponseEntity<Credentials> saveCredentials(@RequestBody Credentials credentials) {

		credentials.setPassword(passwordEncoder.encode(credentials.getPassword()));
        Credentials saved = repo.save(credentials);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<Credentials>> findAllCredentials() {
        List<Credentials> list = repo.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{username}")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public ResponseEntity<Credentials> findCredentialsByUsername(@PathVariable String username) {
        Optional<Credentials> credentials = repo.findByUsername(username);
        if (credentials.isPresent()) {
            return new ResponseEntity<>(credentials.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/remove/{username}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Void> deleteCredentialsByUsername(@PathVariable String username) {
        Optional<Credentials> credentials = repo.findByUsername(username);
        if (credentials.isPresent()) {
            repo.deleteByUsername(username);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/authenticate")
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(authRequest.getUsername());
        } else {
            throw new UsernameNotFoundException("invalid user request!");
        }
    }
}

package com.example.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.entity.Ride;

public interface RideRepository extends MongoRepository<Ride, String> {
    
    List<Ride> findByRiderName(String name);
    void deleteByRiderName(String name);
    List<Ride> findByPassengerName(String name);
    void deleteByPassengerName(String name);
   
}

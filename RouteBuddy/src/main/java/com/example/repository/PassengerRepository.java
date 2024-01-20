package com.example.repository;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.entity.Passenger;

public interface PassengerRepository extends MongoRepository<Passenger,Integer>{
	
	Optional<Passenger> findByName(String name);
    void deleteByName(String name);

}
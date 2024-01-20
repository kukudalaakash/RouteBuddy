package com.example.repository;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.entity.Rider;

public interface RiderRepository extends MongoRepository<Rider,Integer>{
	
	Optional<Rider> findByName(String name);
    void deleteByName(String name);

}

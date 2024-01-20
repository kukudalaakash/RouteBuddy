package com.example.repository;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.entity.Credentials;

public interface CredentialsRepository extends MongoRepository<Credentials,Integer>{
	
	Optional<Credentials> findByUsername(String userID);
    void deleteByUsername(String userID);

}
package com.example.codefellowship.repository;



import com.example.codefellowship.model.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<Users, Integer> {
    public Users findByUsername(String username);
}


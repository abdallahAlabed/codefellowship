package com.example.codefellowship.repository;

import com.sun.xml.bind.v2.model.core.ID;
import org.apache.catalina.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, ID> {

    public User findByUsername(String username);
}

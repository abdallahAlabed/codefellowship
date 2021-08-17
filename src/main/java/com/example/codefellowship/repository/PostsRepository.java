package com.example.codefellowship.repository;

import com.example.codefellowship.model.Posts;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostsRepository extends CrudRepository<Posts, Integer>{
   public Iterable<Posts> findAllById(Integer userId);
}

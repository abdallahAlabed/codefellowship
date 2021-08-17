package com.example.codefellowship.service;

import com.example.codefellowship.model.Posts;
import com.example.codefellowship.repository.PostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Autowired
    PostsRepository postsRepository;

    public Iterable<Posts> getAllPost(Integer id){
        return postsRepository.findAllById(id);
    }

    public void addPost(String title,String content,String imageFilePath){
        postsRepository.save(new Posts (title,content,imageFilePath)) ;

    }
}

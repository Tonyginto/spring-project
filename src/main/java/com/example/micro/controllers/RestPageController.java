package com.example.micro.controllers;

import com.example.micro.models.Post;
import com.example.micro.models.Role;
import com.example.micro.rep.PostRepository;
import com.example.micro.models.User;
import com.example.micro.rep.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.micro.rep.UserRepository;

import java.util.List;

@RestController
public class RestPageController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    PostRepository postRepository;
    @Autowired
    RoleRepository roleRepository;

//    @PostMapping("/t")
    @GetMapping("/t")
    public User getByName(/*@RequestParam String name*/){
        String name = "admin1";
        return userRepository.findByUsername(name);
    }

    @GetMapping("/p")
    public Role getId() {
        Long in = 1L;
        return roleRepository.getNameByRoleId(in);
    }

    @GetMapping("/post")
    public List<Post> getAllDB(){
        return postRepository.findAll();
    }

    @GetMapping("/kek")
    public List<User> getAllDB2(){
        return userRepository.findAll();
    }

    @GetMapping("/lol")
    public List<Role> getAllDB3(){
        return roleRepository.findAll();
    }
}

package com.example.micro.controllers;

import com.example.micro.dto.Post;
import com.example.micro.dto.Role;
import com.example.micro.dto.User;
import com.example.micro.repository.PostRepository;
import com.example.micro.repository.RoleRepository;
import com.example.micro.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestPageController {

  UserRepository userRepository;
  PostRepository postRepository;
  RoleRepository roleRepository;

  @Autowired
  public RestPageController(UserRepository userRepository ,PostRepository postRepository ,RoleRepository roleRepository) {
    this.userRepository = userRepository;
    this.postRepository = postRepository;
    this.roleRepository = roleRepository;
  }

  //    @PostMapping("/t")
  @GetMapping("/t")
  public User getByName(/*@RequestParam String name*/) {
    String name = "admin1";
    return userRepository.findByUsername(name);
  }

  @GetMapping("/p")
  public String getId() {
    Long in = 1L;
    return roleRepository.getByRoleId(in).getRoleName();
  }

  @GetMapping("/post")
  public List<Post> getAllPost() {
    return postRepository.findAll();
  }

  @GetMapping("/kek")
  public List<User> getAllUser() {
    return userRepository.findAll();
  }

  @GetMapping("/lol")
  public List<Role> getAllRole() {
    return roleRepository.findAll();
  }
}

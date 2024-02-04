package com.example.micro;

import com.example.micro.dto.User;
import com.example.micro.repository.RoleRepository;
import com.example.micro.repository.UserRepository;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  @Autowired
  private UserRepository userRepository;
  @Autowired
  private RoleRepository roleRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userRepository.findByUsername(username);
    if (user == null) {
      throw new UsernameNotFoundException("User not found with username: " + username);
    }
    GrantedAuthority authority = new SimpleGrantedAuthority(roleRepository.getByRoleId(user.getRoleId()).getRoleName());
    return new org.springframework.security.core.userdetails.User(
        user.getUsername() ,
        user.getPassword() ,
        (Collection<? extends GrantedAuthority>) authority);
  }
}


package com.priyankit.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.priyankit.app.repository.UserRepository;

@Service
public class AuthUserDetailsService implements UserDetailsService {
  @Autowired
  private UserRepository users;
  private org.springframework.security.core.userdetails.User userdetails;
  
  @Override
  public UserDetails loadUserByUsername(String username)
      throws UsernameNotFoundException {
    // TODO Auto-generated method stub
    
    boolean enabled = true;
    boolean accountNonExpired = true;
    boolean credentialsNonExpired = true;
    boolean accountNonLocked = true;
    
   com.priyankit.app.model.User user = getUserDetail(username);
    
    userdetails = new User (user.getUsername(),
                user.getPassword(),
                enabled,
                accountNonExpired,
                credentialsNonExpired,
                accountNonLocked,
                getAuthorities(user.getRole())
                );
    
    return userdetails;
  }
  public List<GrantedAuthority> getAuthorities(Integer role) {
    
    List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
    if (role.intValue() == 1) {
      authList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
    } else if (role.intValue() == 2) {
      authList.add(new SimpleGrantedAuthority("ROLE_USER"));
    }
    
    return authList;
  }
  
  private com.priyankit.app.model.User getUserDetail(String username){
    
	  com.priyankit.app.model.User user = users.findByUsername(username);
    
    
    return user;
  }
}
package com.bilel.equipes.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.bilel.equipes.entities.User;
import com.bilel.equipes.repos.UserRepository;

@Service
public class MyUserDetaulsService implements UserDetailsService {
	@Autowired
	UserRepository userRepository;

@Override
public UserDetails loadUserByUsername(String username) throws

UsernameNotFoundException {
User user = userRepository.findByUsername(username);
return new MyUserDetails(user);
}}

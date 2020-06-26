package io.inspireinnovations.spring_boot_security.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import io.inspireinnovations.spring_boot_security.model.MyUserDetails;
import io.inspireinnovations.spring_boot_security.model.User;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Optional<User> user = userRepository.findbyUserName(userName);
		user.orElseThrow(() -> new UsernameNotFoundException("Not Found: " +userName));
		return user.map(MyUserDetails::new).get();
	}

}

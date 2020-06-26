package io.inspireinnovations.spring_security_jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.inspireinnovations.spring_security_jwt.model.AuthenticationRequest;
import io.inspireinnovations.spring_security_jwt.model.AuthenticationResponse;
import io.inspireinnovations.spring_security_jwt.services.MyUserDetailsService;
import io.inspireinnovations.spring_security_jwt.util.JWTUtil;

@RestController
public class HelloResource {

	@Autowired
	private AuthenticationManager authManager;

	@Autowired
	private MyUserDetailsService userDetailsService;

	@Autowired
	private JWTUtil jwtUtil;

	@RequestMapping({ "/hello" })
	public String hello() {
		return "Hello World";
	}

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAutheticationToken(@RequestBody AuthenticationRequest req) throws Exception {
		try {
			authManager.authenticate(new UsernamePasswordAuthenticationToken(req.getUserName(), req.getPassword()));
		} catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
		}

		final UserDetails userDetails = userDetailsService.loadUserByUsername(req.getUserName());
		final String jwt = jwtUtil.generateToken(userDetails);

		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}
}

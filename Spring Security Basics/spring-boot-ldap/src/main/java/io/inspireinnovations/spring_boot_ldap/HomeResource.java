package io.inspireinnovations.spring_boot_ldap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeResource {

	@GetMapping("/")
	public String index() {
		return ("<h1>Home Page</h1>");
	}
}

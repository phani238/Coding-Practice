package io.inspireinnovations.spring_security_fb_login;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;

@SpringBootApplication
@EnableOAuth2Sso
public class SpringSecurityFBLoginApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityFBLoginApplication.class);
	}
}

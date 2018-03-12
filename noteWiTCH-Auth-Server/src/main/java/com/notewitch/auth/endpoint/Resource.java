package com.notewitch.auth.endpoint;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Resource {

	@GetMapping("/getCurrentUser")
	public Principal getCurrentUser(Principal principal) {
		return principal;
	}
}

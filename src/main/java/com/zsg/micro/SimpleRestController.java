package com.zsg.micro;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleRestController {

	@GetMapping("/api/message")
	public String getMessage() {
		return "Simple message";
	}
}

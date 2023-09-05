package com.dk.bus.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author DurgaKalyan
 * Class to test more than one controller documnets are coming in swagger  or not
 *
 */
@RestController
public class SwaggerTestController {

	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome to Swagger";
	}
}

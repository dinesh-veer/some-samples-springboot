/**
 * 
 */
package com.spring.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dineshveer
 *
 */

@RestController
public class LimitServiceController {
	
	@Autowired
	private Configuration configuration;
	
	@GetMapping("/limits")  
	public LimitConfiguration retriveLimits()
	{  
	return new LimitConfiguration(1000, 1);  
	}  

	
	@GetMapping("/limitConfig")  
	public LimitConfiguration retriveLimitsConfig()  
	{  
	return new LimitConfiguration(configuration.getMaximum(), configuration.getMinimum());  
	}  
}

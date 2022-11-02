package com.einfochips.rest.webservices.restfullwebservices.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloworldExample {

	/*
	 * @RequestMapping(method = RequestMethod.GET,path = "/helloworld") public
	 * String Message() { return "Hello World"; }
	 */
	
	@GetMapping("/helloworld")
	public String Message() {
		return "Hello World";		
	}
	//with Bean
	@GetMapping("/helloworld-bean")
	public MessageBean MessageBean() {
		return new MessageBean("Hello World");		
	}
	
	//Some PathVariable
	@GetMapping("/helloworld/patah-variable/{name}")
	public MessageBean MessageWithPathVariable(@PathVariable String name) {
		MessageBean message=new MessageBean();
		message.setMessage("Hello "+name);
		return message;		
	}
}

package com.rest.ful.restfulwebservice;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@GetMapping(path = "/hw")

	public String helloworld() {
		return "HELLOW WORLD";
	}
	
	@GetMapping(path = "/hwb")
	public HelloWorldBean helloworldbean() {
		return new HelloWorldBean("HELLOW WORLD BEAN");
	}
	
	//path vaibale
	@GetMapping(path = "/hw/pv/{name}")
	public HelloWorldBean helloworldpv(@PathVariable String name) {
		
		return new HelloWorldBean("HELLOW WORLD " +name);
	}
}
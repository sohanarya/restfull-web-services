package com.einfochips.rest.webservices.restfullwebservices.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilteringConfigController {

	@GetMapping("/filtering")
	public SomeBean filterBean() {
		
		return new SomeBean("value1","value2","value3");		
	}
	@GetMapping("/filtering-list")
	public List<SomeBean> filterBeanList() {
		
		return Arrays.asList(new SomeBean("value1","value2","value3"),
				new SomeBean("value00","value11","value22"),
				new SomeBean("value01","value02","value03"));		
	}
}

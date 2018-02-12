package demoservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import demoservice.config.Properties;
import demoservice.domain.User;
import demoservice.service.FeignClientDemo;

@RestController
public class RestfulController {
	@Autowired
	private Properties properties;
	@Autowired
	private User user;
	@Autowired
	private FeignClientDemo feignClient;
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
	public String hello(@RequestParam(value="name", required = false) String name) {
		return "Hello" + (name == null ? "" : name);
	}
	
	@RequestMapping(value = "/property", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
	public String getProperty() {
		return properties.getValue();
	}
	
	@RequestMapping(value = "/enable", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
	public String enable() {
		return user.getName();
	}
	
	@RequestMapping(value = "/feign", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
	public String getFeignMessage(@RequestParam(value="name") String name) {
		return feignClient.getSomeMessage(name);
	}
}

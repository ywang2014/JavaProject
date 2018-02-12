package demoservice.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "demoService", url = "http://localhost:1000/service")
public interface FeignClientDemo {
	@GetMapping(value = "/hello")
	String getSomeMessage(@RequestParam(value = "name") String name);
}

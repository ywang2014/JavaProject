package demoservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
//@ComponentScan("demoservice.enable")
//@SpringBootApplication(scanBasePackages = {"demoservice.enable", "demoservice.config", "demoservice.controller"})
public class DemoServiceApplication extends SpringBootServletInitializer{
	public static void main(String[] args) {
		SpringApplication.run(DemoServiceApplication.class, args);
	}
}

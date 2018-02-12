package demoservice.enable;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Description;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import demoservice.domain.Dog;
import demoservice.domain.User;

@Component
public class BeanFactory {

	@Bean
	@Description("Provides some description about the bean")
	public User user() {
		User u = new User();
		u.setId("user001");
		u.setName("USER");
		return u;
	}
	
	@Bean(name = {"myUser", "userBean", "my user"})
	@Scope("prototype")
	@Description("Provides the bean with alias")
	public User myUser() {
		User u = new User();
		u.setId("user001");
		u.setName("USER");
		return u;
	}
	
	@Bean(initMethod = "init")
	@Description("执行生命周期的回调函数")
	public Dog huskie() {
		Dog huskie = new Dog();
		huskie.setSpecies("哈士奇");
		return huskie;
	}
	
	@Bean(destroyMethod = "cleanup")
	@Description("执行生命周期的回调函数")
	public Dog chihuahua() {
		Dog chihuahua = new Dog();
		chihuahua.setSpecies("吉娃娃");
		return chihuahua;
	}
	
	@Bean()
	@Description("add dependency bean")
	public Dog teddy(User user) {
		return new Dog(user);
	}
}

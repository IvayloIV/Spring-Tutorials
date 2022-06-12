package com.pluralsight.springbootapplication;

import com.pluralsight.helloworldstarter.Hello;
import com.pluralsight.springbootapplication.config.PropertiesConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@EnableConfigurationProperties(PropertiesConfig.class)
public class DemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
		System.out.println(context.getBean(PropertiesConfig.class).getVersion());
		context.getBean(Hello.class).sayHello();
	}
}

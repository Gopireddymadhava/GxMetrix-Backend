package com.gx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

import springfox.documentation.swagger2.annotations.EnableSwagger2;







@EntityScan(basePackages = "com.gx.*")
@EnableJpaRepositories(basePackages = "com.gx.*")
@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "com.gx.*")
@EnableScheduling



@SpringBootApplication(exclude=SecurityAutoConfiguration.class)

public class GxMetrixApplication{

	public static void main(String[] args) {
		SpringApplication.run(GxMetrixApplication.class, args);
	}
	
	
	
}

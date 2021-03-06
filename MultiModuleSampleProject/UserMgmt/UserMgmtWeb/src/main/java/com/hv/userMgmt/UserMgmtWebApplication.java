package com.hv.userMgmt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 
 * @author harshul.varshney
 * Entry point of application to be run using embedded container of spring boot.
 *
 */
@ComponentScan(basePackages = {"com.hv"})
@Configuration
@EnableAutoConfiguration
public class UserMgmtWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserMgmtWebApplication.class, args);
	}
}

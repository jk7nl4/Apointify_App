package com.example.Apointify_App;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestApointifyAppApplication {

	public static void main(String[] args) {
		SpringApplication.from(ApointifyAppApplication::main).with(TestApointifyAppApplication.class).run(args);
	}

}

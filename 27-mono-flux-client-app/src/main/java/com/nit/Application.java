package com.nit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.nit.service.ClientService;

import reactor.core.publisher.Mono;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(Application.class, args);
		ClientService bean = run.getBean(ClientService.class);
		bean.invokeMonoObject();
		bean.invokeMonoObject();
	}

}

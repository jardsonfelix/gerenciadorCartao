package com.urbana_pe.gereciadorCartao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class GereciadorCartaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(GereciadorCartaoApplication.class, args);
	}

}

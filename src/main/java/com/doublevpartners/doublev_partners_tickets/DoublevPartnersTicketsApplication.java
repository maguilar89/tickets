package com.doublevpartners.doublev_partners_tickets;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DoublevPartnersTicketsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DoublevPartnersTicketsApplication.class, args);
	}

}

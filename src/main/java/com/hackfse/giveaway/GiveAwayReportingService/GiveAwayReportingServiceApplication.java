package com.hackfse.giveaway.GiveAwayReportingService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.hackfse.giveaway")
@EnableJpaRepositories("com.hackfse.giveaway.dao")
@EntityScan("com.hackfse.giveaway.dto") 
@Configuration
public class GiveAwayReportingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GiveAwayReportingServiceApplication.class, args);
	}

}
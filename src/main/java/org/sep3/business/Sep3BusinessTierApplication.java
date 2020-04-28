package org.sep3.business;

import org.sep3.business.model.domain.Account;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManagerFactory;

@SpringBootApplication
public class Sep3BusinessTierApplication {

	public static void main(String[] args) {
		SpringApplication.run(Sep3BusinessTierApplication.class, args);
	}

}

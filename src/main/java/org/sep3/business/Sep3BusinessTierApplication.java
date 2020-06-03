package org.sep3.business;

import org.sep3.business.heartbeat.HeartbeatServer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;

import java.io.IOException;
import java.net.SocketException;

@SpringBootApplication
@EnableAsync
public class Sep3BusinessTierApplication {

	public static void main(String[] args) {
		SpringApplication.run(Sep3BusinessTierApplication.class, args);
	}

	@Bean
	public CommandLineRunner hbRunner(HeartbeatServer hbs) {
		return s -> hbs.run();
	}
}

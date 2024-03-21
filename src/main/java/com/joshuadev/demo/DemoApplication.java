package com.joshuadev.demo;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.joshuadev.demo.run.Location;
import com.joshuadev.demo.run.Run;
import com.joshuadev.demo.user.User;
import com.joshuadev.demo.user.UserRestClient;
import com.joshuadev.demo.run.JdbcClientRunRepository;


@SpringBootApplication
public class DemoApplication {

	private static final org.slf4j.Logger log = LoggerFactory.getLogger(DemoApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		log.info("Something changed!");
	}

	// @Bean
	// CommandLineRunner runner(RunRepository runRepository) {
	// 	return args -> {
	// 		Run run = new Run(1, "First Run", LocalDateTime.now(), LocalDateTime.now().plus(1, ChronoUnit.HOURS), 5, Location.OUTDOOR);
	// 		runRepository.create(run);
	// 	};
	// }

	@Bean
	CommandLineRunner runner(UserRestClient client) {
		return args -> {

			List<User> users = client.findAll();
			System.out.println(users);

			User user = client.findById(1);
			System.out.println(user);

			
		};
	}

}

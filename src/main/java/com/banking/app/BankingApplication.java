package com.banking.app;

import com.banking.app.entity.Users;
import com.banking.app.repository.CustomUserDetailsRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class BankingApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankingApplication.class, args);
	}

	@Bean
	public CommandLineRunner createAdminUser(CustomUserDetailsRepository userDetailsRepository, PasswordEncoder passwordEncoder) {
		return args -> {
			if (userDetailsRepository.findByUserName("admin").isEmpty()) {
				Users admin = new Users();
				admin.setUsername("admin");
				admin.setPassword(passwordEncoder.encode("admin123"));
				admin.setRole("ADMIN");
             userDetailsRepository.save(admin);
			 System.out.println("created");
			}
		};
	}

}

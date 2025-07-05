package com.banking.app;

import com.banking.app.entity.Role;
import com.banking.app.entity.Users;
import com.banking.app.repository.CustomUserDetailsRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@EnableCaching
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
				admin.setRole(Role.ADMIN);
             userDetailsRepository.save(admin);
			 System.out.println("created");
			}

			if (userDetailsRepository.findByUserName("user").isEmpty()) {
				Users admin = new Users();
				admin.setUsername("user");
				admin.setPassword(passwordEncoder.encode("user123"));
				admin.setRole(Role.USER);
				userDetailsRepository.save(admin);
				System.out.println("created");
			}
		};
	}

}

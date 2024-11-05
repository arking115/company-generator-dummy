package com.example.company_dummy_backend;

import com.example.company_dummy_backend.models.Company;
import com.example.company_dummy_backend.models.User;
import com.example.company_dummy_backend.repositories.CompanyRepository;
import com.example.company_dummy_backend.repositories.UserRepository;
import com.github.javafaker.Faker;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class CompanyDummyBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(CompanyDummyBackendApplication.class, args);
	}

//	@Bean
	@Transactional
	public CommandLineRunner commandLineRunner(
			CompanyRepository companyRepository,
			UserRepository userRepository
	) {
		return args -> {
			Faker faker = new Faker();
			for (int i = 0; i < 50; i++) {
				List<User> userList = new ArrayList<>();
				for (int j = 0; j < 50; j++) {
					User user = User.builder()
							.firstName(faker.name().firstName())
							.lastName(faker.name().lastName())
							.dob(faker.date().birthday())
							.build();
					userList.add(user);
				}

				Company company = Company.builder()
						.APIKey(null)
						.contact(faker.name().fullName())
						.userList(userList)
						.build();

				for (User user : userList) {
					user.setCompany(company);
				}

				companyRepository.save(company);
			}
		};
	}
}

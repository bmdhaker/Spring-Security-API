package com.pack;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.pack.dao.UserDao;
import com.pack.model.DAOUser;
import com.pack.model.UserDTO;

@SpringBootApplication
public class AuthentificationandauthorizationApplication {
	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Autowired
	private UserDao userDao;

	public static void main(String[] args) {
		SpringApplication.run(AuthentificationandauthorizationApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo() {
		return (args) -> {
			String passworddhaker = "helloworld", cryptedPassworddhaker = "";
			cryptedPassworddhaker = bcryptEncoder.encode(passworddhaker);

			DAOUser dhaker = new DAOUser();
			dhaker.setUsername("bmdhaker");
			dhaker.setEmail("bmdhaker@gmail.com");
			dhaker.setPassword(cryptedPassworddhaker);
			userDao.save(dhaker);

			userDao.findAll().forEach(u -> {
				System.out.println(u.toString());
			});

		};

	}
}
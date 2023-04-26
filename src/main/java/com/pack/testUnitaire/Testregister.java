package com.pack.testUnitaire;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.pack.model.DAOUser;
import com.pack.model.UserDTO;
import com.pack.service.JwtUserDetailsService;

public class Testregister {
	@Autowired
	private PasswordEncoder bcryptEncoder;
	@Autowired
	private UserDTO userDto;
	@Autowired
	private JwtUserDetailsService jwtUserDetailsService;

	@Test
	public void testRegister() throws Exception {

		String passwordamira = "helloworld", cryptedPasswordamira = "";
		cryptedPasswordamira = bcryptEncoder.encode(passwordamira);
		UserDTO amiradto = new UserDTO();
		DAOUser amiradao = new DAOUser();

		amiradto.setUsername("amira");
		amiradto.setEmail("amira@gmail.com");
		amiradto.setPassword(cryptedPasswordamira);

		amiradao.setEmail(amiradto.getEmail());
		amiradao.setUsername(amiradto.getUsername());
		amiradao.setPassword(amiradto.getPassword());

		assertEquals(amiradao.getUsername(),jwtUserDetailsService.save(amiradto).getUsername());
		
	}
	

}

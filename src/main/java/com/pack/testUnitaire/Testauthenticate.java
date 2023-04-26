package com.pack.testUnitaire;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.pack.dao.UserDao;
import com.pack.model.DAOUser;
import com.pack.model.UserDTO;
import com.pack.service.JwtUserDetailsService;

public class Testauthenticate {
	
	@Autowired
	private UserDao userDao;
	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Test
	public void testauthenticate() throws Exception {
		DAOUser user=null;
		String username="bmdhaker";
		String password="azerr",cryptedpassword="";
		cryptedpassword=bcryptEncoder.encode(password);
		
		user = userDao.findByUsername(username);
		System.out.println(user.toString());
		assertEquals(cryptedpassword,user.getPassword());
		
	}
	

}

package com.rah.testjava.microprice.rest;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//@ExtendWith(SpringExtension.class)
//@SpringBootTest
public class PriceApplicationTest {

	@Test
	public void contextLoads() {
		LocalDateTime dateTime = LocalDateTime.now();

		System.out.println(dateTime);
	}

}

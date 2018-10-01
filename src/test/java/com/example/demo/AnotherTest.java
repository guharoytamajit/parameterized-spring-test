package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.com.PrimeNumberChecker;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AnotherTest {

	@Autowired
	PrimeNumberChecker primeNumberChecker;
	@Test
	public void contextLoads() {
		System.out.println(primeNumberChecker.validate(7));
	}

}


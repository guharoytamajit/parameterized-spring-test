package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.com.PrimeNumberChecker;

@SpringBootApplication
public class NewAppApplication implements CommandLineRunner{
	
	   @Autowired
	   private PrimeNumberChecker primeNumberChecker;

	public static void main(String[] args) {
		SpringApplication.run(NewAppApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println(primeNumberChecker.validate(4));
		
	}
}

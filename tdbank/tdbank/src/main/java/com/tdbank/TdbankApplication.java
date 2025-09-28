package com.tdbank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TdbankApplication {

	public static void main(String[] args) {
		SpringApplication.run(TdbankApplication.class, args);
		
		System.out.println("TDBank running successfully");
	}

}

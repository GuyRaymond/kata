package com.gmail.guy.kata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = "com.gmail.guy.kata")
public class KataApplication {

	public static void main(String[] args) {
		SpringApplication.run(KataApplication.class, args);
        System.out.print("\033\143");
        System.out.println("\nKAtaApplication is running");
	}

}

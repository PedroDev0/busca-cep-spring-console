package com.pedro.buscacep;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.pedro.buscacep.management.Menu;

@SpringBootApplication
public class BuscaCepSpringConsoleApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BuscaCepSpringConsoleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Menu.show();

	}

}

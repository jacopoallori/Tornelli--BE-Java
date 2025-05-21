package com.td.tornelli;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.td.tornelli")
public class TornelliApplication {

	public static void main(String[] args) {
		SpringApplication.run(TornelliApplication.class, args);
	}

}

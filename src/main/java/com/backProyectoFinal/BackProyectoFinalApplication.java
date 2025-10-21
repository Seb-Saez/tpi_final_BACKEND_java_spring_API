package com.backProyectoFinal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.converter.json.GsonBuilderUtils;

@SpringBootApplication
public class BackProyectoFinalApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackProyectoFinalApplication.class, args);
        System.out.println("Proyecto corriendo bien");
	}
}

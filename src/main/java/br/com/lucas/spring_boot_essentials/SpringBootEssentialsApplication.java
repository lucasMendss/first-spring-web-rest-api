package br.com.lucas.spring_boot_essentials;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class SpringBootEssentialsApplication {

	//documentação: http://localhost:8080/swagger-ui/index.html
	public static void main(String[] args) {
		SpringApplication.run(SpringBootEssentialsApplication.class, args);
	}
}

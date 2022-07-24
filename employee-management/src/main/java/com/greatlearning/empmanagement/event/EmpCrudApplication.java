package com.greatlearning.empmanagement.event;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@SpringBootApplication
@EnableSwagger2
public class EmpCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmpCrudApplication.class, args);
	}

}

package SpringBoot.SpringBootDemoVinh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootDemoVinhApplication {

	public static void main(String[] args) {
		System.out.println("Starting Spring Boot ");
		SpringApplication.run(SpringBootDemoVinhApplication.class, args);
		System.out.println("Started Spring Boot");
	}

}

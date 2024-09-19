package pe_edu.cibertec.app_async_hilos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class AppAsyncHilosApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppAsyncHilosApplication.class, args);
	}

}

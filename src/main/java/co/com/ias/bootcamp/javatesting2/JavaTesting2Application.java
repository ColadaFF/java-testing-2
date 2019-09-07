package co.com.ias.bootcamp.javatesting2;

import co.com.ias.bootcamp.javatesting2.domain.Book;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

@SpringBootApplication
public class JavaTesting2Application {

	public static void main(String[] args) {
		SpringApplication.run(JavaTesting2Application.class, args);



		Book book = new Book.Builder("1213", "Name")
				.withLastOrderDate(LocalDateTime.now())
				.build();
	}

}

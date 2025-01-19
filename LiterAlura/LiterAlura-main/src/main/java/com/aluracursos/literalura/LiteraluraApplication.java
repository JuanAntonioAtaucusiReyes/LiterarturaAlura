package com.aluracursos.literalura;

import com.aluracursos.literalura.principal.Main_Litertura;
import com.aluracursos.literalura.repository.AutorRepository;
import com.aluracursos.literalura.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {

	@Autowired
	private BookRepository libroRepository;
	@Autowired
	private AutorRepository autorRepository;

	public static void main(String[] args) {
		SpringApplication.run(LiteraluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Main_Litertura principal = new Main_Litertura(libroRepository, autorRepository);
		principal.muestraElMenu();
	}
}

package com.emerson.vendas;

import com.emerson.vendas.domain.Categoria;
import com.emerson.vendas.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class VendasApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;

	public static void main(String[] args) {

		SpringApplication.run(VendasApplication.class, args);
	}

	/*
	* Essa ação é executada quando a palicação inicia.
	* A implementação é baseada em instancias que são armazenadas no banco de dados temporário h2.
	* A implementaçao do código utiliza a Interface Repository para ter acesso ao banco de dados.
	* */
	@Override
	public void run(String... args) throws Exception {

		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");

		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
	}
}

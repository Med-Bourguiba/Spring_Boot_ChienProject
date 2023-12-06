package com.mohamed.chiens;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.mohamed.chiens.entities.Chien;
import com.mohamed.chiens.entities.Race;

@SpringBootApplication
public class ChiensApplication implements CommandLineRunner{

	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;
	
	public static void main(String[] args) {
		SpringApplication.run(ChiensApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		repositoryRestConfiguration.exposeIdsFor(Chien.class,Race.class);
		
	}
	@Bean
	public ModelMapper modelMapper()
	{
	return new ModelMapper();
	}

}

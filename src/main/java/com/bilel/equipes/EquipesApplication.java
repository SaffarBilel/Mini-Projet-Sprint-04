package com.bilel.equipes;

import java.util.Date;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.bilel.equipes.EquipesApplication;
import com.bilel.equipes.entities.Equipe;
import com.bilel.equipes.service.EquipeService;

@SpringBootApplication
public class EquipesApplication implements CommandLineRunner{

	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;
	
	public static void main(String[] args) {
		SpringApplication.run(EquipesApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		repositoryRestConfiguration.exposeIdsFor(Equipe.class);
		
		/*equipeService.saveEquipe(new Equipe("REAL", 2, new Date()));
		equipeService.saveEquipe(new Equipe("BARCA", 2, new Date()));
*/
		
	}
	
	@Bean
	public ModelMapper modelMapper()
	{
	return new ModelMapper();
	}
	
	
	
	
	
	
	
	
}

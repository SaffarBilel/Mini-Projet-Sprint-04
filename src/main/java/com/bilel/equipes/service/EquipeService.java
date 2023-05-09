package com.bilel.equipes.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.bilel.equipes.entities.League;
import com.bilel.equipes.dto.EquipeDTO;
import com.bilel.equipes.entities.Equipe;

public interface EquipeService {
	
	EquipeDTO saveEquipe(EquipeDTO j);
	EquipeDTO updateEquipe(EquipeDTO j);
	
	
	
	EquipeDTO getEquipe(Long id);

	List<EquipeDTO> getAllEquipes();
	
	

	

	void deleteEquipe(Equipe j);

	void deleteEquipeById(Long id);

	

	List<League> getAllLeagues();

	long countEquipes();

	Page<Equipe> getAllEquipesParPage(int page, int size);

	List<Equipe> findByNomEquipe(String nom);

	List<Equipe> findByNomEquipeContains(String nom);

	List<Equipe> findByNomEquipeClassementEquipe(String nomEquipe, int classementEquipe);

	List<Equipe> findByLeague(League league);

	List<Equipe> findByLeagueIdLea(Long id);

	List<Equipe> findByOrderByNomEquipeAsc();

	List<Equipe> trierEquipesNomEquipesClassementEquipe();
	
	EquipeDTO convertEntityToDto (Equipe e);
	
	Equipe convertDtoToEntity(EquipeDTO equipeDto);

}






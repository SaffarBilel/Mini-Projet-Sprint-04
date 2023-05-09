package com.bilel.equipes.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.bilel.equipes.entities.League;
import com.bilel.equipes.dto.EquipeDTO;
import com.bilel.equipes.entities.Equipe;
import com.bilel.equipes.repos.EquipeRepository;
import com.bilel.equipes.repos.LeagueRepository;

@Service
public class EquipeServiceImpl implements EquipeService {
@Autowired
EquipeRepository equipeRepository;

@Autowired
ModelMapper modelmapper ;

@Autowired
LeagueRepository leagueRepository;

@Override
public EquipeDTO saveEquipe(EquipeDTO j) {
return convertEntityToDto( equipeRepository.save(convertDtoToEntity(j)));
}


@Override
public EquipeDTO updateEquipe(EquipeDTO j) {
return convertEntityToDto(equipeRepository.save(convertDtoToEntity(j)));
}


@Override
public void deleteEquipe(Equipe j) {
	equipeRepository.delete(j);
}
 @Override
public void deleteEquipeById(Long id) {
	 equipeRepository.deleteById(id);
}
@Override
public EquipeDTO getEquipe(Long id) {
return  convertEntityToDto(equipeRepository.findById(id).get());
}

@Override
public List<EquipeDTO> getAllEquipes() {
     return equipeRepository.findAll().stream()
    		 
		.map(this::convertEntityToDto)
		
		.collect(Collectors.toList());
     

	
	//OU BIEN
	/*List<Equipe> prods = equipeRepository.findAll();
	List<EquipeDTO> listprodDto = new ArrayList<>(prods.size());
	
	for (Equipe p : prods)
		
	listprodDto.add(convertEntityToDto(p));
	
	return listprodDto;
	}  */


}
	
	
	
	
	


@Override
public Page<Equipe> getAllEquipesParPage(int page, int size) {
	return equipeRepository.findAll(PageRequest.of(page, size));

}
@Override
public List<Equipe> findByNomEquipe(String nom) {
	
	return equipeRepository.findByNomEquipe(nom);
}
@Override
public List<Equipe> findByNomEquipeContains(String nom) {
	
	return equipeRepository.findByNomEquipeContains(nom);
}
@Override
public List<Equipe> findByNomEquipeClassementEquipe(String nomEquipe, int classementEquipe) {
	return equipeRepository.findByNomEquipeClassementEquipe(nomEquipe, classementEquipe);
}
@Override
public List<Equipe> findByLeague(League league) {
	
	return equipeRepository.findByLeague(league);
}
@Override
public List<Equipe> findByLeagueIdLea(Long id) {
	return equipeRepository.findByLeagueIdLea(id);
}
@Override
public List<Equipe> findByOrderByNomEquipeAsc() {
	
	return equipeRepository.findByOrderByNomEquipeAsc();
}
@Override
public List<Equipe> trierEquipesNomEquipesClassementEquipe() {
	return equipeRepository.trierEquipesNomEquipeClassementEquipe();
}

@Override
public List<League> getAllLeagues() {
	
	return leagueRepository.findAll();
}
@Override
public long countEquipes() {
	return  equipeRepository.count();
}

 public EquipeDTO convertEntityToDto (Equipe equipe) {
 
	modelmapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
	 EquipeDTO equipeDTO = modelmapper.map(equipe, EquipeDTO.class);
 
	 return equipeDTO ;
	 
   /*  EquipeDTO equipeDTO = new EquipeDTO();
     
     equipeDTO.setIdEquipe(e.getIdEquipe());
     equipeDTO.setNomEquipe(e.getNomEquipe());
     equipeDTO.setDateCreation(e.getDateCreation());
     equipeDTO.setLeague(e.getLeague());   */
   
  /*   return EquipeDTO.builder()
    		 .idEquipe(e.getIdEquipe())
    		 .nomEquipe(e.getNomEquipe())
    		 .dateCreation(e.getDateCreation())
    		 
    		 .league(e.getLeague()) 
    		// .nomleag(e.getLeague().getNomLea())
    		 .build() ;  */
 }
@Override
public Equipe convertDtoToEntity(EquipeDTO equipeDto) {
	
	
	Equipe equipe = new Equipe();
	equipe = modelmapper.map(equipeDto ,Equipe.class);
	return equipe ;
	
	
/*	Equipe equipe = new Equipe();
	
	equipe.setIdEquipe(equipeDto.getIdEquipe());
	equipe.setNomEquipe(equipeDto.getNomEquipe());
	equipe.setDateCreation(equipeDto.getDateCreation());
	equipe.setLeague(equipeDto.getLeague());
	
	return equipe; */
}
  
}

 
 
 
 
 
 
 
 
 
 
 


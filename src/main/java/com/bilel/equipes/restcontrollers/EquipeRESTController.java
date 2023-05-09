package com.bilel.equipes.restcontrollers;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.bilel.equipes.dto.EquipeDTO;
import com.bilel.equipes.entities.Equipe;
import com.bilel.equipes.service.EquipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api")
@CrossOrigin
public class EquipeRESTController {
	@Autowired
	EquipeService equipeService;
	@RequestMapping(method = RequestMethod.GET)
	public List<EquipeDTO> getAllEquipes() {
	return equipeService.getAllEquipes();
}
	
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public EquipeDTO getEquipeById(@PathVariable("id") Long id) {
	return equipeService.getEquipe(id);
	 }
	@RequestMapping(method = RequestMethod.POST)
	public EquipeDTO createEquipe(@RequestBody EquipeDTO equipeDTO) {
	return equipeService.saveEquipe(equipeDTO);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public EquipeDTO updateEquipe(@RequestBody EquipeDTO equipeDTO) {
	return equipeService.updateEquipe(equipeDTO);
	}

	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public void deleteEquipe(@PathVariable("id") Long id)
	{
		equipeService.deleteEquipeById(id);
	}

	@RequestMapping(value="/Equipeslea/{idLea}",method = RequestMethod.GET)
	public List<Equipe> getEquipesByLeaId(@PathVariable("idLea") Long idLea) {
	return equipeService.findByLeagueIdLea(idLea);
	}
	
	
	}

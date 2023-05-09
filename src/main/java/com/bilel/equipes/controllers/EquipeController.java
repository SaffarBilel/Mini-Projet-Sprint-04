package com.bilel.equipes.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bilel.equipes.dto.EquipeDTO;
import com.bilel.equipes.entities.Equipe;
import com.bilel.equipes.entities.League;

import com.bilel.equipes.service.EquipeService;


@Controller
public class EquipeController {
@Autowired
EquipeService equipeService;
@RequestMapping("/showCreate")
public String showCreate(ModelMap modelMap)
{
	List<League> cats = equipeService.getAllLeagues();
	League cat = new League();
	cat = cats.get(0);
	modelMap.addAttribute("equipe", new Equipe());
	modelMap.addAttribute("mode", "new");
	modelMap.addAttribute("leagues", cats);
    modelMap.addAttribute("page",0);


return "formEquipe";
}

@RequestMapping("/saveEquipe")
public String saveProduit(@Valid EquipeDTO equipe,
BindingResult bindingResult,
@ModelAttribute("page") int pageFromPrevious,
@RequestParam (name="size", defaultValue = "3") int size,
RedirectAttributes redirectAttributes)
{
int page;
if (bindingResult.hasErrors()) return "formEquipe";

if (equipe.getIdEquipe()==null) //adding
    page = equipeService.getAllEquipes().size()/size; // calculer le nbr de pages
else //updating
    page = pageFromPrevious;

equipeService.saveEquipe(equipe);

redirectAttributes.addAttribute("page", page);
return "redirect:/ListeEquipes";
}


@RequestMapping("/ListeEquipes")
public String listeEquipes(ModelMap modelMap,
		@RequestParam (name="page",defaultValue = "0") int page,
		@RequestParam (name="size", defaultValue = "3") int size)
{
	Page<Equipe> prods = equipeService.getAllEquipesParPage(page, size);
	modelMap.addAttribute("equipes", prods);
	modelMap.addAttribute("pages", new int[prods.getTotalPages()]);
	modelMap.addAttribute("currentPage", page);
	modelMap.addAttribute("size", size);

	return "listeEquipes";
}

@RequestMapping("/supprimerEquipe")

public String supprimerEquipe(@RequestParam("id") Long id,
 ModelMap modelMap,
 @RequestParam (name="page",defaultValue = "0") int page,
 @RequestParam (name="size", defaultValue = "2") int size)
{
	equipeService.deleteEquipeById(id);
	Page<Equipe> prods = equipeService.getAllEquipesParPage(page,size);
	modelMap.addAttribute("equipes", prods);
	modelMap.addAttribute("pages", new int[prods.getTotalPages()]);
	modelMap.addAttribute("currentPage", page);
	modelMap.addAttribute("size", size);
	return "listeEquipes";

}

@RequestMapping("/modifierEquipe")
public String editerEquipe(@RequestParam("id") Long id,@RequestParam("page") int page,ModelMap modelMap)
{List<League> cats = equipeService.getAllLeagues();

	EquipeDTO p= equipeService.getEquipe(id);
modelMap.addAttribute("equipe", p);
modelMap.addAttribute("mode", "edit");
modelMap.addAttribute("leagues", cats);
modelMap.addAttribute("page",page);

return "formEquipe";
}

@RequestMapping("/updateEquipe")
public String updateEquipe(@ModelAttribute("equipe") EquipeDTO equipe,
@RequestParam("date") String date,
ModelMap modelMap) throws ParseException
{
//conversion de la date
 SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
 Date dateCreation = dateformat.parse(String.valueOf(date));
 equipe.setDateCreation(dateCreation);

 equipeService.updateEquipe(equipe);
 List<EquipeDTO> prods = equipeService.getAllEquipes();
 modelMap.addAttribute("equipes", prods);
return "listeEquipes";
}


}

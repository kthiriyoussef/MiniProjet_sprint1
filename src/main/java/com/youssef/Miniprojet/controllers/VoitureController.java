package com.youssef.Miniprojet.controllers;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.youssef.Miniprojet.entities.Voiture;
import com.youssef.Miniprojet.service.VoitureService;
@Controller
public class VoitureController {
	@Autowired
	VoitureService voitureService;
	
	@RequestMapping("/showCreate")
	public String showCreate()
	{
	return "createVoiture";
	}
	
	@RequestMapping("/saveVoiture")
	public String saveVoiture(@ModelAttribute("voiture") Voiture voiture,
	 @RequestParam("date") String date,
	 ModelMap modelMap) throws
	ParseException
	{
	//conversion de la date
	 SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
	 Date Dater = dateformat.parse(String.valueOf(date));
	 voiture.setRelaseDate(Dater);

	Voiture saveVoiture = voitureService.saveVoiture(voiture);
	String msg ="voiture enregistré avec Id "+saveVoiture.getIdVoiture();
	modelMap.addAttribute("msg", msg);
	return "createVoiture";
	}
	@RequestMapping("/ListeVoiture")
	public String listeVoiture(ModelMap modelMap,@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size", defaultValue = "2") int size)
	{
		Page<Voiture> voit = voitureService.getAllVoituresParPage(page, size);
		modelMap.addAttribute("voiture", voit);
		 modelMap.addAttribute("pages", new int[voit.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		return "listeVoitures";
	}
	@RequestMapping("/supprimerVoiture")
	public String supprimerProduit(@RequestParam("id") Long id,ModelMap modelMap,@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size", defaultValue = "2") int size)
	{
	voitureService.deleteVoitureById(id);
	Page<Voiture> voit = voitureService.getAllVoituresParPage(page,size);
			modelMap.addAttribute("voiture", voit);
			modelMap.addAttribute("pages", new int[voit.getTotalPages()]);
			modelMap.addAttribute("currentPage", page);
			modelMap.addAttribute("size", size);
			return "listeVoitures";
	}
	@RequestMapping("/modifierVoiture")
	public String editerProduit(@RequestParam("id") Long id,ModelMap modelMap)
	{
	Voiture v= voitureService.getVoiture(id);
	modelMap.addAttribute("voiture", v);
	return "editerVoiture";
	}
	@RequestMapping("/updateVoiture")
	public String updateProduit(@ModelAttribute("voiture") Voiture voiture,@RequestParam("date") String date,ModelMap modelMap) throws ParseException {
		//conversion de la date
		 SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		 Date dateCreation = dateformat.parse(String.valueOf(date));
		 voiture.setRelaseDate(dateCreation);

		 voitureService.UpdateVoiture(voiture);
		 List<Voiture> voit = voitureService.getAllvoiture();
		 modelMap.addAttribute("voiture", voit);
		return "listeVoitures";
		}
	
	
	
	
	
}



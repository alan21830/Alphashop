package com.xantrix.webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xantrix.webapp.Service.ArticoliService;
import com.xantrix.webapp.domain.Articoli;

@Controller
@RequestMapping("/articoli")
public class ArticoliController
{
	@Autowired
	private ArticoliService articoliService;
	private List<Articoli> recordset;
	@RequestMapping(value="/cerca/{filter}" , method = RequestMethod.GET)
	public String GetArticoliByFilter(@PathVariable("filter") String Filter,Model model )
	{
	
		List<Articoli> articoli = articoliService.SelArticoliByFilter(Filter);
		model.addAttribute("Articoli",articoli);
		return "articoli";
		
	}
	
	@RequestMapping(value = "/infoart/{codart}", method = RequestMethod.GET)
	public String GetDettArticolo(@PathVariable("codart") String CodArt, Model model)
	{
			Articoli articolo = null;
			recordset = articoliService.SelArticoliByFilter(CodArt);
			
			if (recordset != null)
				articolo = recordset.get(0);

			model.addAttribute("Titolo", "Dettaglio Articolo");
			model.addAttribute("Titolo2", "Dati Articolo " + CodArt);
			model.addAttribute("articolo", articolo);

			return "infoArticolo";
	} 
	
	
}

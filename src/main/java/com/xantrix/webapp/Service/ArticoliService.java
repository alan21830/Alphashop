package com.xantrix.webapp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xantrix.webapp.domain.Articoli;
import com.xantrix.webapp.repository.ArticoliRepository;

 

 
public interface ArticoliService 
{
	List <Articoli> SelArticoliByFilter(String Filtro);
	
	List <Articoli> SelArticoliByFilter(String Filtro, String OrderBy, String Tipo);
		
	void InsArticolo(Articoli articolo);
	
	void DelArticolo(String CodArt);
}

 

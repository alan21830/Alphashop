package com.xantrix.webapp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xantrix.webapp.domain.Articoli;
import com.xantrix.webapp.repository.ArticoliRepository;

@Service
public class ArticoliServiceImpl implements ArticoliService
{

	@Autowired 
	ArticoliRepository articoliRepository;
	
	@Override
	public List<Articoli> SelArticoliByFilter(String Filtro) {
		 
		return articoliRepository.SelArticoliByFilter(Filtro);
	}

	@Override
	public List<Articoli> SelArticoliByFilter(String Filtro, String OrderBy, String Tipo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void InsArticolo(Articoli articolo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void DelArticolo(String CodArt) {
		// TODO Auto-generated method stub
		
	}

	
}

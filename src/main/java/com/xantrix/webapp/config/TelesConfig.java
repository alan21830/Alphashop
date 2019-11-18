package com.xantrix.webapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;

@Configuration
public class TelesConfig 
{

	@Bean 
	
	public TilesConfigurer tilesConfigurer()
	{
		TilesConfigurer tilesConfigurer = new TilesConfigurer();
		
		tilesConfigurer.setDefinitions("/WEB-INF/layouts/definitions/tilex.xml");
		tilesConfigurer.setCheckRefresh(true);
		
		return tilesConfigurer;
	}
	
}

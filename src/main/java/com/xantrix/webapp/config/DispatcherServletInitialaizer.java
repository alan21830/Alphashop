 package com.xantrix.webapp.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class DispatcherServletInitialaizer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() 
	{
		return new Class[]
		{ 
			WebApplicationsContextConfig.class 
		};
	}

	@Override
	protected String[] getServletMappings() 
	{
		return new String[] { "/" };
	}
}

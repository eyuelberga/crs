/**
 * 
 */
package com.crsdevelopers.crimereportingsystem.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author eyuel
 *
 */
@Configuration
public class WebMVCConfiguration implements WebMvcConfigurer{
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
	registry.addViewController("/").setViewName("home");
	//registry.addViewController("/error").setViewName("error");
	}

}

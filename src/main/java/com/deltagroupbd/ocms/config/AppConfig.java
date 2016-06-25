package com.deltagroupbd.ocms.config;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.context.MessageSource;


@Configuration
@EnableWebMvc
@Import({ThymeLeafConfig.class})
public class AppConfig extends WebMvcConfigurerAdapter {
    
    /**
	 * Enable static resources using default servlet instead of dispatcher servlet.
	 */
	@Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
	/**
	* Configure ResourceHandlers to serve static resources like CSS/ Javascript etc...
	*/
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
	registry.addResourceHandler("/css/**").addResourceLocations("/css/");
	registry.addResourceHandler("/js/**").addResourceLocations("/js/");
	registry.addResourceHandler("/images/**").addResourceLocations("/images/");
	registry.addResourceHandler("/webjars/**").addResourceLocations("/webjars/");
	}

	/*
     * Configure MessageSource to provide internationalized messages
     *
     */
	/*
    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        return messageSource;
    }
	*/
}
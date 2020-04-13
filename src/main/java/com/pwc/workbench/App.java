package com.pwc.workbench;

import javax.servlet.MultipartConfigElement;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.pwc.workbench.config.EssSettings;

import org.springframework.boot.web.servlet.MultipartConfigFactory;


/**
 * workbench background process entry
 *
 */
@EnableConfigurationProperties({EssSettings.class})
@SpringBootApplication
@ServletComponentScan
@EnableTransactionManagement
@MapperScan(basePackages = "com.pwc.workbench.dao")
public class App extends SpringBootServletInitializer
{

    public static void main( String[] args )
    {
    	SpringApplication.run(App.class, args);
    }
    
    protected SpringApplicationBuilder configure(
            SpringApplicationBuilder application) {
        return application.sources(App.class);
    }
    
    @Bean 
    public MultipartConfigElement multipartConfigElement() { 
    	MultipartConfigFactory config = new MultipartConfigFactory(); 
    	config.setMaxFileSize("300MB");
    	config.setMaxRequestSize("300MB");
    	return config.createMultipartConfig(); }
}



package org.mskcc.cmo.oncmap.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan({"org.mskcc.cmo.oncmap.resources", "org.mskcc.cmo.oncmap.service"})
public class OncotreeMappingsApp extends SpringBootServletInitializer{
	
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(OncotreeMappingsApp.class);
    }
    
    
    public static void main(String[] args) throws Exception {
        SpringApplication.run(OncotreeMappingsApp.class, args);
    }
    
    

}

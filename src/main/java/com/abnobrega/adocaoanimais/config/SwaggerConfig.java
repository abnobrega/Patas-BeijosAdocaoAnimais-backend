package com.abnobrega.adocaoanimais.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	 @Bean
	    public Docket atividadeApi() {
	        return new Docket(DocumentationType.SWAGGER_2)
	                .useDefaultResponseMessages(false)	        		
	                .select()
	                .apis(RequestHandlerSelectors.basePackage("com.abnobrega.adocaoanimais.resources"))
	                .paths(PathSelectors.any())
	                .build()
	                .apiInfo(apiInfo());
	    }
	 
	    // Criar uma instância de ApiInfo que vai para dentro do Docket.
	    private ApiInfo apiInfo(){
	        return new ApiInfoBuilder()
	                .title("Patas & Beijos - Adoção de Animais API")
	                .description("API do Projeto Patas & Beijos - Adoção de Animais")
	                .version("1.0")
	                .contact(contact())
	                .build();	// Método que constroi o objeto.
	    }
	    
	    private Contact contact(){
	        // Dados de contato do desenvolvedor: nome, URL do website e email.
	        // Esses dados vão aparecer na documemntação da API via Swagger
	        return new Contact(
	                "Alexandre Bonturi Nóbrega",
	                "https://github.com/abnobrega",
	                "abonturi@gmail.com"
	                );
	    }	    

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.ong;


import java.util.Collections;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 *
 * @author erikg
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(
                        RequestHandlerSelectors
                                .basePackage("org.una.ong.controllers"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo())
                .tags(new Tag("Proyectos", "Entidad de Proyectos") {},
                        new Tag("Actuaciones", "Entidad de Actuaciones"),
                        new Tag("Ciudades", "Entidad de Ciudades "),
                        new Tag("Inversiones", "Entidad de Inversiones "),
                        new Tag("Paises", "Entidad de Paises "),
                        new Tag("Poblaciones", "Entidad de Poblaciones "),
                        new Tag("Sedes", "Entidad de Sedes ")
                );

    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "ONG",
                "Rest API sobre la administración de proyectos en una ONG.",
                "Versión:2.1.0",
                "https://google.com/",
                new Contact("UNA Sede Región Brunca", "https://srb.una.ac.cr/index.php/es/", "decanatosrb@una.cr"),
                "Apache-2.0", "http://www.apache.org/licenses/LICENSE-2.0", Collections.emptyList()); }
}
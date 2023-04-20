package com.example.demospringboot.config;

import com.example.demospringboot.service.DevService;
import com.example.demospringboot.service.RealService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * A continuacion se muestra como poder crear beans en base a un profile determinado
 * O tambien se puede poner una Negacion como "!qa"
 *
 * Esta es una herramienta muy poderosa, y a mi criterio hay que usarla con CUIDADO
 * Al tener distintas configuracines por Profile desparramadas en el codigo, no podemos controlar
 * o saber rapidamente QUE es lo que estamos creando para un profile y que NO
 *
 * Aca dejo un articulo que explica por que NO usarla
 * https://reflectoring.io/dont-use-spring-profile-annotation/
 */

@Configuration
public class Config {

    @Bean
    @Profile("dev")
    DevService mockService() {
        return new DevService();
    }

    @Bean
    @Profile("!dev")
    RealService realService(){
        return new RealService();
    }
}

package com.example.demospringboot.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * @Configuration denota que esta clase es una Configuracion y a diferencia de otras Annotaciobnes, como @component, @Service , etc,
 * Spring va a poder ejecutar los metodos de su interior a modo de generar la configuracion de nuestra aplicacion
 *
 * @ComponentScan le indica a Spring cuales son los paquetes que deberia escanear para generar el contexto.
 */
@Configuration
@ComponentScan("com.example.demospringboot.*")

/**
 * Por default usa application.properties
 * Pero nosotros podemos indicarle que archivo de properties usar.
 * O bien en base al profile que estemos usando
 *
 * -- Setear dev o qa en RunConfigurations
 */
@PropertySource({
        "classpath:mongo-${spring.profiles.active}.properties"
})
public class MongoConfig {

    /**
     * Aca estoy inyectando propiedades dentro de mi configuracion.
     * Estas properties tienen que estar definidas en environment.properties
     * tambien se les puede agregar un "default value" por ejemplo:
     * @Value("${mongo.port:1234}")
     *
     * en el caso que la porperty NO este definida, se seteara el default value , en este caso 1234
     */

    @Value("${mongo.port}")
    private String port;

    @Value("${mongo.host}")
    private String host;

    @Value("${mongo.database}")
    private String database;

    @Bean
    public MongoClient mongo() {
        ConnectionString connectionString = new ConnectionString("mongodb://" + host + ":" + port + "/"+ database);
        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();

        return MongoClients.create(mongoClientSettings);
    }

    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongo(), database);
    }
}
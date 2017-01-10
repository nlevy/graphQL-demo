package com.liveperson;

import com.liveperson.persistence.schemas.MusicSchema;
import graphql.GraphQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author nirl
 * @since {version}
 */
@Configuration
@ComponentScan(basePackages = {"com.liveperson.persistence"})
public class ApplicationContext {

    @Autowired
    private MusicSchema musicSchema;

    @Bean
    public GraphQL graphQL() throws IllegalAccessException, NoSuchMethodException, InstantiationException {
        return new GraphQL(musicSchema.getSchema());
    }

}

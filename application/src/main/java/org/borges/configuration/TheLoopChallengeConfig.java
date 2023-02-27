package org.borges.configuration;

import org.borges.adapter.PriceAdapter;
import org.borges.persistence.PricePersistencePort;
import org.borges.service.PriceServicePort;
import org.borges.service.impl.PriceServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TheLoopChallengeConfig {

    @Bean
    public PricePersistencePort bookPersistence(){
        return new PriceAdapter();
    }

    @Bean
    public PriceServicePort bookService(){
        return new PriceServiceImpl(bookPersistence());
    }
}

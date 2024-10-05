package com.vti.springframework.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class DIContainer {
    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}

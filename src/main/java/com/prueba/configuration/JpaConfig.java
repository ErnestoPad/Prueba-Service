package com.prueba.configuration;

import javax.sql.DataSource;

import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

public class JpaConfig {

//	 @Bean
//	    public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder, DataSource dataSource) {
//	        return builder
//	                .dataSource(dataSource)
//	                .packages("com.prueba.domain.model")
//	                .persistenceUnit("myJpaUnit")
//	                .build();
//	    }
}
package com.crag.destinationCore.db.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

/**
 * Created by heisenberg on 7/5/18.
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef =  "destinationEntityManagerFactory",
        transactionManagerRef = "destinationTransactionManager",
        basePackages = {"com.crag.destinationCore.db.repo"}
)
public class DestinationDBConfig {

    @Primary
    @Bean(name = "destinationDatasource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource(){
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "destinationEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean destinationEntityManagerFactory
            (
                    EntityManagerFactoryBuilder builder,
                    @Qualifier("destinationDatasource") DataSource dataSource
            ){
        return builder
                .dataSource(dataSource)
                .packages("com.crag.destinationCore.db.domains")
                .persistenceUnit("destination")
                .build();
    }

    @Primary
    @Bean(name = "destinationTransactionManager")
    public PlatformTransactionManager destinationTransactionManager(
            @Qualifier("destinationEntityManagerFactory") EntityManagerFactory
                    destinationEntityManagerFactory
    ) {
        return new JpaTransactionManager(destinationEntityManagerFactory);
    }
}

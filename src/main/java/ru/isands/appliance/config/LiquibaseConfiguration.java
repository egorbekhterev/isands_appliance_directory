package ru.isands.appliance.config;

import liquibase.integration.spring.SpringLiquibase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author: Egor Bekhterev
 * @date: 21.04.2023
 * @project: isands_appliance_directory
 */
@Configuration
public class LiquibaseConfiguration {

    @Bean
    public SpringLiquibase liquibase(DataSource ds) {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setChangeLog("classpath:db/dbchangelog.xml");
        liquibase.setDataSource(ds);
        return liquibase;
    }
}

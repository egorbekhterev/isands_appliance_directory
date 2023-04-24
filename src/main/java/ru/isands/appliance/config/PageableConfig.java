package ru.isands.appliance.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

/**
 * @author: Egor Bekhterev
 * @date: 25.04.2023
 * @project: isands_appliance_directory
 */
@Configuration
public class PageableConfig {

    @Bean
    public Pageable pageable() {
        return PageRequest.of(0, 10);
    }
}

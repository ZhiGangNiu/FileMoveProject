package com.backend.file.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JDBCTemplate {

    @Bean
    public JDBCTemplate initJDBCTemplate() {
        return new JDBCTemplate();
    }
}

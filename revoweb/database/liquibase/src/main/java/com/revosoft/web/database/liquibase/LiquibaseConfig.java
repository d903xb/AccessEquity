package com.revosoft.web.database.liquibase;

import liquibase.spring.SpringLiquibase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LiquibaseConfig {

    @Autowired
    private javax.sql.DataSource dataSource;

    @Bean
    public SpringLiquibase springLiquibase(){
        final SpringLiquibase springLiquibase=new SpringLiquibase();
        springLiquibase.setDataSource(dataSource);
        springLiquibase.setChangeLog("classpath:db-master.xml");
        return springLiquibase;
    }
}

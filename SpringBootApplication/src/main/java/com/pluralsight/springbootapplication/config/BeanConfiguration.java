package com.pluralsight.springbootapplication.config;

import com.pluralsight.helloworldstarter.Hello;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class BeanConfiguration {

//    @Bean
//    public DataSource getDataSource() {
//        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
//        dataSourceBuilder.url("jdbc:postgresql://localhost:5431/postgres?currentSchema=conference_app");
//        dataSourceBuilder.username("postgres");
//        dataSourceBuilder.password("1234");
//        return dataSourceBuilder.build();
//    }

//    @Bean
//    public Hello hello() {
//        Hello hello = new Hello();
//        hello.setName("Tihovar");
//        return hello;
//    }
}

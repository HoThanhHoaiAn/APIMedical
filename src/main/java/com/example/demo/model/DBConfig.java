package com.example.demo.model;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DBConfig{

       @Bean
       public DataSource dataSource(){
          DriverManagerDataSource dataSource = new DriverManagerDataSource();
          dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
          dataSource.setUrl("your url");
          dataSource.setUsername( "username" );
          dataSource.setPassword( "password" );
          return dataSource;
       }

}
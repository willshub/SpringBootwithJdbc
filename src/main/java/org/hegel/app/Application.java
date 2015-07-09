package org.hegel.app;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;


import javax.sql.DataSource;


/**
 * Created by wilsonraphale on 7/3/15.
 */

@SpringBootApplication
public class Application {

  public static void main(String[] args) throws Exception {
    SpringApplication.run(Application.class, args);
  }

  @Bean
  @ConfigurationProperties(prefix = "spring.datasource")
  DataSource hegelDataSource() {

    return DataSourceBuilder.create().build();
  }
}

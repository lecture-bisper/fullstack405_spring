package bitc.fullstack405.jpatest.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Properties;

@Configuration
@PropertySource("classpath:/application.properties")
public class DatabaseConfig {

  @Bean
  @ConfigurationProperties(prefix = "spring.datasource.hikari")
  public HikariConfig hikariConfig() {
    return new HikariConfig();
  }

  @Bean
  public DataSource dataSource() throws Exception {
    DataSource ds = new HikariDataSource(hikariConfig());
    System.out.println(ds.toString());
    return ds;
  }

  @Bean
  @ConfigurationProperties(prefix = "spring.jpa")
  public Properties hibernateConfig() {
    return new Properties();
  }
}













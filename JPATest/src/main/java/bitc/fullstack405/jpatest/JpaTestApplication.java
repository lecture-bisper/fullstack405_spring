package bitc.fullstack405.jpatest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class JpaTestApplication {

  public static void main(String[] args) {
    SpringApplication.run(JpaTestApplication.class, args);
  }

}

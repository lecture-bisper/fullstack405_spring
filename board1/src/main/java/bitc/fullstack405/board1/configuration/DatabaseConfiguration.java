package bitc.fullstack405.board1.configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;
// @Configuration : 해당 클래스 파일이 설정 파일임을 스프링 프레임워크에 알려주는 어노테이션
@Configuration
// @PropertySource : 설정 파일의 위치를 지정하는 어노테이션
@PropertySource("classpath:/application.properties")
public class DatabaseConfiguration {

//  @Autowired : 스프링 프레임워크가 해당 객체를 생성 및 관리하도록 하는 어노테이션
  @Autowired
  private ApplicationContext applicationContext;

//  @Bean : 자바 빈즈를 의미하는 어노테이션, 사용자가 직접 생성한 클래스의 자바 빈즈가 아닌 라이브러리로 제공되는 클래스의 자바 빈즈를 의미함
  @Bean
//  @ConfigurationProperties : 설정 파일 안에서 특정 설정 내용을 가져오는 어노테이션
//  prefix : 접두사, 시작 단어 설정
  @ConfigurationProperties(prefix = "spring.datasource.hikari")
  public HikariConfig hikariConfig() {
//    'application.properties' 파일의 내용 중 'spring.datasource.hikari' 로 시작하는 설정 정보를 모두 가져와서 'HikariConfig' 클래스 타입의 객체를 생성
    return new HikariConfig();
  }

  @Bean
  public DataSource dataSource() throws Exception {
//    DataSource : 데이터베이스 사용 시 커넥션 풀에 데이터베이스 설정 정보를 저장하고 데이터베이스와 연결을 미리 생성한 후 관리하는 클래스
//    HikariCP에서 제공하는 HikariDataSource 클래스 타입의 객체를 사용하여 DataSource 생성
//    객체 생성 시 HikariConfig 클래스 타입의 객체로 데이터베이스 설정 정보를 사용함
    DataSource dataSource = new HikariDataSource(hikariConfig());
    System.out.println(dataSource.toString());
    return dataSource;
  }

//  실제 데이터 베이스 연결 및 사용 정보
  @Bean
  public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
    SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
    sqlSessionFactoryBean.setDataSource(dataSource);

//    setMapperLocations() : mybatis 사용 시 mybatis 의 SQL 쿼리 파일 위치를 설정
//    getResources() : 실체 mybatis의 sql 쿼리 파일을 가져오는 메소드, getResource / getResources 2개가 존재
//    getResource()는 지정된 파일 1개만 가져오기, getResources() 지정된 패턴의 파일을 모두 가져오기
//    ** : 모든 하위 폴더를 의미
//    /sql/**/sql-*.xml : /최상위 폴더 아래에 부모 폴더로 sql 이 있고, 자식 폴더로 여러 단계의 폴더가 존재하고, 시작 파일명이 'sql-' 이며, 확장자명이 '.xml' 인 파일을 모두 사용
    sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:/sql/**/sql-*.xml"));
//    mybatis 설정을 추가하여 사용
    sqlSessionFactoryBean.setConfiguration(mybatisConfig());
    return sqlSessionFactoryBean.getObject();
  }

  @Bean
  public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
    return new SqlSessionTemplate(sqlSessionFactory);
  }

//  마이바티스 설정
  @Bean
  @ConfigurationProperties(prefix = "mybatis.configuration")
  public org.apache.ibatis.session.Configuration mybatisConfig() {
//    org.apache.ibatis.session.Configuration : 스프링 프레임워크의 Configuration 클래스와 이름이 겹치기 때문에 mybatis의 Configuration 클래스는 패키지명까지 모두 입력
//    'application.properties' 파일의 'mybatis.configuration' 로 시작하는 설정 내용을 모두 가져와서 사용함
    return new org.apache.ibatis.session.Configuration();
  }
}













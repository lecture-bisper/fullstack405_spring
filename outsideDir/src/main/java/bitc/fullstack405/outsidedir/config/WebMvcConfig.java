package bitc.fullstack405.outsidedir.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
  @Value("${resources.img.location}")
  private String imgLocation;

  @Value("${resources.upload.location}")
  private String uploadLocation;

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
//    외부 폴더는 원하는 만큼 계속 추가 가능함
//    addResourceHandler(경로) : 스프링 프레임워크 외부에 있는 폴더를 스프링 프레임워크 내부에 있는 폴더인 것으로 인식 시킴, 매개변수로 내부에서 사용할 경로를 받아옴
//    addResourceLocations(경로) : 실제 디스크의 외부 폴더 경로를 입력
//    mac, linux 는 'file://경로명', windows 는 'file:///경로명' 형태로 사용

//    지정한 외부폴더를 스프링의 내부 폴더로 추가
//    registry.addResourceHandler("/img/**").addResourceLocations("file:///C:/fullstack405/img/");

    String path1 = "file:///" + imgLocation;
    String path2 = "file:///" + uploadLocation;

//    지정한 외부 폴더 2개를 하나의 스프링 내부 폴더로 추가
    registry.addResourceHandler("/imgs/**").addResourceLocations(path1, path2);
//    지정한 외부 폴더를 스프링의 내부 폴더로 하나 더 추가
    registry.addResourceHandler("/movies/**").addResourceLocations(path2);
  }
}













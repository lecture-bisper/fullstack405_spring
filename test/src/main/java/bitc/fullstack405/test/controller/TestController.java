package bitc.fullstack405.test.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

  @RequestMapping("/test")
  public String test() throws Exception {
    return "test";
  }
}













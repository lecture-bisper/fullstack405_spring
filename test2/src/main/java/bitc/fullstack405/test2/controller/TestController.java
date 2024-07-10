package bitc.fullstack405.test2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class TestController {

  @RequestMapping("/test")
  public String test() {
    return "test";
  }
}













package bitc.fullstack405.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Test2Controller {

  @RequestMapping("/test2")
  public String test2() {
    return "test2";
  }
}













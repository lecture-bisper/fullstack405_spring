package bitc.fullstack405.jpatest.controller;

import bitc.fullstack405.jpatest.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JpaTestController {
  @Autowired
  private ProductService productService;

  @GetMapping("/")
  public String index() throws Exception {
    productService.finds();
    productService.exists();
    productService.count();
//    productService.delete();
    productService.and();
    productService.or();

    return "success";
  }

  @GetMapping("/query")
  public String query() throws Exception {

    productService.querySelectAll();
    productService.querySelectName();

    return "@Query 사용";
  }
}













package bitc.fullstack405.jpatest.service;

public interface ProductService {

  void finds() throws Exception;
  void exists() throws Exception;
  void count() throws Exception;
  void delete() throws Exception;
  void limit() throws Exception;
  void equals() throws Exception;
  void isNot() throws Exception;
  void isNull() throws Exception;
  void isNotNull() throws Exception;
  void and() throws Exception;
  void or() throws Exception;
  void between() throws Exception;
  void like() throws Exception;
  void orderBy() throws Exception;

  void querySelectAll() throws Exception;
  void querySelectName() throws Exception;
}

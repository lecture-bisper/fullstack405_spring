package bitc.fullstack405.jpatest.service;

import bitc.fullstack405.jpatest.data.entity.ProductEntity;
import bitc.fullstack405.jpatest.data.entity.ProviderEntity;
import bitc.fullstack405.jpatest.data.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

  @Autowired
  private ProductRepository productRepo;

  @Override
  public void finds() throws Exception {
    System.out.println("\n ----- finds() 쿼리 메소드 실행 ----- \n");

//    JpaRepository에서 기본 제공되는 메소드 사용
    Optional<ProductEntity> prod1 = productRepo.findById((long) 1);
//    쿼리 메소드로 생성한 메소드 사용
    System.out.println("쿼리 메소드 findByNumber() 호출");
    Optional<ProductEntity> prod2 = productRepo.findByNumber((long) 1);
    Optional<ProductEntity> prod3  = productRepo.findProductEntityByNumber((long) 2);
    Optional<List<ProductEntity>> prod4 = productRepo.findAllByName("백종원 도시락");
    ProductEntity prod5 = productRepo.queryByName("진짬뽕");

    if (prod1.isPresent()) {
      ProductEntity result = prod1.get();
      System.out.println("상품 번호 : " + result.getNumber());
      System.out.println("상품 이름 : " + result.getName());
      System.out.println("상품 가격 : " + result.getPrice());
      System.out.println("재고 수량 : " + result.getStock());
      System.out.println("등록 날짜 : " + result.getCreatedAt());
    }
    else {
      System.out.println("데이터 없음");
    }

    System.out.println("\n ----- finds() 쿼리 메소드 실행 완료 ----- \n");
  }

  @Override
  public void exists() throws Exception {
    System.out.println("\n ----- exists() 쿼리 메소드 실행 ----- \n");

    boolean isProductNumber = productRepo.existsByNumber((long) 200);

    System.out.println("\n ----- exists() 쿼리 메소드 실행 완료 ----- \n");
  }

  @Override
  public void count() throws Exception {
    System.out.println("\n ----- count() 쿼리 메소드 실행 ----- \n");

    int count = productRepo.countByName("삼각김밥");

    System.out.println("\n ----- count() 쿼리 메소드 실행 완료 ----- \n");
  }

  @Override
  public void delete() throws Exception {
    System.out.println("\n ----- delete() 쿼리 메소드 실행 ----- \n");

//    productRepo.deleteByNumber((long) 1);
    int count = productRepo.removeByName("새우탕면");

    System.out.println("\n ----- delete() 쿼리 메소드 실행 완료 ----- \n");
  }

  @Override
  public void limit() throws Exception {

  }

  @Override
  public void equals() throws Exception {

  }

  @Override
  public void isNot() throws Exception {

  }

  @Override
  public void isNull() throws Exception {

  }

  @Override
  public void isNotNull() throws Exception {

  }

  @Override
  public void and() throws Exception {
    System.out.println("\n ----- and() 쿼리 메소드 실행 ----- \n");

    ProductEntity prod1 = productRepo.findByNumberAndName((long)5, "삼각김밥");
    ProductEntity prod2 = productRepo.findByNumberAndName((long)9, "삼각김밥");

    System.out.println("\n ----- and() 쿼리 메소드 실행 완료 ----- \n");
  }

  @Override
  public void or() throws Exception {
    System.out.println("\n ----- or() 쿼리 메소드 실행 ----- \n");

    List<ProductEntity> prod1 = productRepo.findByNumberOrName((long)5, "새우탕면");

    System.out.println("\n ----- or() 쿼리 메소드 실행 완료 ----- \n");
  }

  @Override
  public void between() throws Exception {

  }

  @Override
  public void like() throws Exception {

  }

  @Override
  public void orderBy() throws Exception {

  }

  @Override
  public void querySelectAll() throws Exception {
    System.out.println("\n ----- @Query 사용, querySelectAll() 실행 ----- \n");

    List<ProductEntity> prodList = productRepo.querySelectAll();

    System.out.println("\n ----- @Query 사용 완료, querySelectAll() 실행 완료 ----- \n");
  }

  @Override
  public void querySelectName() throws Exception {
    System.out.println("\n ----- @Query 사용, querySelectName() 실행 ----- \n");

    ProductEntity prod1 = productRepo.querySelectName();
    ProductEntity prod2 = productRepo.querySelectName("칠성사이다", 1300);
    ProductEntity prod3 = productRepo.querySelectName(1400, "코카콜라제로");

    System.out.println("\n ----- @Query 사용 완료, querySelectName() 실행 완료 ----- \n");
  }
}













package bitc.fullstack405.jpatest.data.repository;

import bitc.fullstack405.jpatest.data.entity.ProductEntity;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

//  JpaRepository를 상속받았기 때문에 JpaRepository가 제공하는 기본 메소드와 쿼리 메소드를 생성하여 사용할 수 있음

//  쿼리 메소드 : JpaRepository에서 제공하는 기본 메소드로는 원하는 데이터를 모두 컨트롤 할 수 없기 때문에 JpaRepository에서 제공하는 주제 키워드를 조합하여 원하는 메소드를 생성할 수 있음

//  쿼리 메소드 생성 방법
//  리턴타입 + {주제 키워드 + 서술어} 를 조합하여 메소드를 생성  ({} 부분은 반복 사용 가능)
//  ex) List<Person> findByLastnameAndEmail(String lastName, String email);

//  쿼리 메소드의 주제 키워드
//  find ... By : select 명령을 수행하는 키워드, read ... By, get ... By, query ... By, search ... By, stream ... By 등이 추가로 존재함
  Optional<ProductEntity> findProductEntityByNumber(Long number); // 기본 사용 방식
  Optional<ProductEntity> findByNumber(Long number); // entity를 이미 지정했기 때문에 생략 가능
  Optional<List<ProductEntity>> findAllByName(String name); // 이름을 기준으로 모든 데이터 가져오기
  ProductEntity queryByName(String name); // 다른 키워드로 데이터 가져오기

//  exists ... By : 특정 데이터가 존재하는지 여부를 확인하는 키워드, true/false 반환
  boolean existsByNumber(Long number); // 지정한 번호의 데이터가 있는지 확인

//  count ... By : select 명령을 수행 후 쿼리 결과로 나온 레코드의 수를 출력하는 키워드
  int countByName(String name);

//  delete ... By, remove ... By : delete 명령을 수행하는 키워드, delete ... By 를 리턴이 없음, remove ... By 는 삭제 수를 반환함
  void deleteByNumber(Long number); // 지정한 번호를 기준으로 데이터 삭제, 반환값 없음
  int removeByName(String name); // 지정한 이름으로 데이터 삭제, 삭제된 데이터 수 반환

//  First<number> ... , Top<number> ... : select 명령을 수행한 후 조회된 결과를 제한하는 키워드
//  주제 키워드와 By 사이에 입력함
  List<ProductEntity> findFirst5ByName(String name); // 조회된 결과 중 처음 5개만 출력
  List<ProductEntity> findTop5ByNumber(Long number); // 조회돈 결과 중 숫자가 큰 것 5개 출력
  
//  Is : 조건 키워드, 값의 일치 여부를 조건으로 사용, Equals와 동일한 기능을 제공
  ProductEntity findByNumberIs(Long number); // 지정한 번호와 같은 데이터를 조회
  ProductEntity findByNumberEquals(Long number); // 지정한 번호와 같은 데이터를 조회

//  (Is)Not : 값의 불일치 조건을 사용하는 조건 키워드, Is 생략할 수 있음
  ProductEntity findByNumberIsNot(Long number); // 지정한 번호와 같지 않은 데이터를 조회
  ProductEntity findByNumberNot(Long number); // 지정한 번호와 같지 않은 데이터를 조회

//  (Is)Null, (Is)NotNull : 값이 null인지 확인하는 조건 키워드, Is 생략 가능
  List<ProductEntity> findByUpdatedAtNull(); // 수정된 데이터가 null인 것만 조회
  List<ProductEntity> findByUpdatedAtIsNull();
  List<ProductEntity> findByUpdatedAtNotNull(); // 수정된 데이터가 null이 아닌 것만 조회
  List<ProductEntity> findByUpdatedAtIsNotNull();

//  (Is)True, (Is)False : Boolean 데이터 타입으로 지정된 컬럼 값을 확인하는 키워드
////  List<ProductEntity> findByisActiveTrue();
////  List<ProductEntity> findByisActiveIsTrue();
////  List<ProductEntity> findByisActiveFalse();
//  List<ProductEntity> findByisActiveIsFalse();

//  And, Or : 조건을 추가하는 키워드
  ProductEntity findByNumberAndName(Long number, String name); // and 명령으로 조회 조건을 추가, 지정한 번호와 지정한 이름이 같은 데이터를 조회
  List<ProductEntity> findByNumberOrName(Long number, String name); // or 명령으로 조회 조건을 추가, 지정한 번호나 지정한 이름을 가지고 있는 데이터를 조회

//  (Is)GreaterThen, (Is)LessThen, (Is)Between : 숫자나 datetime 컬럼을 대상으로 비교 연산에 사용할 수 있는 조건 키워드
//  경계값을 포함할 경우 Equal 키워드를 추가
  List<ProductEntity> findByPriceIsGreaterThan(long price); // 지정한 가격 초과 데이터 조회
  List<ProductEntity> findByPriceGreaterThan(long price);
  List<ProductEntity> findByPriceGreaterThanEqual(long price); // 지정한 가격 이상의 데이터 조회

  List<ProductEntity> findByPriceIsLessThan(long price); // 지정한 가격 미만 데이터 조회
  List<ProductEntity> findByPriceLessThan(long price);
  List<ProductEntity> findByPriceLessThanEqual(long price); // 지정한 가격 이하의 데이터 조회

  List<ProductEntity> findByPriceIsBetween(long lowPrice, long highPrice); // 지정한 낮은 데이터부터 높은 데이터까지의 모든 데이터를 조회
  List<ProductEntity> findByPriceBetween(long lowPrice, long highPrice);

//  (Is)Like, (Is)Containing, (Is)StartingWith, (Is)EndingWith : 데이터가 일부 일치하는지 여부를 확인하는 조건 키워드
//  Like : 키워드가 포함되어 있을 경우
  List<ProductEntity> findByNameLike(String name); // 지정한 문자열이 포함되어 있는 이름 조회
  List<ProductEntity> findByNameIsLike(String name);

//  Containing : 키워드가 문자열의 양 끝에 있을 경우
  List<ProductEntity> findByNameContains(String name); // 지정한 문자열이 양끝에 포함되어 있는 이름 조회
  List<ProductEntity> findByNameContaining(String name);
  List<ProductEntity> findByNameIsContaining(String name);

//  StartingWith : 키워드가 시작 문자열일 경우
  List<ProductEntity> findByNameStartsWith(String name); // 지정한 문자열로 시작하는 이름 조회
  List<ProductEntity> findByNameStartingWith(String name);
  List<ProductEntity> findByNameIsStartingWith(String name);

//  EndingWith : 키워드가 끝 문자열일 경우
  List<ProductEntity> findByNameEndsWith(String name); // 지정한 문자열로 끝나는 이름 조회
  List<ProductEntity> findByNameEndingWith(String name);
  List<ProductEntity> findByNameIsEndingWith(String name);

//  OrderBy ... Asc|Desc ... Asc|Desc : 쿼리문의 결과를 지정한 컬럼으로 정렬하는 키워드
  List<ProductEntity> findByNameOrderByNumberAsc(String name); // 지정한 이름으로 데이터를 조회 후 번호를 기준으로 오름차순 정렬
  List<ProductEntity> findByNameOrderByNumberDesc(String name); // 지정한 이름으로 데이터를 조회 후 번호를 기준으로 내림차순 정렬
  List<ProductEntity> findByNameOrderByPriceAscStockDesc(String name); // 지정한 이름으로 데이터를 조회 후 가격을 기준으로 오름차순 정렬을 먼저 진행하고, 재고 수량을 기준으로 내림차순 정렬

//  정렬 사용 시 Sort 객체를 사용하여 정렬하는 것이 가능함
//  쿼리 메소드 생성 후 매개변수에 Sort 객체를 추가하여 정렬
//  List<ProductEntity> findByName(String name); 와 같이 쿼리 메소드를 생성 후 실행 시 Sort 객체를 추가하여 실행
//  productRepository.findByName("도시락", Sort.by(Order.asc("price")));
//  productRepository.findByName("도시락", Sort.by(Order.asc("price"), Order.desc("stock")));

//  @Query : 복잡한 쿼리문은 쿼리 메소드로 생성하기가 힘들기 때문에 @Query 라는 어노테이션을 제공함
//  JPQL(JPA SQL) 문법을 사용하여 SQL 쿼리를 생성하여 복잡한 쿼리문을 실행할 수 있도록 도와줌
//  검색 조건에 '?순번' 형태로 데이터를 사용함

//  사용법 :
//  @Query("select entity객체명 from entity클래스명 where 검색조건1, 검색조건2, ... ")
//  반환타입 메소드명(매개변수1, 매개변수2, ...);

  @Query("SELECT p FROM ProductEntity AS p")
  List<ProductEntity> querySelectAll();

//  FROM 다음에 entity 클래스명을 입력
//  AS 명령을 사용하여 클래스의 별명을 입력
//  SELECT 절에 클래스의 별명.컬럼명으로 출력하고자 하는 컬럼만 입력
//  전체 컬럼을 출력 시 클래스의 별명만 입력 ( * 아님)
//  WHERE 절에는 클래스 별명.컬럼명 형태로 사용
  @Query("SELECT p FROM ProductEntity AS p WHERE p.name = '코카콜라'")
  ProductEntity querySelectName();

//  메소드의 매개변수를 쿼리문에 적용할 경우 '?순번' 형식으로 입력하여 데이터를 매칭함
//  순번은 1번부터 시작하고, 매개변수의 순서대로 적용됨
  @Query("SELECT p FROM ProductEntity AS p WHERE p.name = ?1 AND p.price = ?2 ")
  ProductEntity querySelectName(String name, long price);

//  메소드의 매개변수를 쿼리문에 적용할 경우 ':매개변수명' 형식으로 입력하여 데이터를 매칭함
//  ':매개변수명' 방식은 메소드의 매개변수 앞에 @Param("컬럼명") 어노테이션을 사용해야 함
//  ':매개변수명' 방식은 매개변수의 순서와 상관없음
  @Query("SELECT p FROM ProductEntity AS p WHERE p.name = :name AND p.price = :price ")
  ProductEntity querySelectName(@Param("price") long price, @Param("name") String name);

}












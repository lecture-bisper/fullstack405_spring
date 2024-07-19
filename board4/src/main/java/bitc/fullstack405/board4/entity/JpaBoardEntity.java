package bitc.fullstack405.board4.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

// @Entity : JPA에서 해당 클래스가 데이터베이스의 테이블이라는 것을 알려주는 어노테이션
// 테이블 생성 시 클래스명이 테이블명으로 사용
// 사용자가 원하는 데이터베이스 테이블명을 사용하고자할 경우 @Table 어노테이션을 사용함
// MyBatis의 DTO 클래스 역할도 함께 함
@Entity

// @Table : 지정한 엔티티와 실제 데이터베이스의 테이블을 연동
// name 속성을 사용하여 사용자가 원하는 이름의 테이블명을 설정할 수 있음
@Table(name = "jpa_board")

// @NoArgsConstructor : 매개변수가 없는 기본 생성자를 생성하는 어노테이션
@NoArgsConstructor

// @AllArgsConstructor : 모든 필드에 대한 매개변수가 있는 생성자를 자동으로 생성하는 어노테이션
@AllArgsConstructor
@Data
public class JpaBoardEntity {

//  @Id : 해당 필드가 데이터베이스의 기본키 임을 나타내는 어노테이션
  @Id
//  @GeneratedValue : 데이터가 추가될 경우 값을 자동으로 증가할지 여부를 지정하는 어노테이션
//  AUTO : 선택한 데이터베이스에 따라 자동으로 선택
//  IDENTITY : 기본 키 생성을 데이터베이스에 위임 (데이터베이스 설정에 따름)
//  SEQUENCE : 데이터베이스 시퀀스를 사용하여 기본 키를 설정 (ORACLE에서 사용)
//  TABLE : 키 생성 테이블을 사용
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int boardIdx;

//  @Column : 지정한 필드를 데이터베이스의 컬럼과 연동시키는 어노테이션
//  해당 어노테이션이 없어도 기본적으로 컬럼으로 인식
//  컬럼이 가지고 있는 특성을 적용 시 사용
//  기본적으로 자바 클래스에서 카멜 명명법을 사용 시 데이터베이스에서 스네이크 명명법으로 적용

//  unique : 컬럼의 유니크 여부 설정 (기본 false)
//  nullable : 컬럼의 null 허용 여부 설정 (기본 true)
//  updatable : 컬럼의 수정 가능 여부 설정
//  length : 컬럼에 저장될 최대 데이터 크기를 설정
//  name : 실제 데이터베이스 테이블의 컬럼명을 설정
//  precision : BigDecimal, BigInteger 타입 사용 시 소수점의 자리를 포함하여 전체 자리 수 설정
//  scale : BigDecimal, BigInteger 타입 사용 시 소수점의 자리 수 설정
  @Column(name = "title", length = 100, nullable = false)
  private String title;

  @Column(nullable = false)
  private String contents;

//  데이터 입력 형식 설정, 시간대가 Asia/Seoul 로 설정
  @Column(nullable = false)
  private LocalDateTime createDate = LocalDateTime.now();

  @Column(nullable = false)
  private String createUser;

//  @Column 어노테이션 미사용 시 기본값으로 모두 적용
  private LocalDateTime updateDate;

  private String updateUser;

  @Column(nullable = false)
  private int hitCnt;
}













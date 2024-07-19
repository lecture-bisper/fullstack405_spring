package bitc.fullstack405.jpatest.data.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

// 상품 상세 테이블

@Entity
@Table(name = "jpa_product_detail")
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class ProductDetailEntity extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String description;

//  아래의 필드는 부모 클래스인 BaseEntity로 부터 상속받아 사용함
  @Column(nullable = false)
  private LocalDateTime createdAt = LocalDateTime.now();

  private LocalDateTime updatedAt;

//  @JoinColumn : 관계가 설정된 테이블에서 참조키를 설정하는 어노테이션
  @OneToOne
  @JoinColumn(name = "product_name")
  private ProductEntity product;
}













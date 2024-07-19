package bitc.fullstack405.jpatest.data.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

// 상품 테이블

@Entity
@Table(name = "jpa_product")
@Getter
@Setter
@NoArgsConstructor
// callSuper : 부모 클래스의 필드를 해당 클래스에 포함하는 역할을 하는 속성, 롬복에서 제공
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class ProductEntity extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long number; // 상품번호

  @Column(nullable = false)
  private String name; // 상품 이름

  @Column(nullable = false)
  private long price; // 가격

  @Column(nullable = false)
  private int stock; // 재고 수량

//  아래의 필드는 부모 클래스인 BaseEntity로 부터 상속받아 사용함
  @Column(nullable = false)
  private LocalDateTime createdAt = LocalDateTime.now(); // 등록 시간

  private LocalDateTime updatedAt; // 최종 수정 시간

//  @OneToOne : 다른 Entity 와 1:1 관계를 가진다는 것을 알려주는 어노테이션
//  @OneToMany : 다른 Entity 와 1:N 관계를 가진다는 것을 알려주는 어노테이션
//  @ManyToOne : 다른 Entity 와 N:1 관계를 가진다는 것을 알려주는 어노테이션

//  mappedBy : @OneToOne 어노테이션 사용 시 양방향 매핑이 아니면 사용하지 않아도 됨, 기준이 되는 테이블에 사용
//  @ToString.Exclude : 두 개의 Entity를 양방향 관계 설정 시 ToString을 사용하면 순환참조가 발생하기 때문에 순환 참조를 제거하기 위해서 사용, 양방향 관계 설정이 아니면 사용할 필요없음
  @OneToOne(mappedBy = "product")
  @ToString.Exclude
  private ProductDetailEntity productDetail;

  @ManyToOne
  @JoinColumn(name = "provider_id")
  @ToString.Exclude
  private ProviderEntity provider;
}













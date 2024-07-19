package bitc.fullstack405.jpatest.data.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "jpa_provider")
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class ProviderEntity extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column
  private String name;

//  영속성 전이 : JPA로 관계 설정이 되어 있는 데이터베이스 사용 시 메인 Entity의 데이터가 변경될 경우 서브 Entity의 데이터도 함께 수정되는 것
//  cascade : 영속성 전이 설정을 위한 속성
//    - All : 모든 영속 상태 변경에 대해서 영속성 전이를 적용
//    - PERSIST : Entity 가 영속화할 때 연관된 Entity도 함께 영속화
//    - MERGE : Entity를 영속성 컨텍스트에 병합할 때 연관된 Entity도 병합
//    - REMOVE : Entity를 제거할 때 연관된 Entity도 함께 제거
//    - REFRESH : Entity를 새로고침할 때 연관된 Entity도 새로 고침
//    - DETACH : Entity를 연속성 컨텍스트에서 제외하면 연관된 Entity도 제외
  @OneToMany(mappedBy = "provider", cascade = CascadeType.ALL)
  @ToString.Exclude
  private List<ProductEntity> productList = new ArrayList<>();
}













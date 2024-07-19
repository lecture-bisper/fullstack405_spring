package bitc.fullstack405.jpatest.data.repository;

import bitc.fullstack405.jpatest.data.entity.ProductDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDetailRepository extends JpaRepository<ProductDetailEntity, Long> {
}

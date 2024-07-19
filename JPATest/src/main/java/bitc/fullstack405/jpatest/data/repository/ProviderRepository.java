package bitc.fullstack405.jpatest.data.repository;

import bitc.fullstack405.jpatest.data.entity.ProviderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProviderRepository extends JpaRepository<ProviderEntity, Long> {
}

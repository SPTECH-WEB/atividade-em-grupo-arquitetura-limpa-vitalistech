package vitalis.tech.vitalis.infrastructure.persistence.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vitalis.tech.vitalis.infrastructure.persistence.jpa.ClienteEntity;

import java.util.UUID;

@Repository
public interface ClienteJpaRepository extends JpaRepository<ClienteEntity, UUID> {
    boolean existsByCpf(String cpf);
    boolean existsByEmail(String email);
}
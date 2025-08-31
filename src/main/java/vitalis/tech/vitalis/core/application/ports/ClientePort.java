package vitalis.tech.vitalis.core.application.ports;

import vitalis.tech.vitalis.core.domain.cliente.Cliente;

import java.util.Optional;
import java.util.UUID;

public interface ClientePort {
    Cliente salvar (Cliente cliente);
    Optional<Cliente> buscarPorId(UUID id);

    boolean existsByCpf(String cpf);
    boolean existsByEmail(String email);
}
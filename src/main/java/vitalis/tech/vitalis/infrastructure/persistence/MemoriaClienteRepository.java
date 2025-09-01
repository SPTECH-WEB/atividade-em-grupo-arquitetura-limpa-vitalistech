package vitalis.tech.vitalis.infrastructure.persistence;

import org.springframework.stereotype.Repository;
import vitalis.tech.vitalis.core.application.ports.ClientePort;
import vitalis.tech.vitalis.core.domain.cliente.Cliente;

import java.util.*;

@Repository
public class MemoriaClienteRepository implements ClientePort {

    private final Map<UUID, Cliente> clientesMap = new HashMap<>();

    @Override
    public Cliente salvar(Cliente cliente) {
        clientesMap.put(cliente.getId(), cliente);
        return cliente;
    }

    public Optional<Cliente> buscarPorId(UUID id) {
        return Optional.ofNullable(clientesMap.get(id));
    }

    @Override
    public boolean existsByCpf(String cpf) {
        return clientesMap.values().stream()
                .anyMatch(cliente -> cliente.getCpf().getValue().equals(cpf));
    }

    @Override
    public boolean existsByEmail(String email) {
        return clientesMap.values().stream()
                .anyMatch(cliente -> cliente.getEmail().getValue().equals(email));
    }
}
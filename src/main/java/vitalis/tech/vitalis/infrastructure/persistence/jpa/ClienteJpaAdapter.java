package vitalis.tech.vitalis.infrastructure.persistence.jpa;

import org.springframework.stereotype.Component;
import vitalis.tech.vitalis.core.application.ports.ClientePort;
import vitalis.tech.vitalis.core.domain.cliente.Cliente;

import java.util.Optional;
import java.util.UUID;

@Component
public class ClienteJpaAdapter implements ClientePort {

    private final ClienteJpaRepository clienteJpaRepository;
    private final ClienteEntityMapper clienteEntityMapper;

    public ClienteJpaAdapter(ClienteJpaRepository clienteJpaRepository, ClienteEntityMapper clienteEntityMapper) {
        this.clienteJpaRepository = clienteJpaRepository;
        this.clienteEntityMapper = clienteEntityMapper;
    }

    @Override
    public Cliente salvar(Cliente cliente) {
        ClienteEntity entity = clienteEntityMapper.toEntity(cliente);
        ClienteEntity savedEntity = clienteJpaRepository.save(entity);
        cliente.setId(savedEntity.getId());
        return cliente;
    }

    @Override
    public Optional<Cliente> buscarPorId(UUID id) {
        return clienteJpaRepository.findById(id)
                .map(ClienteEntityMapper::toDomain);
    }

    @Override
    public boolean existsByCpf(String cpf) {
        return clienteJpaRepository.existsByCpf(cpf);
    }

    @Override
    public boolean existsByEmail(String email) {
        return clienteJpaRepository.existsByEmail(email);
    }
}
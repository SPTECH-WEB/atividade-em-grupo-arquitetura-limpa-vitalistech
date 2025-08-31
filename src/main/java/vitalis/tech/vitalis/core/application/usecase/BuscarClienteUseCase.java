package vitalis.tech.vitalis.core.application.usecase;

import vitalis.tech.vitalis.core.application.ports.ClientePort;
import vitalis.tech.vitalis.core.domain.cliente.Cliente;

import java.util.Optional;
import java.util.UUID;

public class BuscarClienteUseCase {
    private final ClientePort clientePort;
    public BuscarClienteUseCase(ClientePort clientePort){
        this.clientePort = clientePort;
    }

    public Optional<Cliente> execute(UUID id){
        return clientePort.buscarPorId(id);
    }
}
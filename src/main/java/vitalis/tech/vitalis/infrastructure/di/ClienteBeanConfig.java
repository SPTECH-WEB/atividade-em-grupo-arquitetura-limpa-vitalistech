package vitalis.tech.vitalis.infrastructure.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import vitalis.tech.vitalis.core.application.ports.ClientePort;
import vitalis.tech.vitalis.core.application.ports.RiscoClientePort;
import vitalis.tech.vitalis.core.application.usecase.BuscarClienteUseCase;
import vitalis.tech.vitalis.core.application.usecase.CadastrarClienteUseCase;
import vitalis.tech.vitalis.core.domain.cliente.RiscoClienteService;
import vitalis.tech.vitalis.infrastructure.persistence.jpa.ClienteJpaAdapter;
import vitalis.tech.vitalis.infrastructure.persistence.jpa.ClienteJpaRepository;
import vitalis.tech.vitalis.infrastructure.persistence.jpa.ClienteEntityMapper;

@Configuration
public class ClienteBeanConfig {

    @Bean
    public RiscoClientePort riscoClientePort() {
        return new RiscoClienteService();
    }

    @Bean
    public CadastrarClienteUseCase cadastrarClienteUseCase(ClientePort clientePort, RiscoClientePort riscoClientePort) {
        return new CadastrarClienteUseCase(clientePort, riscoClientePort);
    }

    @Bean
    public BuscarClienteUseCase buscarClienteUseCase(ClientePort clientePort) {
        return new BuscarClienteUseCase(clientePort);
    }

    @Bean
    public ClientePort clientePort(ClienteJpaRepository clienteJpaRepository, ClienteEntityMapper clienteEntityMapper) {
        return new ClienteJpaAdapter(clienteJpaRepository, clienteEntityMapper);
    }
}
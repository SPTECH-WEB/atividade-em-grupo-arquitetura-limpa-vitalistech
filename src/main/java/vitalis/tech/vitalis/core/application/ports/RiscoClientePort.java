package vitalis.tech.vitalis.core.application.ports;

import vitalis.tech.vitalis.core.domain.cliente.RiscoCliente;

public interface RiscoClientePort {
    RiscoCliente avaliar(Float rendaMensal, Integer idade);
}
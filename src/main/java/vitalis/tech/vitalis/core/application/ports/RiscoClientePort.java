package vitalis.tech.vitalis.core.application.ports;

import vitalis.tech.vitalis.core.domain.valueobject.RiscoCliente;

public interface RiscoClientePort {
    RiscoCliente avaliar(Float rendaMensal, Integer idade);
}
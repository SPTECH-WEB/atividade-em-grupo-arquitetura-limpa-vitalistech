package vitalis.tech.vitalis.core.domain.cliente;

import vitalis.tech.vitalis.core.application.ports.RiscoClientePort;
import vitalis.tech.vitalis.core.domain.valueobject.RiscoCliente;

public class RiscoClienteService implements RiscoClientePort {

    @Override
    public RiscoCliente avaliar(Float rendaMensal, Integer idade) {
        return RiscoCliente.avaliarRisco(rendaMensal, idade);
    }
}

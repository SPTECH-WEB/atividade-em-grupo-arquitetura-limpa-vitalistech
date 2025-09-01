package vitalis.tech.vitalis.core.domain.cliente;

import vitalis.tech.vitalis.core.application.ports.RiscoClientePort;

public class RiscoClienteService implements RiscoClientePort {

    @Override
    public RiscoCliente avaliar(Float rendaMensal, Integer idade) {
        return RiscoCliente.avaliarRisco(rendaMensal, idade);
    }
}

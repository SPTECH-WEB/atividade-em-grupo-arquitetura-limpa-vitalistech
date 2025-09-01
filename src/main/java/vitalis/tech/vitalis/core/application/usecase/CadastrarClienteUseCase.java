package vitalis.tech.vitalis.core.application.usecase;

import vitalis.tech.vitalis.core.application.command.CadastrarClienteCommand;
import vitalis.tech.vitalis.core.application.exception.DuplicadosException;
import vitalis.tech.vitalis.core.application.ports.ClientePort;
import vitalis.tech.vitalis.core.application.ports.RiscoClientePort;
import vitalis.tech.vitalis.core.domain.cliente.Cliente;
import vitalis.tech.vitalis.core.domain.valueobject.Cpf;
import vitalis.tech.vitalis.core.domain.valueobject.Email;
import vitalis.tech.vitalis.core.domain.RiscoCliente;
import vitalis.tech.vitalis.core.domain.valueobject.Telefone;

public class CadastrarClienteUseCase {
    private final ClientePort clientePort;
    private final RiscoClientePort riscoClientePort;

    public CadastrarClienteUseCase(ClientePort clientePort, RiscoClientePort riscoClientePort) {
        this.clientePort = clientePort;
        this.riscoClientePort = riscoClientePort;
    }

    public Cliente execute(CadastrarClienteCommand command) {

        if (clientePort.existsByCpf(command.getCpf())) {
            throw new DuplicadosException("CPF já cadastrado no sistema.");
        }
        if (clientePort.existsByEmail(command.getEmail())) {
            throw new DuplicadosException("E-mail já cadastrado no sistema.");
        }
        Cliente cliente = new Cliente(
                command.getNome(),
                new Email(command.getEmail()),
                new Telefone(command.getTelefone()),
                new Cpf(command.getCpf()),
                command.getRendaMensal(),
                command.getIdade(),
                command.getProfissao()
        );

        RiscoCliente risco = riscoClientePort.avaliar(cliente.getRendaMensal(), cliente.getIdade());
        cliente.setRisco(risco);
        return clientePort.salvar(cliente);
    }
}
package vitalis.tech.vitalis.infrastructure.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vitalis.tech.vitalis.core.application.command.CadastrarClienteCommand;
import vitalis.tech.vitalis.core.application.usecase.BuscarClienteUseCase;
import vitalis.tech.vitalis.core.application.usecase.CadastrarClienteUseCase;
import vitalis.tech.vitalis.core.domain.cliente.Cliente;
import vitalis.tech.vitalis.infrastructure.web.dtos.ClienteRequest;
import vitalis.tech.vitalis.infrastructure.web.dtos.ClienteResponse;

import java.net.URI;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final CadastrarClienteUseCase cadastrarClienteUseCase;
    private final BuscarClienteUseCase buscarClienteUseCase;

    public ClienteController(CadastrarClienteUseCase cadastrarClienteUseCase, BuscarClienteUseCase buscarClienteUseCase) {
        this.cadastrarClienteUseCase = cadastrarClienteUseCase;
        this.buscarClienteUseCase = buscarClienteUseCase;
    }

    @PostMapping
    public ResponseEntity<ClienteResponse> criarCliente(@RequestBody ClienteRequest request) {
        CadastrarClienteCommand command = new CadastrarClienteCommand(
                request.getNome(),
                request.getEmail(),
                request.getTelefone(),
                request.getCpf(),
                request.getRendaMensal(),
                request.getIdade(),
                request.getProfissao()
        );

        Cliente clienteCriado = cadastrarClienteUseCase.execute(command);

        ClienteResponse response = ClienteResponse.fromDomain(clienteCriado);
        return ResponseEntity.created(URI.create("/clientes/" + clienteCriado.getId()))
                .body(response);
    }


    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponse> buscarCliente(@PathVariable UUID id) {
        Optional<Cliente> cliente = buscarClienteUseCase.execute(id);

        if (cliente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(ClienteResponse.fromDomain(cliente.get()));
    }
}
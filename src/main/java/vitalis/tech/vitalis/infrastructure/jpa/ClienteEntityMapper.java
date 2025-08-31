package vitalis.tech.vitalis.infrastructure.persistence.jpa;

import org.springframework.stereotype.Component;
import vitalis.tech.vitalis.core.domain.cliente.Cliente;
import vitalis.tech.vitalis.core.domain.cliente.RiscoCliente;
import vitalis.tech.vitalis.core.domain.valueobject.Cpf;
import vitalis.tech.vitalis.core.domain.valueobject.Email;
import vitalis.tech.vitalis.core.domain.valueobject.Telefone;
import vitalis.tech.vitalis.infrastructure.persistence.jpa.ClienteEntity;

import java.util.Objects;

@Component
public class ClienteEntityMapper {

    public ClienteEntity toEntity(Cliente cliente){

        ClienteEntity enitity = new ClienteEntity();


        enitity.setNome(cliente.getNome());
        enitity.setEmail(cliente.getEmail().getValue());
        enitity.setTelefone(cliente.getTelefone().getNumero());
        enitity.setCpf(cliente.getCpf().getValue());
        enitity.setRendaMensal(cliente.getRendaMensal());
        enitity.setIdade(cliente.getIdade());
        enitity.setProfissao(cliente.getProfissao());
        enitity.setRisco(cliente.getRisco().name());
        enitity.setEstrategiaContato(cliente.getEstrategiaContato());

        return enitity;
    }

    public static Cliente toDomain(ClienteEntity entity){
        Email email = new Email(entity.getEmail());
        Telefone telefone = new Telefone(entity.getTelefone());
        Cpf cpf = new Cpf(entity.getCpf());

        Cliente cliente = new Cliente(
                entity.getNome(),
                email,
                telefone,
                cpf,
                entity.getRendaMensal(),
                entity.getIdade(),
                entity.getProfissao()
        );
        cliente.setId(entity.getId());

        RiscoCliente risco = RiscoCliente.valueOf(entity.getRisco());
        cliente.setRisco(risco);

        return cliente;

    }

}
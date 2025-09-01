package vitalis.tech.vitalis.core.domain.cliente;

import vitalis.tech.vitalis.core.domain.valueobject.Cpf;
import vitalis.tech.vitalis.core.domain.valueobject.Email;
import vitalis.tech.vitalis.core.domain.valueobject.RiscoCliente;
import vitalis.tech.vitalis.core.domain.valueobject.Telefone;

import java.util.Objects;
import java.util.UUID;

public class Cliente {
    private UUID id;
    private String nome;
    private Email email;
    private Telefone telefone;
    private Cpf cpf;
    private Float rendaMensal;
    private Integer idade;
    private String profissao;
    private RiscoCliente risco;
    private String estrategiaContato;

    public Cliente(String nome, Email email, Telefone telefone, Cpf cpf,
                   Float rendaMensal, Integer idade, String profissao) {

        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do cliente é obrigatório.");
        }

        Objects.requireNonNull(email, "O email não pode ser nulo.");
        Objects.requireNonNull(telefone, "O telefone não pode ser nulo.");
        Objects.requireNonNull(cpf, "O CPF não pode ser nulo.");

        if (rendaMensal == null || rendaMensal < 0) {
            throw new IllegalArgumentException("A renda mensal é obrigatória e não pode ser negativa.");
        }
        if (idade == null || idade <= 0) {
            throw new IllegalArgumentException("A idade é obrigatória e deve ser um valor positivo.");
        }
        if (profissao == null || profissao.trim().isEmpty()) {
            throw new IllegalArgumentException("A profissão é obrigatória.");
        }

        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.cpf = cpf;
        this.rendaMensal = rendaMensal;
        this.idade = idade;
        this.profissao = profissao;
    }

    public void setId(UUID id) {
        this.id = id;
    }



    public UUID getId() { return id; }
    public String getNome() { return nome; }
    public Email getEmail() { return email; }
    public Telefone getTelefone() { return telefone; }
    public Cpf getCpf() { return cpf; }
    public Float getRendaMensal() { return rendaMensal; }
    public Integer getIdade() { return idade; }
    public String getProfissao() { return profissao; }
    public RiscoCliente getRisco() { return risco; }
    public String getEstrategiaContato() { return estrategiaContato; }

    public void setRisco(RiscoCliente risco) {
        this.risco = risco;
        this.estrategiaContato = risco.getEstrategiaContato();
}
}
package vitalis.tech.vitalis.infrastructure.web.dtos;

import vitalis.tech.vitalis.core.domain.cliente.Cliente;

import java.util.UUID;

public class ClienteResponse {
    private UUID id;
    private String nome;
    private String email;
    private String telefone;
    private String cpf;
    private Float rendaMensal;
    private Integer idade;
    private String profissao;
    private String risco;
    private String estrategiaContato;

    public static ClienteResponse fromDomain(Cliente cliente) {
        ClienteResponse response = new ClienteResponse();
        response.setId(cliente.getId());
        response.setNome(cliente.getNome());
        response.setEmail(cliente.getEmail().getValue());
        response.setTelefone(cliente.getTelefone().getNumero());
        response.setCpf(cliente.getCpf().getValue());
        response.setRendaMensal(cliente.getRendaMensal());
        response.setIdade(cliente.getIdade());
        response.setProfissao(cliente.getProfissao());
        response.setRisco(cliente.getRisco().name());
        response.setEstrategiaContato(cliente.getEstrategiaContato());
        return response;
    }

    public void setRendaMensal(Float rendaMensal) {
        this.rendaMensal = rendaMensal;
    }
    // Getters e Setters


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Float getRendaMensal() {
        return rendaMensal;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String getRisco() {
        return risco;
    }

    public void setRisco(String risco) {
        this.risco = risco;
    }

    public String getEstrategiaContato() {
        return estrategiaContato;
    }

    public void setEstrategiaContato(String estrategiaContato) {
        this.estrategiaContato = estrategiaContato;
    }
}
package vitalis.tech.vitalis.infrastructure.persistence.jpa;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "cliente")
public class ClienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Version
    private Long version = 0L;


    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String telefone;

    @Column(nullable = false, unique = true)
    private String cpf;

    @Column( nullable = false)
    private Float rendaMensal;

    @Column(nullable = false)
    private Integer idade;

    private String profissao;

    @Column(nullable = false)
    private String risco;

    @Column(nullable = false)
    private String estrategiaContato;

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

    public void setRendaMensal(Float rendaMensal) {
        this.rendaMensal = rendaMensal;
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
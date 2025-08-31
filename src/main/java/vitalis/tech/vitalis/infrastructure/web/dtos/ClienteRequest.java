package vitalis.tech.vitalis.infrastructure.web.dtos;

public class ClienteRequest {
    private String nome;
    private String email;
    private String telefone;
    private String cpf;
    private Float rendaMensal;
    private Integer idade;
    private String profissao;


    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public Float getRendaMensal() { return rendaMensal; }
    public void setRendaMensal(Float rendaMensal) { this.rendaMensal = rendaMensal; }

    public Integer getIdade() { return idade; }
    public void setIdade(Integer idade) { this.idade = idade; }

    public String getProfissao() { return profissao; }
    public void setProfissao(String profissao) { this.profissao = profissao;}
}
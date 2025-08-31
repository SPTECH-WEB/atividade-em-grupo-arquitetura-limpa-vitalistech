package vitalis.tech.vitalis.core.application.command;

public class CadastrarClienteCommand {
    private final String nome;
    private final String email;
    private final String telefone;
    private final String cpf;
    private final Float rendaMensal;
    private final Integer idade;
    private final String profissao;

    public CadastrarClienteCommand(String nome, String email, String telefone, String cpf,
                                   Float rendaMensal, Integer idade, String profissao) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.cpf = cpf;
        this.rendaMensal = rendaMensal;
        this.idade = idade;
        this.profissao = profissao;
    }

    public String getNome() { return nome; }
    public String getEmail() { return email; }
    public String getTelefone() { return telefone; }
    public String getCpf() { return cpf; }
    public Float getRendaMensal() { return rendaMensal; }
    public Integer getIdade() { return idade; }
    public String getProfissao() { return profissao; }
}
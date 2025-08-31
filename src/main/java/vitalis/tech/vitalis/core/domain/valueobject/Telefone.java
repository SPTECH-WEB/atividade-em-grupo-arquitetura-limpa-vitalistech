package vitalis.tech.vitalis.core.domain.valueobject;

public class Telefone {

    private String numero;

    public Telefone(String numero) {
        if (numero.length() != 11) {
            throw new IllegalArgumentException("Formato Invalido");
        }
        this.numero = numero;
    }

    public String getNumero() {
        return numero;
    }
}
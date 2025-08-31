package vitalis.tech.vitalis.core.domain.valueobject;

public class Email {
    private String value;

    public Email(String value) {
        if (value == null || !value.contains("@")) {
            throw new IllegalArgumentException("Email deve conter @");
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
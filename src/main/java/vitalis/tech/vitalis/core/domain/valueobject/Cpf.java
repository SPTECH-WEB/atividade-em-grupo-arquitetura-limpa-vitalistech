package vitalis.tech.vitalis.core.domain.valueobject;

import java.util.regex.Pattern;

public class Cpf {

    private String value;
    private static final Pattern CPF_PATTERN = Pattern.compile("^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$");

    public Cpf(String value) {
        if (value == null || !CPF_PATTERN.matcher(value).matches()) {
            throw new IllegalArgumentException("CPF deve estar no formato XXX.XXX.XXX-XX");
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
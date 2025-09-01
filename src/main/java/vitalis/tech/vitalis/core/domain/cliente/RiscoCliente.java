package vitalis.tech.vitalis.core.domain.cliente;

public enum RiscoCliente {
    ALTO("Alto", 1, "Contato telefônico em até 24h + análise crítica") {
        @Override
        public boolean atenderCriterio(Float rendaMensal, Integer idade) {
            return rendaMensal < 3000f;
        }
    },

    MEDIO("Médio", 2, "Análise manual em até 48h") {
        @Override
        public boolean atenderCriterio(Float rendaMensal, Integer idade) {
            return (rendaMensal <= 6000f) || idade <= 30;
        }
    },
    BAIXO("Baixo", 3, "Contato automático por e-mail") {
        @Override
        public boolean atenderCriterio(Float rendaMensal, Integer idade) {

            return rendaMensal > 6000f && idade > 30;
        }
    };


    private final String descricao;
    private final Integer prioridade;
    private final String estrategiaContato;

    RiscoCliente(String descricao, Integer prioridade, String estrategiaContato) {
        this.descricao = descricao;
        this.prioridade = prioridade;
        this.estrategiaContato = estrategiaContato;
    }

    public abstract boolean atenderCriterio(Float rendaMensal, Integer idade);

    public String getDescricao() {
        return descricao;
    }

    public Integer getPrioridade() {
        return prioridade;
    }

    public String getEstrategiaContato() {
        return estrategiaContato;
    }

    public static RiscoCliente avaliarRisco(Float rendaMensal, Integer idade) {

        for (RiscoCliente risco : values()) {
            if (risco.atenderCriterio(rendaMensal, idade)) {
                return risco;
            }
        }
        return MEDIO;
    }
}
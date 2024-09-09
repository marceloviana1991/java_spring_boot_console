package cronogramas.models;

public enum DiaDaSemana {
    SEGUNDA(1),
    TERCA(2),
    QUARTA(3),
    QUINTA(4),
    SEXTA(5),
    SABADO(6),
    DOMINGO(7);

    private int ordem;
    DiaDaSemana(int ordem) {
        this.ordem = ordem;
    }

}

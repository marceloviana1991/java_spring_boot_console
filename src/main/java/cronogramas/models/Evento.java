package cronogramas.models;

public class Evento {
    private int id;
    private String atividade;
    private DiaDaSemana diaDaSemana;

    public void setDiaDaSemana(DiaDaSemana diaDaSemana) {
        this.diaDaSemana = diaDaSemana;
    }

    public void setAtividade(String atividade) {
        this.atividade = atividade;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "id=" + id +
                ", atividade='" + atividade + '\'' +
                ", diaDaSemana=" + diaDaSemana +
                '}';
    }
}

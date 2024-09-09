package cronogramas.models;

import jakarta.persistence.*;

@Entity
@Table(name = "eventos")
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String atividade;
    @Enumerated(EnumType.STRING)
    private DiaDaSemana diaDaSemana;

    public void setDiaDaSemana(DiaDaSemana diaDaSemana) {
        this.diaDaSemana = diaDaSemana;
    }

    public void setAtividade(String atividade) {
        this.atividade = atividade;
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

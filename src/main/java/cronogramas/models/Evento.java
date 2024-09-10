package cronogramas.models;

import jakarta.persistence.*;

@Entity
@Table(name = "eventos")
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String atividade;
    @Enumerated(EnumType.ORDINAL)
    private DiaDaSemana diaDaSemana;
    @ManyToOne
    private Cronograma cronograma;

    public void setDiaDaSemana(DiaDaSemana diaDaSemana) {
        this.diaDaSemana = diaDaSemana;
    }

    public DiaDaSemana getDiaDaSemana() {
        return diaDaSemana;
    }

    public void setAtividade(String atividade) {
        this.atividade = atividade;
    }

    public void setCronograma(Cronograma cronograma) {
        this.cronograma = cronograma;
    }

    public Cronograma getCronograma() {
        return cronograma;
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

package cronogramas.models;

import jakarta.persistence.*;

@Entity
@Table(name = "avaliacoes")
public class Avaliacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double nota;
    private String texto;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Evento evento;

    public void setNota(double nota) {
        this.nota = nota;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    @Override
    public String toString() {
        return "Avaliacao{" +
                "id=" + id +
                ", nota=" + nota +
                ", texto='" + texto + '\'' +
                ", idEvento=" + evento.getId() +
                '}';
    }
}

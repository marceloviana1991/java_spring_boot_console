package cronogramas.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cronogramas")
public class Cronograma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String titulo;
    @OneToMany(mappedBy = "cronograma", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Evento> eventos = new ArrayList<>();

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Long getId() {
        return id;
    }

    public void addEvento(Evento evento) {
        this.eventos.add(evento);
        evento.setCronograma(this);
    }

    @Override
    public String toString() {
        return "Cronograma{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                '}';
    }
}

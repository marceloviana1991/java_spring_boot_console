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
    @OneToMany(mappedBy = "cronograma")
    private List<Evento> eventos = new ArrayList<>();

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Evento> getEventos() {
        return eventos;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Cronograma{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                '}';
    }
}

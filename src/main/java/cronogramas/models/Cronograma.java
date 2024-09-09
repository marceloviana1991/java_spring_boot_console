package cronogramas.models;

public class Cronograma {
    private int id;
    private String titulo;

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Cronograma{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                '}';
    }
}

package cronogramas.repository;

import cronogramas.models.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventoRepository extends JpaRepository<Evento, Long> {

    public List<Evento> findByCronogramaIdOrderByDiaDaSemana(Long id);
}

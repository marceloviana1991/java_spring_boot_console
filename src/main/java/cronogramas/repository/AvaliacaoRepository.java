package cronogramas.repository;

import cronogramas.models.Avaliacao;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long> {
    public List<Avaliacao> findByEventoIdOrderByIdDesc(Long id, Pageable pageable);
}

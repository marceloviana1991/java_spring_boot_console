package cronogramas.principal;

import cronogramas.models.Avaliacao;
import cronogramas.models.Cronograma;
import cronogramas.models.DiaDaSemana;
import cronogramas.models.Evento;
import cronogramas.repository.AvaliacaoRepository;
import cronogramas.repository.CronogramaRepository;
import cronogramas.repository.EventoRepository;
import org.springframework.data.domain.Pageable;

import java.util.*;

public class Principal {
    private CronogramaRepository cronogramaRepository;
    private EventoRepository eventoRepository;
    private AvaliacaoRepository avaliacaoRepository;
    private Scanner leitura = new Scanner(System.in);

    public Principal(CronogramaRepository cronogramaRepository, EventoRepository eventoRepository,
                     AvaliacaoRepository avaliacaoRepository) {
        this.cronogramaRepository = cronogramaRepository;
        this.eventoRepository = eventoRepository;
        this.avaliacaoRepository = avaliacaoRepository;
    }

    public void insertCronogramaConsole(String tituloCronograma) {
        Cronograma cronograma = new Cronograma();
        cronograma.setTitulo(tituloCronograma);
        cronogramaRepository.save(cronograma);
    }

    public void insertEventoConsole(String atividadeEvento,
                                    DiaDaSemana diaDaSemanaEvento, Long idCronograma) {
        Evento evento = new Evento();
        evento.setAtividade(atividadeEvento);
        evento.setDiaDaSemana(diaDaSemanaEvento);
        Optional<Cronograma> cronograma = cronogramaRepository.findById(idCronograma);
        evento.setCronograma(cronograma.get());
        eventoRepository.save(evento);
    }

    public void insertAvaliacaoConsole(double notaAvaliacao, String textoAvaliacao,
                                       Long idEvento) {
        Avaliacao avaliacao = new Avaliacao();
        avaliacao.setNota(notaAvaliacao);
        avaliacao.setTexto(textoAvaliacao);
        Optional<Evento> evento = eventoRepository.findById(idEvento);
        avaliacao.setEvento(evento.get());
        avaliacaoRepository.save(avaliacao);
    }

    public List<Cronograma> selectCronogramasConsole() {
        return cronogramaRepository.findAll();
    }

    public List<Evento> selectEventosConsole() {
        return eventoRepository.findAll();
    }

    public List<Evento> selectEventosCronogramaConsole(Long idCronograma) {
        return eventoRepository.findByCronogramaIdOrderByDiaDaSemana(idCronograma);
    }

    public List<Avaliacao> selectAvaliacoesEventoConsole(Long idEvento, Pageable pageable) {
        return avaliacaoRepository.findByEventoIdOrderByIdDesc(idEvento, pageable);
    }
}

package cronogramas.principal;

import cronogramas.models.Cronograma;
import cronogramas.models.DiaDaSemana;
import cronogramas.models.Evento;
import cronogramas.repository.CronogramaRepository;
import cronogramas.repository.EventoRepository;

import java.util.List;
import java.util.Scanner;

public class Principal {
    private CronogramaRepository cronogramaRepository;
    private EventoRepository eventoRepository;
    private Scanner leitura = new Scanner(System.in);

    public Principal(CronogramaRepository cronogramaRepository, EventoRepository eventoRepository) {
        this.cronogramaRepository = cronogramaRepository;
        this.eventoRepository = eventoRepository;
    }

    public void insertCronogramaConsole(String tituloCronograma) {
        Cronograma cronograma = new Cronograma();
        cronograma.setTitulo(tituloCronograma);
        cronogramaRepository.save(cronograma);
    }

    public void insertEventoConsole(String atividadeEvento, DiaDaSemana diaDaSemanaEvento) {
        Evento evento = new Evento();
        evento.setAtividade(atividadeEvento);
        evento.setDiaDaSemana(diaDaSemanaEvento);
        eventoRepository.save(evento);
    }

    public List<Cronograma> selectCronogramasConsole() {
        return cronogramaRepository.findAll();
    }

    public List<Evento> selectEventosConsole() {
        return eventoRepository.findAll();
    }


}

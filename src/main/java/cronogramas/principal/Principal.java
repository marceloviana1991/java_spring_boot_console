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

    public void insertConsole() {
        String tituloCronograma = "titulo do cronograma";

        String atividadeEvento = "escreve atividade";
        DiaDaSemana diaDaSemanaEvento = DiaDaSemana.SEGUNDA;

        Cronograma cronograma = new Cronograma();
        cronograma.setTitulo(tituloCronograma);
        cronogramaRepository.save(cronograma);
        Evento evento = new Evento();
        evento.setAtividade(atividadeEvento);
        evento.setDiaDaSemana(diaDaSemanaEvento);
        eventoRepository.save(evento);
    }

    public void selectConsole() {
        List<Cronograma> cronogramas = cronogramaRepository.findAll();
        List<Evento> eventos = eventoRepository.findAll();
        cronogramas.forEach(System.out::println);
        eventos.forEach(System.out::println);
    }


}

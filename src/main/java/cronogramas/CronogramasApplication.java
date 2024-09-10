package cronogramas;

import cronogramas.models.Cronograma;
import cronogramas.models.DiaDaSemana;
import cronogramas.models.Evento;
import cronogramas.principal.Principal;
import cronogramas.repository.CronogramaRepository;
import cronogramas.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;
import java.util.List;

@SpringBootApplication
public class CronogramasApplication implements CommandLineRunner {
	@Autowired
	private CronogramaRepository cronogramaRepository;
	@Autowired
	private EventoRepository eventoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CronogramasApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(
				cronogramaRepository,
				eventoRepository
		);

//		principal.insertCronogramaConsole("Titulo do cronograma");
//		principal.insertEventoConsole("descreve atividade de evento", DiaDaSemana.QUARTA, 1L);



		List<Cronograma> cronogramas = principal.selectCronogramasConsole();
		cronogramas.forEach(System.out::println);
		List<Evento> eventos = principal.selectEventosConsole();
		eventos.forEach(System.out::println);
		System.out.println();

		List<Evento> eventosCronograma = principal.selectEventosCronogramaConsole(1L);
		Collections.sort(eventosCronograma);
		eventosCronograma.forEach(System.out::println);
	}
}

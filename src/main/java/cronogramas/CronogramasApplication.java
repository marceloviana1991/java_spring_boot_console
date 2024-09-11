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

//		principal.insertCronogramaConsole("Titulo do outro cronograma");
//		principal.insertEventoConsole("descreve atividade de evento do outro cronograma",
//				DiaDaSemana.SABADO, 1L);



		System.out.println("select * from cronogramas");
		List<Cronograma> cronogramas = principal.selectCronogramasConsole();
		cronogramas.forEach(System.out::println);
		System.out.println();
		System.out.println("select * from eventos");
		List<Evento> eventos = principal.selectEventosConsole();
		eventos.forEach(System.out::println);
		System.out.println();
		System.out.println("select * from eventos where id_cronograma=1 order by dia_da_semana");
		List<Evento> eventosCronograma = principal.selectEventosCronogramaConsole(2L);
		eventosCronograma.forEach(System.out::println);
	}
}

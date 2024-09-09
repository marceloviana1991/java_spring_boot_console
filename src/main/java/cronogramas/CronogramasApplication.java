package cronogramas;

import cronogramas.principal.Principal;
import cronogramas.repository.CronogramaRepository;
import cronogramas.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
		principal.selectConsole();
	}
}

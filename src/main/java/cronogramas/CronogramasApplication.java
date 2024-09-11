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

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

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

		int menu;
		Scanner leitura = new Scanner(System.in);

		do{
			System.out.println("""
					1 - Cadastrar cronograma
					2 - Cadastrar evento
					3 - Listar todos cronogramas
					4 - Listar todos eventos
					5 - Listar eventos de um cronograma
					0 - Sair
					""");
			try {
				menu = Integer.parseInt(leitura.nextLine());
			} catch (InputMismatchException inputMismatchException) {
				System.out.println("...");
				System.out.println("ERRO DE DIGITAÇÃO");
				menu = 100;
			}
			switch (menu){
				case 1:
					System.out.println("Informe o título do cronograma:");
					String tituloCronograma = leitura.nextLine();
					principal.insertCronogramaConsole(tituloCronograma);
					break;
				case 2:
					System.out.println("Informe o nome da atividade do evento:");
					String atividadeEvento = leitura.nextLine();
					int numeroDiaDaSemana;
					DiaDaSemana diaDaSemana = null;
					do {
						System.out.println("""
								Digite um número para escolher o dia será realizado esse evento:
								1 - SEGUNDA
								2 - TERÇA
								3 - QUARTA
								4 - QUINTA
								5 - SEXTA
								6 - SÁBADO
								7 - DOMINGO
								""");
						numeroDiaDaSemana = Integer.parseInt(leitura.nextLine());
						switch (numeroDiaDaSemana) {
							case 1:
								diaDaSemana = DiaDaSemana.SEGUNDA;
								break;
							case 2:
								diaDaSemana = DiaDaSemana.TERCA;
								break;
							case 3:
								diaDaSemana = DiaDaSemana.QUARTA;
								break;
							case 4:
								diaDaSemana = DiaDaSemana.QUINTA;
								break;
							case 5:
								diaDaSemana = DiaDaSemana.SEXTA;
								break;
							case 6:
								diaDaSemana = DiaDaSemana.SABADO;
								break;
							case 7:
								diaDaSemana = DiaDaSemana.DOMINGO;
								break;
							default:
								System.out.println("Número inválido!");
								numeroDiaDaSemana = 0;
						}
					} while (numeroDiaDaSemana == 0);
					System.out.println("Informe o Id do cronograma que vai receber esse evento:");
					long idCronogramaEvento = Long.parseLong(leitura.nextLine());
					principal.insertEventoConsole(atividadeEvento,diaDaSemana,idCronogramaEvento);
					break;
				case 3:
					List<Cronograma> cronogramas = principal.selectCronogramasConsole();
					cronogramas.forEach(System.out::println);
					System.out.println();
					break;
				case 4:
					List<Evento> eventos = principal.selectEventosConsole();
					eventos.forEach(System.out::println);
					System.out.println();
					break;
				case 5:
					System.out.println("Informe o Id do cronograma:");
					long idCronogramaEventos = Long.parseLong(leitura.nextLine());
					List<Evento> eventosCronograma = principal.selectEventosCronogramaConsole(idCronogramaEventos);
					eventosCronograma.forEach(System.out::println);

			}
		} while (menu != 0);

	}
}

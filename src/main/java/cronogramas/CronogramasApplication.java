package cronogramas;


import cronogramas.principal.*;
import cronogramas.repository.AvaliacaoRepository;
import cronogramas.repository.CronogramaRepository;
import cronogramas.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.InputMismatchException;
import java.util.Scanner;

@SpringBootApplication
public class CronogramasApplication implements CommandLineRunner {
	@Autowired
	private CronogramaRepository cronogramaRepository;
	@Autowired
	private EventoRepository eventoRepository;
	@Autowired
	private AvaliacaoRepository avaliacaoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CronogramasApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(
				cronogramaRepository,
				eventoRepository,
				avaliacaoRepository
		);

		int menu;
		Scanner leitura = new Scanner(System.in);
		principal.insertAvaliacaoConsole(8.8,"uma bosta", 1L);

		do{
			System.out.println("""
					1 - Cadastrar cronograma
					2 - Cadastrar evento de cronograma
					3 - Cadastrar avaliacao de evento
					4 - Listar todos cronogramas
					5 - Listar todos eventos
					6 - Listar eventos de um cronograma
					7 - Listar avaliações de um evento
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
					CadastrarCronograma.cadastrarCronograma(principal);
					break;
				case 2:
					CadastrarEvento.cadastrarEvento(principal);
					break;
				case 3:
					CadastrarAvaliacao.cadastrarAvaliacao(principal);
					break;
				case 4:
					ListarCronogramas.listarCronogramas(principal);
					break;
				case 5:
					ListarEventos.listarEventos(principal);
					break;
				case 6:
					ListarEventosDeCronograma.lisarEventosDeCronograma(principal);
					break;
				case 7:
					ListarAvaliacoesDeEvento.listarvaliacoesDeEvento(principal);
			}
		} while (menu != 0);

	}
}

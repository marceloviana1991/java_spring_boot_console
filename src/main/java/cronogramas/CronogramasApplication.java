package cronogramas;


import cronogramas.principal.*;
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
					CadastrarCronograma.cadastrarCronograma(principal);
					break;
				case 2:
					CadastrarEvento.cadastrarEvento(principal);
					break;
				case 3:
					ListarCronogramas.listarCronogramas(principal);
					break;
				case 4:
					ListarEventos.listarEventos(principal);
					break;
				case 5:
					ListarEventosDeCronograma.lisarEventosDeCronograma(principal);
			}
		} while (menu != 0);

	}
}

package cronogramas.principal;

import cronogramas.models.Evento;

import java.util.List;
import java.util.Scanner;

public class ListarEventosDeCronograma {
    public static void lisarEventosDeCronograma(Principal principal) {
        Scanner leitura = new Scanner(System.in);
        System.out.println("Informe o Id do cronograma:");
        long idCronogramaEventos = Long.parseLong(leitura.nextLine());
        List<Evento> eventosCronograma = principal.selectEventosCronogramaConsole(idCronogramaEventos);
        eventosCronograma.forEach(System.out::println);
    }
}

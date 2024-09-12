package cronogramas.principal;

import cronogramas.models.Avaliacao;

import java.util.List;
import java.util.Scanner;

public class ListarAvaliacoesDeEvento {
    public static void listarvaliacoesDeEvento(Principal principal) {
        Scanner leitura = new Scanner(System.in);
        System.out.println("Informe o Id do evento:");
        long idEventoAvaliacoes = Long.parseLong(leitura.nextLine());
        List<Avaliacao> avaliacoesEvento = principal.selectAvaliacoesEventoConsole(idEventoAvaliacoes);
        avaliacoesEvento.forEach(System.out::println);
    }
}

package cronogramas.principal;

import cronogramas.models.Avaliacao;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Scanner;

public class ListarAvaliacoesDeEvento {
    public static void listarvaliacoesDeEvento(Principal principal) {
        Scanner leitura = new Scanner(System.in);
        System.out.println("Informe o Id do evento:");
        long idEventoAvaliacoes = Long.parseLong(leitura.nextLine());
        System.out.println("Informe um valor para limit:");
        int limit = Integer.parseInt(leitura.nextLine());
        System.out.println("Informe um valor para offset:");
        int offset = Integer.parseInt(leitura.nextLine());
        List<Avaliacao> avaliacoesEvento = principal.selectAvaliacoesEventoConsole(idEventoAvaliacoes,
                PageRequest.of(offset, limit));
        avaliacoesEvento.forEach(System.out::println);
    }
}

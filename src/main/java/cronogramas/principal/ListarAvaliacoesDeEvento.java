package cronogramas.principal;

import cronogramas.models.Avaliacao;
import java.util.Collections;

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
        List<Avaliacao> avaliacoesEvento = principal.selectAvaliacoesEventoConsole(idEventoAvaliacoes);
        Collections.reverse(avaliacoesEvento);
        for (int i = offset; i < (limit + offset); i++){
            System.out.println(avaliacoesEvento.get(i));
        }
    }
}

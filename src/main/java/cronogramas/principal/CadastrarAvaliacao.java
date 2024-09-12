package cronogramas.principal;

import java.util.Scanner;

public class CadastrarAvaliacao {

    public static void cadastrarAvaliacao(Principal principal){
        Scanner leitura = new Scanner(System.in);
        System.out.println("Informe a nota da avaliação:");
        double notaAvaliacao = Double.parseDouble(leitura.nextLine());
        System.out.println("Informe o texto da avaliação:");
        String textoAvaliacao = leitura.nextLine();
        System.out.println("Informe o Id do evento que vai receber essa avaliação:");
        long idEventoAvaliacao = Long.parseLong(leitura.nextLine());
        principal.insertAvaliacaoConsole(notaAvaliacao, textoAvaliacao, idEventoAvaliacao);

    }
}

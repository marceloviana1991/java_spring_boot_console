package cronogramas.principal;

import java.util.Scanner;

public class CadastrarCronograma {

    public static void cadastrarCronograma(Principal principal) {
        Scanner leitura = new Scanner(System.in);
        System.out.println("Informe o título do cronograma:");
        String tituloCronograma = leitura.nextLine();
        principal.insertCronogramaConsole(tituloCronograma);
    }
}

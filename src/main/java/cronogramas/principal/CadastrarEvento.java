package cronogramas.principal;

import cronogramas.models.DiaDaSemana;

import java.util.Scanner;

public class CadastrarEvento {

    public static void cadastrarEvento(Principal principal) {
        Scanner leitura = new Scanner(System.in);
        System.out.println("Informe o nome da atividade do evento:");
        String atividadeEvento = leitura.nextLine();
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
        int numeroDiaDaSemana = Integer.parseInt(leitura.nextLine());
        DiaDaSemana diaDaSemana = DiaDaSemana.fromString(numeroDiaDaSemana);
        System.out.println("Informe o Id do cronograma que vai receber esse evento:");
        long idCronogramaEvento = Long.parseLong(leitura.nextLine());
        principal.insertEventoConsole(atividadeEvento,diaDaSemana,idCronogramaEvento);
    }
}

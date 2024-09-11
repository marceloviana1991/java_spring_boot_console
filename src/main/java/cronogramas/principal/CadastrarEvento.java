package cronogramas.principal;

import cronogramas.models.DiaDaSemana;

import java.util.Scanner;

public class CadastrarEvento {

    public static void cadastrarEvento(Principal principal) {
        Scanner leitura = new Scanner(System.in);
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
    }
}

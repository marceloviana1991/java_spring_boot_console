package cronogramas.principal;

import cronogramas.models.Cronograma;
import cronogramas.models.DiaDaSemana;
import cronogramas.models.Evento;

import java.util.Scanner;

public class Principal {
    private Scanner leitura = new Scanner(System.in);

    public void executaConsole() {
        Cronograma cronograma = new Cronograma();
        cronograma.setId(1);
        cronograma.setTitulo("titulo do cronograma");
        System.out.println(cronograma);
        Evento evento = new Evento();
        evento.setId(1);
        evento.setAtividade("descreve atividade");
        evento.setDiaDaSemana(DiaDaSemana.SEGUNDA);
        System.out.println(evento);
    }
}

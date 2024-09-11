package cronogramas.principal;

import cronogramas.models.Evento;

import java.util.List;

public class ListarEventos {
    public static void listarEventos(Principal principal) {
        List<Evento> eventos = principal.selectEventosConsole();
        eventos.forEach(System.out::println);
        System.out.println();
    }
}

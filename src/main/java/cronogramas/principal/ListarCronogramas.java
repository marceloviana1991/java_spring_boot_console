package cronogramas.principal;

import cronogramas.models.Cronograma;

import java.util.List;

public class ListarCronogramas {
    public static void listarCronogramas(Principal principal) {
        List<Cronograma> cronogramas = principal.selectCronogramasConsole();
        cronogramas.forEach(System.out::println);
        System.out.println();
    }
}

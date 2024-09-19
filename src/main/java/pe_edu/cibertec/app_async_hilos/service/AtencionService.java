package pe_edu.cibertec.app_async_hilos.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe_edu.cibertec.app_async_hilos.remote.service.PreparacionService;

import java.util.concurrent.CompletableFuture;

@RequiredArgsConstructor
@Service

public class AtencionService {
    private final PreparacionService preparacionService;

    public CompletableFuture<String> prepararHamburguesa() {
        CompletableFuture<String> tarea1 = preparacionService.cortarPan();
        CompletableFuture<String> tarea2 = preparacionService.freirHamburguesa();
        CompletableFuture<String> tarea3 = preparacionService.freirPapas();
        CompletableFuture<String> tarea4 = preparacionService.empaquetarHamburguesa();
        //allof = espera a que todas las tareas se completen
        return CompletableFuture.allOf(tarea1, tarea2, tarea3, tarea4)
                .thenApply(result -> {
                    //Unir los resultados de las tareas
                    try {
                        String valorTraea1 = tarea1.join();
                        String valorTraea2 = tarea2.join();
                        String valorTraea3 = tarea3.join();
                        String valorTraea4 = tarea4.join();
                        return "Resultado de Tareas: " +
                                valorTraea1 + " - " +
                                valorTraea2 + " - " +
                                valorTraea3 + " - " +
                                valorTraea4;
                    } catch (Exception ex) {
                        return "Error en la ejecucion de las tareas" + ex.getMessage();

                    }
                })
                .exceptionally(ex -> "Error en la ejecucion de las tareas" + ex.getMessage());
    }

}
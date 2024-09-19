package pe_edu.cibertec.app_async_hilos.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pe_edu.cibertec.app_async_hilos.service.AtencionService;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RequiredArgsConstructor
@RestController

public class AtencionController {
    private final AtencionService atencionService;
    @GetMapping("/atender-hamburguesa")
    public String atenderHamburguesa()

            throws ExecutionException, InterruptedException
    {
           //Iniciar el proceso de preparación
            CompletableFuture<String> resultado =
                    atencionService.prepararHamburguesa();
            //esperar a que el proceso termine
            return resultado.get();

        }
    }



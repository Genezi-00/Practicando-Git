package pe_edu.cibertec.app_async_hilos.remote.service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class PreparacionService {
    @Async
    public CompletableFuture<String> cortarPan() {
        try {
            log.info("Cortando pan para la hamburguesa");
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        return CompletableFuture.completedFuture("Pan cortado, terminado");
    }

    @Async
    public CompletableFuture<String> freirHamburguesa() {
        try {
            log.info("Freir Hamburguesa");
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        return CompletableFuture.completedFuture("Hamburguesa frita, terminada");
    }

    @Async
    public CompletableFuture<String> freirPapas() {
        try {
            log.info("Empezando a freir las papas");
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        return CompletableFuture.completedFuture("Papas fritas, terminada");
    }

    @Async
    public CompletableFuture<String> empaquetarHamburguesa() {
        try {
            log.info("Empezando empaquetado");
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        return CompletableFuture.completedFuture("Empaquetado, terminado");

    }
}




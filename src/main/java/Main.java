import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import modelo.TipoAbono;
import modelo.Viaje;
import modelo.Viajero;
import repositorio.ViajeRepository;
import repositorio.ViajeroRepository;
import utilidades.JpaUtil;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Main {

    static void main() {

        IO.println("Arrancando app Servicio Municipal de Transportes");


        ViajeroRepository viajeroRepository = new ViajeroRepository();
        ViajeRepository viajeRepo = new ViajeRepository();

        /*
        viajeroRepository.save(new Viajero(null, "58589874A", "Manolo Lama",
                56, "Antas", TipoAbono.ANUAL, 150, null));

        viajeroRepository.save(new Viajero(null, "65412987C", "Marta Prendes",
                38, "Vera", TipoAbono.MENSUAL, 110, null));


        Viajero v1 = viajeroRepository.findById(1L).orElse(null);
        v1.setSaldoPuntos(200);
        viajeroRepository.update(v1);


        Viajero v1 = viajeroRepository.findById(1L).orElse(null);
        Viajero v2 = viajeroRepository.findById(2L).orElse(null);

        ViajeRepository viajeRepo = new ViajeRepository();

        viajeRepo.save(new Viaje(null, "Línea 1", "Antas", "Vera",
                LocalDate.now(), LocalTime.now(), 45, 2.5, false, v1));
        viajeRepo.save(new Viaje(null, "Línea 1", "Vera", "Antas",
                LocalDate.now(), LocalTime.now().plusHours(2), 47, 2.5,
                false, v1));

        viajeRepo.save(new Viaje(null, "Línea 2", "Mojácar", "Garrucha",
                LocalDate.now(), LocalTime.now(), 10, 1.5, false, v2));
        viajeRepo.save(new Viaje(null, "Línea 2", "Garrucha", "Mojácar",
                LocalDate.now(), LocalTime.now().plusHours(1), 13, 1.5,
                true, v2));
        */

        viajeRepo.findAll().stream()
                .collect(Collectors.groupingBy(Viaje::getLineaTransporte,
                        Collectors.counting()))
                .forEach((k,v) -> IO.println(k + ": " + v));

        viajeRepo.findWitchIncidencia().forEach(System.out::println);

        viajeroRepository.findViajesByViajeroIdAndPrecioGreaterThan(1L, 1.5).forEach(System.out::println);



    }
}

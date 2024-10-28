package org.example.parcial1.Controllers;


import org.example.parcial1.DTO.StatsResponse;
import org.example.parcial1.Services.StatsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stats")
public class StatsController {

    // Inyección de dependencia del servicio StatsService a través del constructor.
    private final StatsService statsServices;

    // Constructor que recibe una instancia de StatsService y la asigna a la variable de instancia.
    public StatsController(StatsService statsServices) {
        this.statsServices = statsServices;
    }

    // Método que maneja las solicitudes GET a la URL "/stats".
    @GetMapping
    public StatsResponse getStats() {
        // Llama al servicio para obtener las estadísticas y devuelve la respuesta.
        return statsServices.getStats();
    }
}

package org.example.parcial1.Controllers;


import org.example.parcial1.DTO.StatsResponse;
import org.example.parcial1.Services.StatsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stats")
public class StatsController {

    private final StatsService statsServices;

    public StatsController(StatsService statsServices) {
        this.statsServices = statsServices;
    }

    @GetMapping
    public StatsResponse getStats() {
        return statsServices.getStats();
    }
}

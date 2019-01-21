package cl.forge.programatufuturo.reservadehoras.controllers;


import cl.forge.programatufuturo.reservadehoras.models.Hora;
import cl.forge.programatufuturo.reservadehoras.services.HoraService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.List;

@RestController
//Request Mapping
@RequestMapping("/horas")
public class HoraController {
    private HoraService horaService;

    public HoraController(HoraService horaService) {
        this.horaService = horaService;
    }

    @GetMapping("/mostrarhoras")
    public List<Hora> listarHorasTipo(@RequestParam String tipoHora){
        return horaService.buscarHorasPorTipo(tipoHora);
    }

    @GetMapping("/buscarhorasfecha")
    public List<Hora> buscarHorasPorFecha(@RequestParam Date fecha){
        List<Hora> horas=horaService.buscarHorasporFecha(fecha);
        return horas;
    }

    @GetMapping("/buscarporhoras")
    public List<Hora> buscarPorHora(@RequestParam Date hora){
        List<Hora> horas=horaService.buscarPorHoras(hora);
        return horas;
    }
}

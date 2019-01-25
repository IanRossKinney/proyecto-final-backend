package cl.forge.programatufuturo.reservadehoras.controllers;


import cl.forge.programatufuturo.reservadehoras.models.Empleado;
import cl.forge.programatufuturo.reservadehoras.models.Hora;
import cl.forge.programatufuturo.reservadehoras.services.HoraService;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@RestController
//Request Mapping
@RequestMapping("/horas")
@CrossOrigin(origins = "*")
public class HoraController {
    private HoraService horaService;

    public HoraController(HoraService horaService) {
        this.horaService = horaService;
    }

    //Listar Horas por tipo
    @GetMapping("/listarhorasventa")
    public List<Hora> listarHorasVenta(){
        List<Hora> horasVenta=new ArrayList<>();
        for(int i=0;i<horaService.listarHoras().size();i++){
            if(horaService.listarHoras().get(i).getTipoHora().equals("venta")){
                horasVenta.add(horaService.listarHoras().get(i));
            }
        }
        return horasVenta;
    }
    //Listar Horas por tipo
    @GetMapping("/listarhoraspostventa")
    public List<Hora> listarHorasPostVenta(){
        List<Hora> horasPostVenta=new ArrayList<>();
        for(int i=0;i<horaService.listarHoras().size();i++){
            if(horaService.listarHoras().get(i).getTipoHora().equals("post-venta")){
                horasPostVenta.add(horaService.listarHoras().get(i));
            }
        }
        return horasPostVenta;
    }

    //Listar horas de un vendedor
    @GetMapping("/listarhorasvendedor")
    public List<Hora> listarHorasVendedor(@RequestBody Empleado empleado){
        List<Hora> horas=new ArrayList<>();
        List<Hora> hrs=horaService.listarHoras();
        for (int i = 0; i <hrs.size() ; i++) {
            if(horaService.listarHoras().get(i).getRutEmpleado().getRutEmpleado().equals(empleado.getRutEmpleado())){
                horas.add(horaService.listarHoras().get(i));
            }
        }
        return horas;
    }

    //Obtener hora por ID
    @PostMapping("/gethora")
    public Hora obtenerHoraPorId(@RequestBody Hora hora){
        return horaService.buscarHoraPorId(hora.getIdHora());
    }

    //Guardar una hora
    @PostMapping("/guardarhora")
    public boolean guardarHora(@RequestBody Hora hora){
        return horaService.guardarHora(hora);
    }

}

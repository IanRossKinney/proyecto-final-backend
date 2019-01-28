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
    @PostMapping("/listarhorasvendedor")
    public List<Hora> listarHorasVendedor(@RequestBody Empleado empleado){
        Empleado emp=new Empleado(empleado.getRutEmpleado());
        List<Hora> horas=new ArrayList<>();

        for (int i = 0; i <horaService.listarHoras().size(); i++) {
            if(horaService.listarHoras().get(i).getRutEmpleado().getRutEmpleado().equals(emp.getRutEmpleado())){
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

    //Match para la hora de cliente
    @PostMapping("/matchhora")
    public List<Hora> consultar(@RequestBody Hora hora){
        System.out.println(hora);
        String newFecha="";
        String fechaJson=hora.getFecha();
        for(int i=0;i<10;i++){
            newFecha+=fechaJson.charAt(i);
        }
        hora.setFecha(newFecha);


        if (horaService.obtenerBloquePorFechaHoraTipo(hora.getFecha(),hora.getHora(),hora.getTipoHora())!=null){
            System.out.println("entontro esa");
            List<Hora> hr=new ArrayList<>();
            hr.add(horaService.obtenerBloquePorFechaHoraTipo(hora.getFecha(),hora.getHora(),hora.getTipoHora()));
            return hr;
        }else if(horaService.obtenerBloquePorFechaYTipo(hora.getFecha(),hora.getTipoHora())!=null){
            System.out.println("no encontro la hora");
            List<Hora> hrs=new ArrayList<>();
            hrs.add(horaService.obtenerBloquePorFechaYTipo(hora.getFecha(),hora.getTipoHora()));
            return hrs;
        }else{
            System.out.println("todo malo");
            return null;
        }
    }





    //Guardar una hora
    @PostMapping("/guardarhora")
    public boolean guardarHora(@RequestBody Hora hora){
        return horaService.guardarHora(hora);
    }

    //Confirmacion telefonica
    @PostMapping("/confirmaciontelefonica")
    public boolean confTelefonica(@RequestBody Hora hora){
        Hora hr=horaService.buscarHoraPorId(hora.getIdHora());
        hr.setEstado("Conf/Telefonica");
        horaService.modificarEstado(hr);
        return true;
    }

    //Confirmacion de asistencia
    @PostMapping("/confirmacionasistencia")
    public boolean confAsistencia(@RequestBody Hora hora){
        Hora hr=horaService.buscarHoraPorId(hora.getIdHora());
        hr.setEstado("Cliente presente");
        horaService.modificarEstado(hr);
        return true;
    }

    //Confirmacion
    @PostMapping("/clientenoasiste")
    public boolean confInasistencia(@RequestBody Hora hora){
        Hora hr=horaService.buscarHoraPorId(hora.getIdHora());
        hr.setEstado("Cliente ausente");
        horaService.modificarEstado(hr);
        return true;
    }

    //Asignar cliente a hora
    @PostMapping("/reservar")
    public boolean reservarHora(@RequestBody Hora hora){
        Hora hr=horaService.buscarHoraPorId(hora.getIdHora());
        hr.setRutCliente(hora.getRutCliente());
        horaService.reservaCliente(hr);
        return true;
    }

}

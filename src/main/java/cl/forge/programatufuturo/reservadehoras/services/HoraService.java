package cl.forge.programatufuturo.reservadehoras.services;

import cl.forge.programatufuturo.reservadehoras.models.Empleado;
import cl.forge.programatufuturo.reservadehoras.models.Hora;
import cl.forge.programatufuturo.reservadehoras.respositorys.HoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class HoraService {

    private HoraRepository horaRepository;

    @Autowired
    public HoraService(HoraRepository horaRepository){
        this.horaRepository=horaRepository;
    }



    //Guardar hora
    public boolean guardarHora(Hora hora){
        hora.setFecha(hora.modificarFecha(hora.getFecha()));
        String idUnico=hora.crearID();
        Empleado empleado=new Empleado(hora.getRutEmpleado().getRutEmpleado());
        if(horaRepository.existsByFecha(hora.getFecha())){
            if(horaRepository.existsByHora(hora.getHora())){
                Hora testHora=horaRepository.findByFechaAndHora(hora.getFecha(),hora.getHora());
                if(hora.getTipoHora().equals(testHora.getTipoHora())){
                    System.out.println("Bloque de hora ya asignado");
                    return false;
                }else{
                    Hora nuevaHora=new Hora(idUnico,hora.getTipoHora(),hora.getFecha(),hora.getHora(),empleado);
                    horaRepository.save(nuevaHora);
                    System.out.println("Bloque horario designado correctamente");
                    return true;
                }
            }else{
                Hora nuevaHora=new Hora(idUnico,hora.getTipoHora(),hora.getFecha(),hora.getHora(),empleado);
                horaRepository.save(nuevaHora);
                System.out.println("Bloque horario designado correctamente");
                return true;
            }
        }else {
            Hora nuevaHora=new Hora(idUnico,hora.getTipoHora(),hora.getFecha(),hora.getHora(),empleado);
            horaRepository.save(nuevaHora);
            System.out.println("Bloque horario designado correctamente");
            return true;
        }
    }

    //listar horas
    public List<Hora> listarHoras(){
        List<Hora> horas=new ArrayList<>();
        horaRepository.findAll().forEach(Hora -> horas.add(Hora));
        return horas;
    }
    
    //Obtener hora por id
    public Hora buscarHoraPorId(String idHora){
        return horaRepository.findByIdHora(idHora);
    }

    //Modificar estado por telefono
    public void modificarEstado(Hora hora){
        horaRepository.save(hora);
    }


    //Hora por fecha, hora y tippo
    public Hora obtenerBloquePorFechaHoraTipo(String fecha, String hora,String tipoHora){
        return horaRepository.findByFechaAndHoraAndTipoHora(fecha, hora,tipoHora);
    }
    public Hora obtenerBloquePorFechaYTipo(String fecha, String tipo){
        return horaRepository.findByFechaAndTipoHora(fecha, tipo);
    }


    //Reserva de cliente
    public void reservaCliente(Hora hora){
        horaRepository.save(hora);
    }




}

package cl.forge.programatufuturo.reservadehoras.services;

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
    //Validador hora disponible
    public boolean guardarHora(Hora hora){
        if(horaRepository.existsTipoHora(hora.getTipoHora())&&horaRepository.existsFecha(hora.getFecha())){
            if(horaRepository.existsHora(hora.getHora())){
                System.out.println("Hora de bloque ya en uso");
                return false;
            }else {
                Hora horita=new Hora(hora.getTipoHora(),hora.getFecha(),hora.getHora(),hora.getRutEmpleado());
                horaRepository.save(horita);
                System.out.println("Hora almacenada correctamente");
                return true;
            }
        }else if(horaRepository.existsTipoHora(hora.getTipoHora()) && (horaRepository.existsFecha(hora.getFecha())==false)){
            Hora horita=new Hora(hora.getTipoHora(),hora.getFecha(),hora.getHora(),hora.getRutEmpleado());
            System.out.println("Hasta aqui bien");
            horaRepository.save(horita);
            System.out.println("Hora almacenada correctamente");
            return true;
        }else{
            System.out.println("La hora ya se encuenta asignada");
            return false;
        }
    }

    //listar horas
    public List<Hora> listarHoras(){
        List<Hora> horas=new ArrayList<>();
        horaRepository.findAll().forEach(Hora -> horas.add(Hora));
        return horas;
    }

    //Listar hora por id
    public Hora buscarHoraPorId(Integer idHora){
        return horaRepository.findByIdHora(idHora);
    }

}

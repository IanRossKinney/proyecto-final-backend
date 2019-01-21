package cl.forge.programatufuturo.reservadehoras.services;

import cl.forge.programatufuturo.reservadehoras.models.Hora;
import cl.forge.programatufuturo.reservadehoras.respositorys.HoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.sql.Date;
import java.util.List;

@Service
public class HoraService {

    private HoraRepository horaRepository;

    @Autowired
    public HoraService(HoraRepository horaRepository){
        this.horaRepository=horaRepository;
    }

    public List<Hora> buscarHorasPorTipo(String tipoHora){
        return horaRepository.findBytipoHora(tipoHora);
    }

    public List<Hora> buscarHorasporFecha(Date fecha){
        return horaRepository.findByfecha(fecha);
    }

    public List<Hora> buscarPorHoras(Date hora){
        return horaRepository.findByHora(hora);
    }
}

package cl.forge.programatufuturo.reservadehoras.services;

import cl.forge.programatufuturo.reservadehoras.respositorys.HoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HoraService {

    private HoraRepository horaRepository;

    @Autowired
    public HoraService(HoraRepository horaRepository){
        this.horaRepository=horaRepository;
    }
}

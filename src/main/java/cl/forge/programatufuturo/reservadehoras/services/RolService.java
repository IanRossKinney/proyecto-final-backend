package cl.forge.programatufuturo.reservadehoras.services;

import cl.forge.programatufuturo.reservadehoras.models.Rol;
import cl.forge.programatufuturo.reservadehoras.respositorys.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolService {

    private RolRepository rolRepository;

    @Autowired
    public RolService(RolRepository rolRepository){
        this.rolRepository=rolRepository;
    }

    public Rol buscarRolPorId(Integer idRol){
        return rolRepository.findByIdRol(idRol);
    }
}

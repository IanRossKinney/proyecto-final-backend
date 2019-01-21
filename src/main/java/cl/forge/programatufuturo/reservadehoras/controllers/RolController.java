package cl.forge.programatufuturo.reservadehoras.controllers;


import cl.forge.programatufuturo.reservadehoras.models.Rol;
import cl.forge.programatufuturo.reservadehoras.services.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
//Request Mapping
@RequestMapping("/rol")
public class RolController {
    private RolService rolService;

    @Autowired
    public RolController(RolService rolService){
        this.rolService=rolService;
    }

    @GetMapping("/buscarrol")
    public Rol buscarRolPorNombre(@RequestParam String nombre){
        return rolService.buscarRolPorNombre(nombre);
    }


}

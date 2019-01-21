package cl.forge.programatufuturo.reservadehoras.controllers;


import cl.forge.programatufuturo.reservadehoras.models.Empleado;
import cl.forge.programatufuturo.reservadehoras.models.Rol;
import cl.forge.programatufuturo.reservadehoras.services.EmpleadoService;
import cl.forge.programatufuturo.reservadehoras.services.RolService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//Request Mapping
@RequestMapping("/empleados")
public class EmpleadoController {

    private EmpleadoService empleadoService;
    private RolService rolService;

    public EmpleadoController(EmpleadoService empleadoService){
        this.empleadoService=empleadoService;
    }


}

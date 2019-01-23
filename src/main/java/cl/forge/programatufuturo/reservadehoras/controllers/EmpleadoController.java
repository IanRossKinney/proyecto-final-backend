package cl.forge.programatufuturo.reservadehoras.controllers;


import cl.forge.programatufuturo.reservadehoras.models.Cliente;
import cl.forge.programatufuturo.reservadehoras.models.Empleado;
import cl.forge.programatufuturo.reservadehoras.models.Rol;
import cl.forge.programatufuturo.reservadehoras.services.EmpleadoService;
import cl.forge.programatufuturo.reservadehoras.services.RolService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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

    //Login de empleado  <-- Hay que hacer la verificacion del rol
    @PostMapping("/login")
    public boolean login(@RequestBody Empleado empleado){
        String newPass=empleadoService.encriptar(empleado.getPassword());
        String newRut=empleado.getRutEmpleado();
        List<Empleado> emp=empleadoService.validador(newRut,newPass);
        if(emp.size()!=0){
            emp.get(0).setUltimoLogin(new Date());
            empleadoService.modificarFecha(emp.get(0));
            System.out.println("Bienvenido");
            return true;
        }
        else {
            System.out.println("Rut o clave incorrectos");
            return false;
        }
    }



}

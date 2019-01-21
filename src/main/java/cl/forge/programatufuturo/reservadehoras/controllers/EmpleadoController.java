package cl.forge.programatufuturo.reservadehoras.controllers;


import cl.forge.programatufuturo.reservadehoras.models.Empleado;
import cl.forge.programatufuturo.reservadehoras.models.Rol;
import cl.forge.programatufuturo.reservadehoras.services.EmpleadoService;
import cl.forge.programatufuturo.reservadehoras.services.RolService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    //Registro Empleados
    @GetMapping("/registrarEmpleado/?")
    public void registrarEmpleado(@RequestParam String rut,
                                  @RequestParam String nombre,
                                  @RequestParam String apellido,
                                  @RequestParam Integer telefono,
                                  @RequestParam String email,
                                  @RequestParam String password,
                                  @RequestParam Integer idRol){
        if (empleadoService.existeRut(rut)){
            System.out.println("Este rut se encuentra registrado");
        }
        else if (empleadoService.existeEmail(email)){
            System.out.println("El mail ya esta en uso");
        }
        else{
            Rol rol=rolService.buscarRolPorId(idRol);
            Empleado empleado= new Empleado(rut,nombre,apellido,telefono,email,password, rol);
            empleadoService.registrarEmpleado(empleado);
            System.out.println("Registro Exitoso");
        }
    }

    //Login Empleado
    @GetMapping("/login")
    public boolean login(@RequestParam String rut, @RequestParam String password){
        String newPass=empleadoService.encriptar(password);
        List<Empleado> empleados=empleadoService.validador(rut,newPass);
        if(empleados.size()!=0){
            System.out.println("Bienvenido");
            return true;
        }
        else {
            System.out.println("Rut o clave incorrectos");
            return false;
        }
    }

    @GetMapping("/buscarEmpleado")
    public List<Empleado>buscarEmpleadoPorNombre(@RequestParam String nombre){
        List<Empleado> empleados=empleadoService.buscarPorNombre(nombre);
        return empleados;
    }

}

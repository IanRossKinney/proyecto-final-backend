package cl.forge.programatufuturo.reservadehoras.controllers;



import cl.forge.programatufuturo.reservadehoras.models.Empleado;
import cl.forge.programatufuturo.reservadehoras.services.EmpleadoService;
import cl.forge.programatufuturo.reservadehoras.services.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/empleados")
@CrossOrigin(origins = "*")
public class EmpleadoController {

    private EmpleadoService empleadoService;
    private RolService rolService;

    @Autowired
    public EmpleadoController(EmpleadoService empleadoService){
        this.empleadoService=empleadoService;
    }

    //Registrar un empleado
    @PutMapping("registrarempleado")
    public boolean registrarEmpleado(@RequestBody Empleado empleado){
        if(empleadoService.existeRut(empleado.getRutEmpleado())){
            System.out.println("Este rut ya se encuentra registrado");
            return false;
        }else if(empleadoService.existeEmail(empleado.getEmail())){
            System.out.println("El mail ya esta en uso");
            return false;
        }else {
            Empleado emp=new Empleado(empleado.getRutEmpleado(),empleado.getNombre(),empleado.getApellido(),empleado.getTelefono(),empleado.getEmail(),empleado.getPassword());
            emp.setPassword(emp.encriptar(emp.getPassword()));
            emp.setUltimoLogin(emp.dateToDate(new Date())+" "+emp.dateToTime(new Date()));
            empleadoService.registrarEmpleado(emp);
            System.out.println("Guardado correctamente");
            return true;
        }
    }




    //Login de empleado
    @PostMapping("/login")
    public Empleado login(@RequestBody Empleado empleado){
        String newPass=empleadoService.encriptar(empleado.getPassword());
        String newRut=empleado.getRutEmpleado();
        List<Empleado> emp=empleadoService.validador(newRut,newPass);
        if(emp.size()!=0){
            emp.get(0).setUltimoLogin(empleado.dateToDate(new Date())+" "+empleado.dateToTime(new Date()));
            empleadoService.modificarFecha(emp.get(0));
            Empleado empl=empleadoService.obtenerEmpleadoPorId(empleado.getRutEmpleado());
            Empleado emp1=new Empleado(empl.getRutEmpleado(),empl.getIdRol());
            System.out.println("Bienvenido");
            return emp1;
        }
        else {
            System.out.println("Rut o clave incorrectos");
            return null;
        }
    }


    //Obtener Empleado por el rut
    @PostMapping("/getempleado")
    public Empleado obtenerEmpleadoPorRut(@RequestBody Empleado empleado){
        Empleado emp=empleadoService.obtenerEmpleadoPorId(empleado.getRutEmpleado());
        return emp;
    }


    //Listar Vendedores para menu(sin admins)
    @GetMapping("/listamenu")
    public List<Empleado> listarParaMenu(){
        List<Empleado> empleados=new ArrayList<>();
        List<Empleado> emp=empleadoService.listarEmpleados();
        for (int i = 0; i < emp.size(); i++) {
            if(emp.get(i).getIdRol().getIdRol()==2){
                Empleado empleado=new Empleado(emp.get(i).getRutEmpleado(),emp.get(i).getNombre(),emp.get(i).getApellido(),emp.get(i).getTelefono(),emp.get(i).getEmail());
                empleados.add(empleado);
            }
        }
        return empleados;
    }


}

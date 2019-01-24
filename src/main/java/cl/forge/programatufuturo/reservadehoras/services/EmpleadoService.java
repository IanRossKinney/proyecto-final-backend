package cl.forge.programatufuturo.reservadehoras.services;

import cl.forge.programatufuturo.reservadehoras.models.Cliente;
import cl.forge.programatufuturo.reservadehoras.models.Empleado;
import cl.forge.programatufuturo.reservadehoras.respositorys.EmpleadoRepository;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmpleadoService {

    private EmpleadoRepository empleadoRepository;

    @Autowired
    public EmpleadoService(EmpleadoRepository empleadoRepository){
        this.empleadoRepository=empleadoRepository;
    }

    //Validar Rut
    public boolean existeRut(String rut){
        return empleadoRepository.existsById(rut);
    }

    //Validar Email
    public boolean existeEmail(String email){
        return empleadoRepository.existsByEmail(email);
    }

    //Registro Empleado
    public void registrarEmpleado(Empleado empleado) {
        empleadoRepository.save(empleado);
    }

    //Validador de login
    public List<Empleado> validador(String rut, String password){
        return empleadoRepository.findByRutEmpleadoAndPassword(rut,password);
    }
    //Buscar al empleado por nombre
    public List<Empleado> buscarPorNombre(String nombre){
        return empleadoRepository.findByNombre(nombre);
    }

    //Buscar empleado por rut
    public Empleado obtenerEmpleadoPorId(String rut){
        return empleadoRepository.findByRutEmpleado(rut);
    }

    //Metodo de encriptacion de clave
    public String encriptar(String password){
        String result = DigestUtils.md5Hex(password);
        return result;
    }
    //Modificar fecha
    public void modificarFecha(Empleado empleado){
        empleadoRepository.save(empleado);
    }

    //Listar empleados
    public List<Empleado> listarEmpleados(){
        List<Empleado> empleados=new ArrayList<>();
        empleadoRepository.findAll().forEach(empleado -> empleados.add(empleado));
        return empleados;
    }

    //Eliminar empleado
    public void eliminarEmpleado(Empleado e){
        Empleado emp=new Empleado(e.getRutEmpleado(),e.getNombre(),e.getApellido(),e.getTelefono(),e.getEmail(),e.getPassword(),e.getIdRol());
        empleadoRepository.delete(emp);
    }


}

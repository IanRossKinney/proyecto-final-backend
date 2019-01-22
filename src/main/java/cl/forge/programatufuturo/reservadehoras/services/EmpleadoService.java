package cl.forge.programatufuturo.reservadehoras.services;

import cl.forge.programatufuturo.reservadehoras.models.Cliente;
import cl.forge.programatufuturo.reservadehoras.models.Empleado;
import cl.forge.programatufuturo.reservadehoras.respositorys.EmpleadoRepository;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    //buscar al empleado por nombre
    public List<Empleado> buscarPorNombre(String nombre){
        return empleadoRepository.findByNombre(nombre);
    }

    //Metodo de encriptacion de clave
    public String encriptar(String password){
        String result = DigestUtils.md5Hex(password);
        return result;
    }
    //Modificar fecha?
    public void modificarFecha(Empleado empleado){
        empleadoRepository.save(empleado);
    }

}

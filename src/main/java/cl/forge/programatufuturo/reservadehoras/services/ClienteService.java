package cl.forge.programatufuturo.reservadehoras.services;

import cl.forge.programatufuturo.reservadehoras.models.Cliente;
import cl.forge.programatufuturo.reservadehoras.respositorys.ClienteRepository;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Service
public class ClienteService {

    private ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository){
        this.clienteRepository=clienteRepository;
    }

    //Validar Rut
    public boolean existeRut(String rut){
        return clienteRepository.existsById(rut);
    }

    //Validar Email
    public boolean existeEmail(String email){
        return clienteRepository.existsByEmail(email);
    }

    //Registrar Cliente
    public void registrarCliente(Cliente cliente){
        clienteRepository.save(cliente);
    }

    //Validador de login
    public List<Cliente> validador(String rut, String password){
        return clienteRepository.findByRutClienteAndPassword(rut,password);
    }
    //Metodo de encriptacion de clave
    public String encriptar(String password) {

        String result = DigestUtils.md5Hex(password);
        return result;

    }

    //Modificar fecha
    public void modificarFecha(Date fecha){
        clienteRepository.updateFecha(fecha);
    }

}

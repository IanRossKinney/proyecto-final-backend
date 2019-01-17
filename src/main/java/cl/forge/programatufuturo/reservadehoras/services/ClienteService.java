package cl.forge.programatufuturo.reservadehoras.services;

import cl.forge.programatufuturo.reservadehoras.models.Cliente;
import cl.forge.programatufuturo.reservadehoras.respositorys.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public void registrarCliente(Cliente cliente){
        clienteRepository.save(cliente);
    }


    //Validador de login
    public List<Cliente> validador(String rut, String password){
        return clienteRepository.findByRutAndPassword(rut,password);
    }
}

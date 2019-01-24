package cl.forge.programatufuturo.reservadehoras.services;

import cl.forge.programatufuturo.reservadehoras.models.Cliente;
import cl.forge.programatufuturo.reservadehoras.respositorys.ClienteRepository;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ClienteService {

    private ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository){
        this.clienteRepository=clienteRepository;
    }


    //Buscar Cliente por Rut
    public Cliente obtenerClientePorId(String rut){
        return clienteRepository.findByRutCliente(rut);

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
    //Listar Clientes
    public List<Cliente> listarClientes(){
        List<Cliente> clientes=new ArrayList<>();
        clienteRepository.findAll().forEach(Cliente -> clientes.add(Cliente));
        return clientes;
    }

    //Modificar fecha
    public void modificarFecha(Cliente cliente){
        clienteRepository.save(cliente);
    }


    //Eliminar un cliente
    public void eliminarCliente(Cliente cliente){
        Cliente cli=new Cliente(cliente.getRutCliente(),cliente.getNombre(),cliente.getApellido(),cliente.getTelefono(),cliente.getEmail(),cliente.getPassword());
        clienteRepository.delete(cli);
    }
}

package cl.forge.programatufuturo.reservadehoras.controllers;


import cl.forge.programatufuturo.reservadehoras.models.Cliente;
import cl.forge.programatufuturo.reservadehoras.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.Date;
import java.util.List;
import java.util.Timer;

@RestController
@RequestMapping("/clientes")
@CrossOrigin(origins = "*")
public class ClienteController {
    private ClienteService clienteService;


    @Autowired
    public ClienteController(ClienteService clienteService){
        this.clienteService=clienteService;
    }


    //Registro de cliente
    @PutMapping("/registrarcliente")
    public void registrarCliente(@RequestBody Cliente cliente){
        if (clienteService.existeRut(cliente.getRutCliente())){
            System.out.println("Este rut se encuentra registrado");
        }
        else if(clienteService.existeEmail(cliente.getEmail())){
            System.out.println("El mail ya esta en uso");
        }
        else {
            clienteService.registrarCliente(cliente);
            System.out.println("Guardado correctamente");
        }
    }

    //Login de cliente
    @PostMapping("/login")
    public boolean login(@RequestBody Cliente cliente){
        String newPass=clienteService.encriptar(cliente.getPassword());
        String newRut=cliente.getRutCliente();
        List<Cliente> client=clienteService.validador(newRut,newPass);
        if(client.size()!=0){
            client.get(0).setUltimoLoginFecha(new Date());
            clienteService.modificarFecha(client.get(0));
            System.out.println("Bienvenido");
            return true;
        }
        else {
            System.out.println("Rut o clave incorrectos");
            return false;
        }
    }

    //@GetMapping("/reservarhora")

    //Listar clientes
   @RequestMapping("/listarclientes")
    public Iterable<Cliente> listarclientes(){

        Iterable<Cliente> clientes=clienteService.listarClientes();
        return clientes;
    }

}

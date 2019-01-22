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
    public boolean registrarCliente(@RequestBody Cliente cliente){
        if (clienteService.existeRut(cliente.getRutCliente())){
            System.out.println("Este rut se encuentra registrado");
            return false;
        }
        else if(clienteService.existeEmail(cliente.getEmail())){
            System.out.println("El mail ya esta en uso");
            return false;
        }
        else {
            cliente.setPassword(cliente.encriptar(cliente.getPassword()));
            cliente.setUltimoLogin(new Date());
            clienteService.registrarCliente(cliente);
            System.out.println("Guardado correctamente");
            return true;
        }
    }

    //Login de cliente
    @PostMapping("/login")
    public boolean login(@RequestBody Cliente cliente){
        String newPass=clienteService.encriptar(cliente.getPassword());
        String newRut=cliente.getRutCliente();
        List<Cliente> cli=clienteService.validador(newRut,newPass);
        if(cli.size()!=0){
            cli.get(0).setUltimoLogin(new Date());
            clienteService.modificarFecha(cli.get(0));
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

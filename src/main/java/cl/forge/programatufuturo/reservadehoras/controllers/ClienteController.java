package cl.forge.programatufuturo.reservadehoras.controllers;


import cl.forge.programatufuturo.reservadehoras.models.Cliente;
import cl.forge.programatufuturo.reservadehoras.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


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
        if (clienteService.existeRut(cliente.getRutCliente())){              //Valida que no exista el rut
            System.out.println("Este rut se encuentra registrado");
            return false;
        }
        else if(clienteService.existeEmail(cliente.getEmail())){             //Valida que no exista el email
            System.out.println("El mail ya esta en uso");
            return false;
        }
        else {                                                               //Si ambos no existen
            cliente.setPassword(cliente.encriptar(cliente.getPassword()));   //Encripta la clave del usuario
            cliente.setUltimoLogin(cliente.dateToDate(new Date())+" "+cliente.dateToTime(new Date()));              //Asigna una fecha de inicio
            clienteService.registrarCliente(cliente);
            System.out.println("Guardado correctamente");
            return true;
        }
    }

    //Login de cliente
    @PostMapping(value= "/login")
    public boolean login(@RequestBody Cliente cliente){
        String newPass=clienteService.encriptar(cliente.getPassword());
        String newRut=cliente.getRutCliente();
        List<Cliente> cli=clienteService.validador(newRut,newPass);
        if(cli.size()!=0){
            cli.get(0).setUltimoLogin(cliente.dateToDate(new Date())+" "+cliente.dateToTime(new Date()));
            clienteService.modificarFecha(cli.get(0));
            System.out.println("Bienvenido");
            return true;
        }
        else {
            System.out.println("Rut o clave incorrectos");
            return false;
        }
    }

    //Listar clientes
    @GetMapping("/listarclientes")
    public List<Cliente> listarClientes(){
        return clienteService.listarClientes();
    }


    //Obtener Cliente por el rut
    @PostMapping("/getcliente")
    public Cliente obtenerClientePorRut(@RequestBody Cliente cliente){
         Cliente cl=clienteService.obtenerClientePorId(cliente.getRutCliente());
         return cl;
    }

    //Eliminar un cliente
    @PostMapping("/eliminarcliente")
    public void eliminarCliente(@RequestBody Cliente cliente){
        clienteService.eliminarCliente(cliente);
    }
}

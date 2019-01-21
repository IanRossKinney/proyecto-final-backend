package cl.forge.programatufuturo.reservadehoras.respositorys;

import cl.forge.programatufuturo.reservadehoras.models.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente,String> {

    //Buscador del mail
    boolean existsByEmail(String cliente);

    //Buscador del login
    List<Cliente> findByRutClienteAndPassword(String rut, String password);



}

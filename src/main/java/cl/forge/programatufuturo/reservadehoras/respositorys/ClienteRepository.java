package cl.forge.programatufuturo.reservadehoras.respositorys;

import cl.forge.programatufuturo.reservadehoras.models.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente,String> {

    //Buscador del mail
    boolean existsByEmail(String email);

    //Buscador del login
    List<Cliente> findByRutAndPassword(String rut, String password);

}

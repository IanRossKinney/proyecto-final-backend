package cl.forge.programatufuturo.reservadehoras.respositorys;

import cl.forge.programatufuturo.reservadehoras.models.Cliente;
import cl.forge.programatufuturo.reservadehoras.models.Empleado;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpleadoRepository extends CrudRepository<Empleado,String> {

    //Buscador del mail
    boolean existsByEmail(String email);

    //Buscador del login
    List<Empleado> findByRutEmpleadoAndPassword(String rut, String password);

    //Buscar por nombre
    List<Empleado> findByNombre(String nombre);
}

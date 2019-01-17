package cl.forge.programatufuturo.reservadehoras.respositorys;

import cl.forge.programatufuturo.reservadehoras.models.Empleado;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends CrudRepository<Empleado,String> {
}

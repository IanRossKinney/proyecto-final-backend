package cl.forge.programatufuturo.reservadehoras.respositorys;

import cl.forge.programatufuturo.reservadehoras.models.Hora;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface HoraRepository extends CrudRepository<Hora,Integer> {

    //Buscar por tipo de hora
    List<Hora> findByTipoHora(String tipoHora);

    //Buscar hora por id
    Hora findByIdHora(String idHora);

    //Buscar hora por fecha
    Hora findByFecha(String fecha);

    //Buscar hora por hora
    Hora findByHora(String hora);

    //Buscar hora por fecha y hora
    Hora findByFechaAndHora(String fecha, String hora);

    //Buscar por empleado
    boolean existsByRutEmpleado(String rutEmpleado);

    //Validar fecha
    boolean existsByFecha(String fecha);

    //Validar Hora
    boolean existsByHora(String hora);

    //Validar tipo
    boolean existsByTipoHora(String tipoHora);
}

package cl.forge.programatufuturo.reservadehoras.respositorys;

import cl.forge.programatufuturo.reservadehoras.models.Hora;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface HoraRepository extends CrudRepository<Hora,Integer> {

    //Buscar por tipo de hora
    List<Hora> findBytipoHora(String tipoHora);

    //Buscar por fecha de hora
    List<Hora> findByfecha(Date fecha);

    //Buscar por hora
    List<Hora> findByHora(Date hora);
}

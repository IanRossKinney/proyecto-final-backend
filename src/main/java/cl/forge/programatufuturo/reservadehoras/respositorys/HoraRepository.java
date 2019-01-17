package cl.forge.programatufuturo.reservadehoras.respositorys;

import cl.forge.programatufuturo.reservadehoras.models.Hora;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HoraRepository extends CrudRepository<Hora,Integer> {
}

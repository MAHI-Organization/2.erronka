package dambi.accessingrelationaldata.respository;

import org.springframework.data.repository.CrudRepository;

import dambi.accessingrelationaldata.model.Partida;

public interface PartidaRepository extends CrudRepository<Partida, Integer> {
    
}

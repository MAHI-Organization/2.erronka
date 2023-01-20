package dambi.accessingmongoumeak.model;

import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface PartidaRepository {
    List<Partida> findAll();
    Partida findById(String id);
    Partida save(Partida partida);
    long delete(String erabiltzailea);
}

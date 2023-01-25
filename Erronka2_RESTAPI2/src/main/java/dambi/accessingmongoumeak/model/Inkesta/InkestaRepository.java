package dambi.accessingmongoumeak.model.Inkesta;

    import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface InkestaRepository {
    List<Inkesta> findAll();
    Inkesta findById(String erabiltzailea);
    Inkesta save(Inkesta inkesta);
    long delete(String lehenengogaldera);
}



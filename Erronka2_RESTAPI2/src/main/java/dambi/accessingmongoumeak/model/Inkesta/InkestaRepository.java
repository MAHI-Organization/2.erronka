package dambi.accessingmongoumeak.model.Inkesta;

    import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface InkestaRepository {
    List<Inkesta> findAll();
    Inkesta findById(String erabiltzailea);
    Inkesta save(Inkesta inkesta);
    Inkesta findByErabiltzaileaJokoa(String erabiltzailea,String jokoarenIzena);
    String delete(String erabiltzailea,String jokoarenIzena);
}



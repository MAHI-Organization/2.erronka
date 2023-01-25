package dambi.accessingmongoumeak.model.Langilea;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface LangileaRepository {
    List<Langilea> findAll();
    Langilea findById(String erabiltzailea);
    Langilea save(Langilea langilea);
    long delete(String izena);
}

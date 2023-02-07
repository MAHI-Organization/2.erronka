package dambi.accessingmongoumeak.model.Komentarioa;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface KomentarioaRepository {
    List<Komentarioa> findAll();
    List<Komentarioa> findByJokoa(String jokua);
    List<Komentarioa> findByErabiltzailea(String erabiltzailea);
    Komentarioa save(Komentarioa komentarioa);
    String deleteById(int id);
}

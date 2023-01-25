package dambi.accessingmongoumeak.model.Komentarioa;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface KomentarioaRepository {
    List<Komentarioa> findAll();
    Komentarioa findById(String jokua);
    Komentarioa save(Komentarioa komentarioa);
    long delete(Komentarioa komentarioa);
}

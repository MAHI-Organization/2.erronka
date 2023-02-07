package dambi.accessingmongoumeak.model.Langilea;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface LangileaRepository {
    List<Langilea> findAll();
    Langilea langileaByUser(String erabiltzailea);
    Langilea langileBerria(Langilea langilea);
    Langilea langileaGorde(Langilea langilea);
    String deleteById(String erabiltzailea);

    boolean pasahitzZuzena(String erabiltzailea,String pasahitza);
}

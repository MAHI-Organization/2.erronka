package dambi.accessingmongoumeak.model.Balorazioa;


import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface BalorazioaRepository {
    List<Balorazioa> findAll();
    Balorazioa findById(String erabiltzailea);
    Balorazioa save(Balorazioa balorazioa);
    long delete(String balorazioa);
}









    


package dambi.accessingmongoumeak.model.Balorazioa;


import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface BalorazioaRepository {
    Balorazioa findByErabiltzaileaJokoa(String izena,String jokoa);
    void deleteByErabiltzaileaJokoa(String izena,String jokoa);
    Balorazioa save(Balorazioa balorazioa);
    float batazBestekoBalorazioa(String jokoarenIzena);
    List<Balorazioa> jokoarenBalorazioa(String jokoarenIzena);
}









    


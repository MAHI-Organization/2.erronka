package dambi.accessingmongoumeak.model.Partida;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mongodb.ReadConcern;
import com.mongodb.ReadPreference;
import com.mongodb.TransactionOptions;
import com.mongodb.WriteConcern;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Sorts;

import static com.mongodb.client.model.Filters.eq;

@Repository
public class MongoDBPartidaRepository implements PartidaRepository {

    private static final TransactionOptions txnOptions = TransactionOptions.builder()
            .readPreference(ReadPreference.primary())
            .readConcern(ReadConcern.MAJORITY)
            .writeConcern(WriteConcern.MAJORITY)
            .build();
    @Autowired
    private MongoClient client;
    private MongoCollection<Partida> partidaCollection;

    @PostConstruct
    void init() {
        partidaCollection = client.getDatabase("erronka2").getCollection("partida", Partida.class);

    }

    @Override
    public List<Partida> findAll() {
        return partidaCollection.find().into(new ArrayList<>());
    }

    @Override
    public Partida findById(String id) {
        return partidaCollection.find(eq("_id", new ObjectId(id))).first();
    }

    @Override
    public Partida save(Partida partida) {
       // partida.setId(0);
        partida.setErabiltzailea(null);
        partida.setPuntuazioa(0);
        partida.setData(null);
        partida.setJokoa(null);
        partidaCollection.insertOne(partida);
        return partida;
    }

    @Override
    public long delete(String erabiltzailea) {
        return partidaCollection.deleteMany(eq("erabiltzailea", erabiltzailea)).getDeletedCount();
    }

    @Override
    public Partida partidaBerria(Partida partida) {
        int id = partidaCollection.find().into(new ArrayList<>()).size();
        //partida.setId(id + 1);
        partidaCollection.insertOne(partida);
        return partida;
    }

    @Override
    public List<Partida> getTopPartidak() {
        List<Partida> partidaGuztiak = partidaCollection.find().sort(Sorts.descending("puntuazioa")).into(new ArrayList<>());
        
        if(partidaGuztiak.size() > 5){
            int i = partidaGuztiak.size()-1;
            while(i > 4){
                partidaGuztiak.remove(i);
                i--;
            }
        }
        return partidaGuztiak;
    }

    
}

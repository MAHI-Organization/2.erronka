package dambi.accessingmongoumeak.model.Komentarioa;

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

import static com.mongodb.client.model.Filters.eq;

@Repository
public class MongoDBKomentarioaRepository implements KomentarioaRepository {

    private static final TransactionOptions txnOptions = TransactionOptions.builder()
            .readPreference(ReadPreference.primary())
            .readConcern(ReadConcern.MAJORITY)
            .writeConcern(WriteConcern.MAJORITY)
            .build();
    @Autowired
    private MongoClient client;
    private MongoCollection<Komentarioa> komentarioaCollection;

    @PostConstruct
    void init() {
        komentarioaCollection = client.getDatabase("erronka2").getCollection("komentarioak", Komentarioa.class);

    }

    @Override
    public List<Komentarioa> findAll() {
        return komentarioaCollection.find().into(new ArrayList<>());
    }

    @Override
    public List<Komentarioa> findByJokoa(String jokoa) {
        return komentarioaCollection.find(eq("jokoa.izena", jokoa)).into(new ArrayList<>());
    }

    @Override
    public Komentarioa save(Komentarioa komentarioa) {
        komentarioaCollection.insertOne(komentarioa);
        return komentarioa;
    }

    @Override
    public String deleteById(int id) {
        if(komentarioaCollection.find(eq("_id", id)).first() != null){
            komentarioaCollection.deleteMany(eq("_id", id));
            return id + " daukan komentarioa ezabatu da";
        }else{
            return "Ez dago " + id + " ID-a daukan komentariorik";
        }
    }

    @Override
    public List<Komentarioa> findByErabiltzailea(String erabiltzailea) {
        return komentarioaCollection.find(eq("erabiltzailea", erabiltzailea)).into(new ArrayList<>());
    }

}

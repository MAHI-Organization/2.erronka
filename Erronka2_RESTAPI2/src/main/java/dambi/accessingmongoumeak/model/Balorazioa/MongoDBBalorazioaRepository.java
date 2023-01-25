package dambi.accessingmongoumeak.model.Balorazioa;

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
public class MongoDBBalorazioaRepository implements BalorazioaRepository {

    private static final TransactionOptions txnOptions = TransactionOptions.builder()
            .readPreference(ReadPreference.primary())
            .readConcern(ReadConcern.MAJORITY)
            .writeConcern(WriteConcern.MAJORITY)
            .build();
    @Autowired
    private MongoClient client;
    private MongoCollection<Balorazioa> langileaCollection;

    @PostConstruct
    void init() {
        langileaCollection = client.getDatabase("Erronka2").getCollection("balorazioa", Balorazioa.class);

    }

    @Override
    public List<Balorazioa> findAll() {
        return langileaCollection.find().into(new ArrayList<>());
    }

    @Override
    public Balorazioa findById(String erabiltzailea) {
        return langileaCollection.find(eq("erabiltzailea", new ObjectId(erabiltzailea))).first();
    }

    @Override
    public Balorazioa save(Balorazioa balorazioa) {

        balorazioa.setErabiltzailea(null);
        balorazioa.setJokoa(null);
        balorazioa.setBalorazioa(0);

        langileaCollection.insertOne(balorazioa);
        return balorazioa;
    }

    @Override
    public long delete(String erabiltzailea) {
        return langileaCollection.deleteMany(eq("erabiltzailea", erabiltzailea)).getDeletedCount();
    }

}

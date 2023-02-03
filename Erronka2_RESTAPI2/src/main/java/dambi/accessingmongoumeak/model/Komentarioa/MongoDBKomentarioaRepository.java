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
    private MongoCollection<Komentarioa> langileaCollection;

    @PostConstruct
    void init() {
        langileaCollection = client.getDatabase("Erronka2").getCollection("komentarioa", Komentarioa.class);

    }

    @Override
    public List<Komentarioa> findAll() {
        return langileaCollection.find().into(new ArrayList<>());
    }

    @Override
    public Komentarioa findById(String erabiltzailea) {
        return langileaCollection.find(eq("erabiltzailea", new ObjectId(erabiltzailea))).first();
    }

    @Override
    public Komentarioa save(Komentarioa komentarioa) {

        komentarioa.setErabiltzailea(null);
        komentarioa.setJokoa(null);
        komentarioa.setKomentarioa(null);

        langileaCollection.insertOne(komentarioa);
        return komentarioa;
    }

    @Override
    public long delete(Komentarioa komentarioa) {
        return langileaCollection.deleteMany(eq("komentarioa", komentarioa)).getDeletedCount();
    }

}

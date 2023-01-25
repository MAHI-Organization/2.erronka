package dambi.accessingmongoumeak.model.Langilea;

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
public class MongoDBLangileaRepository implements LangileaRepository {

    private static final TransactionOptions txnOptions = TransactionOptions.builder()
            .readPreference(ReadPreference.primary())
            .readConcern(ReadConcern.MAJORITY)
            .writeConcern(WriteConcern.MAJORITY)
            .build();
    @Autowired
    private MongoClient client;
    private MongoCollection<Langilea> langileaCollection;

    @PostConstruct
    void init() {
        langileaCollection = client.getDatabase("Erronka2").getCollection("langilea", Langilea.class);

    }

    @Override
    public List<Langilea> findAll() {
        return langileaCollection.find().into(new ArrayList<>());
    }

    @Override
    public Langilea findById(String id) {
        return langileaCollection.find(eq("_id", new ObjectId(id))).first();
    }

    @Override
    public Langilea save(Langilea langilea) {
        langilea.setEmail(null);
        langilea.setIzena(null);
        langilea.setErabiltzailea(null);
        langilea.setJaiotzadata(null);
        langilea.setTaldea(0);
        langilea.setPasahitza(null);
        langileaCollection.insertOne(langilea);
        return langilea;
    }

    @Override
    public long delete(String erabiltzailea) {
        return langileaCollection.deleteMany(eq("erabiltzailea", erabiltzailea)).getDeletedCount();
    }

}

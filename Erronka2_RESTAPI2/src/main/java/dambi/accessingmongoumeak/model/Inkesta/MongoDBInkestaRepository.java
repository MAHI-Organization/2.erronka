package dambi.accessingmongoumeak.model.Inkesta;

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
public class MongoDBInkestaRepository implements InkestaRepository {

    private static final TransactionOptions txnOptions = TransactionOptions.builder()
            .readPreference(ReadPreference.primary())
            .readConcern(ReadConcern.MAJORITY)
            .writeConcern(WriteConcern.MAJORITY)
            .build();
    @Autowired
    private MongoClient client;
    private MongoCollection<Inkesta> langileaCollection;

    @PostConstruct
    void init() {
        langileaCollection = client.getDatabase("Erronka2").getCollection("inkesta", Inkesta.class);

    }

    @Override
    public List<Inkesta> findAll() {
        return langileaCollection.find().into(new ArrayList<>());
    }

    @Override
    public Inkesta findById(String erabiltzailea) {
        return langileaCollection.find(eq("erabiltzailea", new ObjectId(erabiltzailea))).first();
    }

    @Override
    public Inkesta save(Inkesta inkesta) {

      inkesta.setErabiltzailea(null);
      inkesta.setLehenengoGaldera(null);
      inkesta.setBigarrenGaldera(null);
      inkesta.setHirugarrenGaldera(null);
      inkesta.setLaugarrenGaldera(null);

        langileaCollection.insertOne(inkesta);
        return inkesta;
    }

    @Override
    public long delete(String lehenengogaldera) {
        return langileaCollection.deleteMany(eq("komentarioa", lehenengogaldera)).getDeletedCount();
    }

    

   
    }



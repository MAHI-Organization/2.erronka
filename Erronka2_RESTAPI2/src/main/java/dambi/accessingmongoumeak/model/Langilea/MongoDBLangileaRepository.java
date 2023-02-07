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
        langileaCollection = client.getDatabase("erronka2").getCollection("langileak", Langilea.class);

    }

    @Override
    public List<Langilea> findAll() {
        return langileaCollection.find().into(new ArrayList<>());
    }

    @Override
    public Langilea langileBerria(Langilea langilea) {
        langileaCollection.insertOne(langilea);
        return langilea;
    }

    @Override
    public Langilea langileaByUser(String erabiltzailea) {
        return langileaCollection.find(eq("erabiltzailea", erabiltzailea)).first();
        
    }

    @Override
    public Langilea langileaGorde(Langilea langilea) {

        langileaCollection.insertOne(langilea);
        return langilea;
    }

    @Override
    public String deleteById(String erabiltzailea) {
        if (langileaCollection.find(eq("erabiltzailea", erabiltzailea)).first() != null) {
            langileaCollection.deleteMany(eq("erabiltzailea", erabiltzailea));
            return erabiltzailea + " daukan pelikula datu-basetik ezabatua izan da";
        } else {
            return "Ez dago " + erabiltzailea + " ID-a daukan pelikularik";
        }
    }

    @Override
    public boolean pasahitzZuzena(String erabiltzailea, String pasahitza) {
        Langilea langilea = langileaCollection.find(eq("erabiltzailea",erabiltzailea)).first();
        if(langilea != null && langilea.getPasahitza().equals(pasahitza)){
            return true;
        }
        return false;
    }

    
    

}

package dambi.accessingmongoumeak.model.Inkesta;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mongodb.BasicDBObject;
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
    private MongoCollection<Inkesta> inkestaCollection;

    @PostConstruct
    void init() {
        inkestaCollection = client.getDatabase("erronka2").getCollection("inkestak", Inkesta.class);

    }

    @Override
    public List<Inkesta> findAll() {
        return inkestaCollection.find().into(new ArrayList<>());
    }

    @Override
    public Inkesta findById(String erabiltzailea) {
        return inkestaCollection.find(eq("erabiltzailea", new ObjectId(erabiltzailea))).first();
    }

    @Override
    public Inkesta save(Inkesta inkesta) {
        inkestaCollection.insertOne(inkesta);
        return inkesta;
    }

    @Override
    public String delete(String erabiltzailea,String jokoarenIzena) {
        if(findByErabiltzaileaJokoa(erabiltzailea, jokoarenIzena) != null){
            BasicDBObject query = new BasicDBObject();
            List<BasicDBObject> andList = new ArrayList<BasicDBObject>();
            andList.add(new BasicDBObject("erabiltzailea", erabiltzailea));
            andList.add(new BasicDBObject("jokoa.izena", jokoarenIzena));
            query.put("$and", andList);
            inkestaCollection.deleteMany(query);
            return "Inkesta ezabatu da";
        }else{
            return "Ez da inkesta aurkitu";
        }
    }

    @Override
    public Inkesta findByErabiltzaileaJokoa(String erabiltzailea, String jokoarenIzena) {
        BasicDBObject query = new BasicDBObject();
        List<BasicDBObject> andList = new ArrayList<BasicDBObject>();
        andList.add(new BasicDBObject("erabiltzailea", erabiltzailea));
        andList.add(new BasicDBObject("jokoa.izena", jokoarenIzena));
        query.put("$and", andList);
        return inkestaCollection.find(query).first();
    }

    

   
    }



package dambi.accessingmongoumeak.model.Balorazioa;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.validation.Valid;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import com.mongodb.BasicDBObject;
import com.mongodb.ReadConcern;
import com.mongodb.ReadPreference;
import com.mongodb.TransactionOptions;
import com.mongodb.WriteConcern;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

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
    private MongoCollection<Balorazioa> balorazioaCollection;

    @PostConstruct
    void init() {
        balorazioaCollection = client.getDatabase("erronka2").getCollection("balorazioak", Balorazioa.class);

    }

    @Override
    public Balorazioa save(Balorazioa balorazioa) {
        balorazioaCollection.insertOne(balorazioa);
        return balorazioa;
    }

    @Override
    public float batazBestekoBalorazioa(String jokoarenIzena) {
        List<Balorazioa>balorazioak = balorazioaCollection.find().into(new ArrayList<>());
        float balorazioKantitatea = 0;
        float balorazioaGuztira = 0;
        float batazBestekoBalorazioa = 0;
        for(int i = 0;i < balorazioak.size();i++){
            if(balorazioak.get(i).getJokoa().getIzena().equals(jokoarenIzena)){
                balorazioaGuztira += balorazioak.get(i).getBalorazioa();
                balorazioKantitatea++;
            }
        }
        batazBestekoBalorazioa = balorazioaGuztira / balorazioKantitatea;

        return batazBestekoBalorazioa;
    }



    @Override
    public Balorazioa findByErabiltzaileaJokoa(String izena,String jokoa) {
        // TODO Auto-generated method stub
        BasicDBObject query = new BasicDBObject();
        List<BasicDBObject> andList = new ArrayList<BasicDBObject>();
        andList.add(new BasicDBObject("erabiltzailea", izena));
        andList.add(new BasicDBObject("jokoa.izena", jokoa));
        query.put("$and", andList);
        return balorazioaCollection.find(query).first();
    }

    @Override
    public void deleteByErabiltzaileaJokoa(String izena, String jokoa) {
        // TODO Auto-generated method stub
        Balorazioa balorazioa = findByErabiltzaileaJokoa(izena, jokoa);
        if(balorazioa != null){
            BasicDBObject query = new BasicDBObject();
            List<BasicDBObject> andList = new ArrayList<BasicDBObject>();
            andList.add(new BasicDBObject("erabiltzailea", izena));
            andList.add(new BasicDBObject("jokoa.izena", jokoa));
            query.put("$and", andList);
            balorazioaCollection.deleteMany(query);
        }
    }

    @Override
    public List<Balorazioa> jokoarenBalorazioa(String jokoarenIzena) {
        // TODO Auto-generated method stub
        List<Balorazioa>balorazioak = balorazioaCollection.find(eq("jokoa.izena", jokoarenIzena)).into(new ArrayList<>());
        return balorazioak;
    }}

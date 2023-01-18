import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class MongoConnection {
    private MongoClient mongoClient;
    private MongoDatabase db;

    public void connectDatabase(){
        setMongoClient(new MongoClient("192.168.65.11",27017));
    }

    public MongoClient getMongoClient(){
        return mongoClient;
    }

    public void setMongoClient(MongoClient mongoClient){
        this.mongoClient = mongoClient;
    }

    public MongoClient getDatabase(){
        return db;
    }

    public void setDatabase(MongoDatabase db){
        this.db = db;
    }
}

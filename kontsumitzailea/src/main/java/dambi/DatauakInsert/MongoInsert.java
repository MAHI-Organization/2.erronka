package dambi.DatauakInsert;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoWriteException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import dambi.Model.Langilea;
import dambi.Model.Partida;

public class MongoInsert {

    private static String dbStr = "erronka2";
    private static String collectionPartida = "partida";
    

    public static MongoClient connect() {
        CodecRegistry pojoCodecRegistry = CodecRegistries.fromRegistries(
                MongoClientSettings.getDefaultCodecRegistry(),
                CodecRegistries.fromProviders(PojoCodecProvider.builder().automatic(true).build()));
        MongoClient mongoClient = MongoClients.create(MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString("mongodb://192.168.65.14:27017"))
                .codecRegistry(pojoCodecRegistry)
                .build());

        return mongoClient;
    }

    public static void insertPartidak(List<Partida> partidak, String jokoa) throws IOException {
        try {
            MongoClient mongo = connect();
            MongoDatabase db = mongo.getDatabase(dbStr);
            MongoCollection<Document> collection = db.getCollection(collectionPartida);
            SimpleDateFormat sdf;
            String dateString;
            FileWriter writer;
            
            int count = 0;
            for (Partida partida : partidak) {
                Langilea lang = new Langilea();
                lang.setEmail(partida.getLangilea().getEmail());
                lang.setIzena(partida.getLangilea().getIzena());
                lang.setErabiltzailea(partida.getLangilea().getErabiltzailea());
                lang.setJaiotzadata(partida.getLangilea().getJaiotzadata());
                lang.setTaldea(partida.getLangilea().getTaldea());

                Document part = new Document();
                part.put("id", partida.getId());
                part.put("langilea", lang);
                part.put("puntuazioa", partida.getPuntuazioa());
                part.put("data", partida.getData().toString());
                part.put("jokoa", jokoa);
                System.out.println(part);
                Document found = collection.find(Filters.and(Filters.eq("id", part.getInteger("id")),
                        Filters.eq("langilea", part.getString("erabiltzailea")))).first();
                if (found == null) {
                    try {
                        
                        collection.insertOne(part);
                        count++;
                        
                    } catch (MongoWriteException e) {
                        System.out.println("its duplicated");
                    }
                    
                }

            }
            if (count == 0){
                if(jokoa == "MahiKingdom"){
                    sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    dateString = sdf.format(new Date());
                    writer = new FileWriter("sarrerak.log", true);
                    writer.write(
                            dateString + " - Ez dira 1. taldearen datuak sartu\n");
                    writer.close();
                }else if(jokoa == "Taldea2"){
                    sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    dateString = sdf.format(new Date());
                    writer = new FileWriter("sarrerak.log", true);
                    writer.write(
                            dateString + " - Ez dira 2. taldearen datuak sartu\n");
                    writer.close();
                }else if(jokoa == "Pouni"){
                    sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    dateString = sdf.format(new Date());
                    writer = new FileWriter("sarrerak.log", true);
                    writer.write(
                            dateString + " - Ez dira 3. taldearen datuak sartu\n");
                    writer.close();
                }else if(jokoa == "Johnny"){
                    sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    dateString = sdf.format(new Date());
                    writer = new FileWriter("sarrerak.log", true);
                    writer.write(
                            dateString + " - Ez dira 4. taldearen datuak sartu\n");
                    writer.close();
                }
            }else{
                if(jokoa == "MahiKingdom"){
                    sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    dateString = sdf.format(new Date());
                    writer = new FileWriter("sarrerak.log", true);
                    writer.write(
                            dateString + " - Ondo sartu dira 1. taldearen datuak\n");
                    writer.close();
                }else if(jokoa == "Taldea2"){
                    sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    dateString = sdf.format(new Date());
                    writer = new FileWriter("sarrerak.log", true);
                    writer.write(
                            dateString + " - Ondo sartu dira 2. taldearen datuak\n");
                    writer.close();
                }else if(jokoa == "Pouni"){
                    sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    dateString = sdf.format(new Date());
                    writer = new FileWriter("sarrerak.log", true);
                    writer.write(
                            dateString + " - Ondo sartu dira 3. taldearen datuak\n");
                    writer.close();
                }else if(jokoa == "Johnny"){
                    sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    dateString = sdf.format(new Date());
                    writer = new FileWriter("sarrerak.log", true);
                    writer.write(
                            dateString + " - Ondo sartu dira 4. taldearen datuak\n");
                    writer.close();
                }
            }
        } catch (MongoWriteException e) {
            System.out.println("Errore bat gertatu da: " + e.getMessage());
        }

    }
}

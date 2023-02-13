package dambi;

import com.mongodb.MongoWriteException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

import dambi.Model.Partida;

import org.bson.BsonArray;
import org.bson.BsonValue;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonReader;
import javax.json.JsonValue;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class App {

    /**
     * @param args
     */
    public static void main(String[] args) {
        MongoClient mongoClient = null;

        try {

            // Conectar a la base de datos MongoDB
            mongoClient = MongoClients.create("mongodb://192.168.65.14:27017");

            MongoDatabase database = mongoClient.getDatabase("erronka2");
            MongoCollection<Document> collection = database.getCollection("partida");
            List<String> endpoints = Arrays.asList("http://192.168.65.11:8080/api/allPartidak",
                    /* "http://192.168.65.22:8080/demo/all_Partida", */"http://192.168.65.123:8080/Partidak/getPartidak");
            // Realizar una solicitud GET a la API REST de Swagger
            for (String endpoint : endpoints) {
                URL url = new URL(endpoint);
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                con.setRequestMethod("GET");

                // Leer la respuesta de la API y convertirla a un objeto JSON
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                JsonElement json = JsonParser.parseString(response.toString());
                System.out.println(json);
                JsonArray data = json.getAsJsonArray();

                Gson gson = new Gson();
                List<Partida> partidak = new ArrayList<>();

                for (int i = 0; i < data.size(); i++) {
                    JsonElement item = data.get(i);
                    // String removedQuotes = item.toString().replaceAll("^\"|\"$", "");

                    Partida partida = gson.fromJson(item, Partida.class);
                    System.out.println(partida);
                    partidak.add(partida);
                }

                List<Document> documents = new ArrayList<>();
                for (Partida partida : partidak) {
                    Document lang = new Document();
                    lang.put("erabiltzailea", partida.getLangilea().getErabiltzailea());
                    lang.put("email", partida.getLangilea().getEmail());
                    lang.put("izena", partida.getLangilea().getIzena());
                    lang.put("jaiotza_data", partida.getLangilea().getJaiotzadata().toString());
                    lang.put("taldea", partida.getLangilea().getTaldea());
                    Document part = new Document();
                    part.put("id", partida.getId());
                    part.put("langilea", lang);
                    part.put("puntuazioa", partida.getPuntuazioa());
                    part.put("data", partida.getData().toString());
                    System.out.println(part);
                    // documents.add(part);
                    Document found = collection.find(Filters.and(Filters.eq("id", part.getInteger("id")),
                            Filters.eq("langilea", part.getString("erabiltzailea")))).first();
                    if (found == null) {
                        try{
                            collection.insertOne(part);
                        }
                        catch(MongoWriteException e){
                            System.out.println("its duplicated");
                        }
                        
                    }
                    System.out.println(found);
                }

                
                // Insertar los datos del objeto JSON en la base de datos MongoDB
                if (endpoint.contains("192.168.65.11")) {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String dateString = sdf.format(new Date());
                    FileWriter writer = new FileWriter("sarrerak.log", true);
                    writer.write(
                            dateString + " - Ondo sartu dira 1. taldearen datuak\n");
                    writer.close();
                } else if (endpoint.contains("192.168.65.123")) {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String dateString = sdf.format(new Date());
                    FileWriter writer = new FileWriter("sarrerak.log", true);
                    writer.write(
                            dateString + " - Ondo sartu dira 4. taldearen datuak\n");
                    writer.close();
                }
                // Registrar la hora de la inserción en un archivo de texto

                // Cerrar la conexión con la base de datos MongoDB
                mongoClient.close();

                System.out.println(
                        "Los datos se han insertado correctamente en la base de datos MongoDB y se ha registrado la hora en el archivo de texto.");
            }
        } catch (

        Exception e) {
            System.out.println("Ha ocurrido un error: " + e.getMessage());
        }

    }
}

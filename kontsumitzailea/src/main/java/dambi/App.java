package dambi;

import com.mongodb.MongoWriteException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

import dambi.DatauakInsert.ApiKontsumitzailea;
import dambi.DatauakInsert.MongoInsert;
import dambi.Model.Partida;

import org.bson.BsonArray;
import org.bson.BsonValue;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
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

    private static String taldea1 = "http://192.168.65.11:8080/api/allPartidak";
    private static String taldea2 = "192.168.65.90:8081/demo/all_Partida";
    private static String taldea3 = "http://192.168.65.12:8080/proba/getCollectionsT3";
    private static String taldea4 = "http://192.168.65.123:8080/Partidak/getPartidak";

    /**
     * @param args
     * @throws ParseException
     */
    public static void main(String[] args) throws ParseException {

        insertPartidak(taldea1, "MahiKingdom");
        insertPartidak(taldea2, "Taldea2");
        insertPartidak(taldea3, "Pouni");
        insertPartidak(taldea4, "Johnny");

    }

    public static void insertPartidak(String url, String jokoa) throws ParseException {
        JsonArray data;
        try {

            data = ApiKontsumitzailea.apiaIrakurri(url);

            Gson gson = new Gson();
            List<Partida> partidak = new ArrayList<>();

            for (int i = 0; i < data.size(); i++) {
                JsonElement item = data.get(i);
                

                Partida partida = gson.fromJson(item, Partida.class);
                System.out.println(partida);
                partidak.add(partida);
            }
            MongoInsert.insertPartidak(partidak, jokoa);

        } catch (NullPointerException | IOException e) {
            // TODO Auto-generated catch block
            
        }

    }

}

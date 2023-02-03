package dambi;



import com.mongodb.client.MongoClient;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

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

            // Realizar una solicitud GET a la API REST de Swagger
            URL url = new URL("http://192.168.65.11:8080/api/allPartidak");
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
            JSONArray json = new JSONArray(response.toString());

            for(Object obj :json){
                 Document document = new Document(((JSONObject) obj).toMap());
                collection.insertOne(document);
            }
                
            // Insertar los datos del objeto JSON en la base de datos MongoDB
           

            // Registrar la hora de la inserción en un archivo de texto
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateString = sdf.format(new Date());
            FileWriter writer = new FileWriter("log.txt", true);
            writer.write(dateString + " - Los datos se han insertado correctamente en la base de datos MongoDB.\n");
            writer.close();

            // Cerrar la conexión con la base de datos MongoDB
            mongoClient.close();

            System.out.println("Los datos se han insertado correctamente en la base de datos MongoDB y se ha registrado la hora en el archivo de texto.");
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error: " + e.getMessage());
        }
    }
}

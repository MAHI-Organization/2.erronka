package dambi.DatauakInsert;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class ApiKontsumitzailea {

    public static JsonArray apiaIrakurri(String apiUrl) throws IOException {
        JsonArray data = null;
        SimpleDateFormat sdf;
        String dateString;
        FileWriter writer;
        try {
            URL url = new URL(apiUrl);
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
            data = json.getAsJsonArray();

        } catch (ConnectException exception) {
            sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            dateString = sdf.format(new Date());
            writer = new FileWriter("sarrerak.log", true);
            writer.write(
                    dateString + "Errorea ApiRest-era konektatzean:" + exception.getMessage() + " URL:" + apiUrl + "\n");
            writer.close();
            
        }
        return data;

    }
}

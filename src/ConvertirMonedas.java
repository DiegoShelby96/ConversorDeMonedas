import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

public class ConvertirMonedas {
    private Map<String, String> nombreMoneda;

    public ApiMoneda consultaMoneda(String generarMoneda) {


        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/1535d9b792378e43cee0fb11/latest/" + generarMoneda);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();
        HttpResponse<String> response;
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Respuesta de la API: " + response.body());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al encontrar la API");
        }
        JsonObject jsonResponse = JsonParser.parseString(response.body()).getAsJsonObject();
        if (jsonResponse.has("Error")) {
            throw new RuntimeException("Moneda no valida");
        }
        String baseCode = jsonResponse.get("base_code").getAsString();

        Map<String, Double> rates = new Gson().fromJson(jsonResponse.get("conversion_rates"), Map.class);
        return new ApiMoneda(baseCode, rates);
    }

}


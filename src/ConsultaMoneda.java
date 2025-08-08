import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMoneda {


    public double buscarMoneda (String monedaBase, String monedaAConvertir){
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/8d583aa4b9795f29dfeec6ba/latest/"+
                monedaBase);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            JsonObject json =  JsonParser.parseString(response.body()).getAsJsonObject();

            if (json.get("result").getAsString().equals("success")) {
                JsonObject conversionRates = json.getAsJsonObject("conversion_rates");

                return conversionRates.get(monedaAConvertir).getAsDouble();
            } else {
                System.out.println("Error en la respuesta de la API.");
            }
        } catch (IOException | InterruptedException e) {
            System.out.println("Error al consultar la API: " + e.getMessage());
        }

        return -1;

    }

}

//        try {
//            HttpResponse<String> response = null;
//            response = client
//                    .send(request, HttpResponse.BodyHandlers.ofString());
//
//
//            return new Gson().fromJson(response.body(), Moneda.class);
//        } catch (Exception e) {
//            throw new RuntimeException("No encontré esa moneda");
//        }

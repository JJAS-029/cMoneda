import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultarMoneda {

    public double obtenerTasa(String base, String destino) {
        // URL de la API con la moneda base
        String apiUrl = "https://v6.exchangerate-api.com/v6/67993ca028785f737a00e191/latest/" + base;

        HttpClient client = HttpClient.newBuilder().build();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                // Parsear el JSON de la respuesta
                Gson gson = new Gson();
                RespuestaApi respuestaApi = gson.fromJson(response.body(), RespuestaApi.class);
                return respuestaApi.conversion_rates().get(destino); // Devuelve la tasa de cambio
            }
        } catch (IOException | InterruptedException e) {
            System.out.println("Error al obtener la tasa de cambio: " + e.getMessage());
        }
        return -1; // Indica que hubo un error
    }
}

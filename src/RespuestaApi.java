import java.util.Map;

public record RespuestaApi(
        String result,
        Map<String, Double> conversion_rates
) {
}

import java.util.Map;

public record ApiMoneda(String base_code,
                        Map<String, Double> rates){
}

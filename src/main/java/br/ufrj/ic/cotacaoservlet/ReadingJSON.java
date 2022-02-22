import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.json;

public class ReadingJSON{
    public static String ReadingEconomia() {
        String json = "";
        try {
            URL url = new URL("https://economia.awesomeapi.com.br/json/last/BTC-BRL");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");
            Scanner scanner = new Scanner(connection.getInputStream());
            json += scanner.nextLine();
            while (scanner.hasNextLine()) {
                json += scanner.nextLine();
            }
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return json;
    }
}
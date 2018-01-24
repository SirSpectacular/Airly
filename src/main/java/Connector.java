import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

//60e5ba585a46481a94b6f6437310e49a

public class Connector {
    public static String getResponse(URL url, String apiKey) throws Exception {
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        con.setRequestMethod("GET");
        con.setRequestProperty("apikey", apiKey);
        con.setRequestProperty("Accept", "application/json");

        con.setConnectTimeout(5000);
        con.setReadTimeout(5000);

        int status = con.getResponseCode();
        if (status == 403) {
            System.out.println("Wrong API key");
        }

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null)
            content.append(inputLine);
        in.close();

        con.disconnect();

        return content.toString();
    }
}
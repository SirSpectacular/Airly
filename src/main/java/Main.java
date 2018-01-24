import com.google.gson.Gson;

import java.io.IOException;
import java.net.URL;

public class Main {


    public static void main(String[] Args) {

        OptionParser optionParser = new OptionParser(Args);

        String apiKey = null;

        if (System.getenv("API_KEY") != null)
            apiKey = System.getenv("API_KEY");

        if (optionParser.getParsedApiKey() != null)
            apiKey = optionParser.getParsedApiKey();

        if (apiKey == null) {
            System.out.println("You forgot to parse API key or state it in environmental variable");
            System.exit(1);
        }
        String output = null;
        try {
            switch (optionParser.getMode()) {
                case "mapPoint": {

                    output = Connector.getResponse(
                            new URL("https://airapi.airly.eu/v1/mapPoint/measurements?latitude=" + optionParser.getLatitude() + "&longitude=" + optionParser.getLongitude()),
                            apiKey);
                    break;
                }
                case "sensor": {
                    output = Connector.getResponse(
                            new URL("https://airapi.airly.eu/v1/sensor/measurements?sensorId=" + optionParser.getSensorId()),
                            apiKey);
                    break;
                }
            }
            Measurements measurements = new Gson().fromJson(output, Measurements.class);
            new Viewer(measurements).print(optionParser.getShowHistory());
        } catch (IOException e) {
            System.out.println("Something went wrong while program was trying to get data from the server");
        }
    }
}
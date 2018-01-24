import java.net.URL;

public class Main {


    public static void main(String[] Args) {

        OptionParser optionParser = new OptionParser(Args);

        String apiKey = null;

        if (System.getenv().get("API_KEY") != null)
            apiKey = System.getenv().get("API_KEY");

        if (optionParser.getParsedApiKey() != null)
            apiKey = optionParser.getParsedApiKey();

        if (apiKey == null) {
            System.out.println("You forgot to parse API key or state it in environmental variable");
            System.exit(1);
        }
        switch (optionParser.getMode()) {
            case "mapPoint": {
                try {
                    String outputJson = Connector.getResponse(new URL(
                            "https://airapi.airly.eu/v1/mapPoint/measurements" +
                                    "?latitude=" + optionParser.getLatitude() +
                                    "&longitude=" + optionParser.getLongitude()),
                            apiKey);

                    System.out.println(outputJson);
                } catch (Exception e) {
                    System.out.println("here" + e.getMessage());
                }
            }

            case "sensor": {
                try {
                    String out = Connector.getResponse(new URL(
                            "https://airapi.airly.eu/v1/sensor/measurements" +
                                    "?sensorid=" + optionParser.getSensorId()),
                            apiKey);

                    System.out.println(out);
                } catch (Exception e) {
                    System.out.println("here" + e.getMessage());
                }

            }
        }
    }
}

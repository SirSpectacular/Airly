import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;

public class OptionParser {

    OptionParser(String[] args){
        try {
                JCommander.newBuilder()
                        .addObject(this)
                        .build()
                        .parse(args);

            if (longitude != null &&
                    latitude != null &&
                    sensorId == null)
                mode = "mapPoint";
            else if (longitude == null &&
                    latitude == null &&
                    sensorId != null)
                mode = "sensor";
            throw new ParameterException("");

        } catch (ParameterException ex) {
            System.out.println("Given parameters were incorrect");
            System.exit(1);
        }
    }

    @Parameter(names = {"--latitude"})
    private String latitude;

    @Parameter(names = {"--longitude"})
    private String longitude;

    @Parameter(names = {"--sensor"})
    private Integer sensorId;

    @Parameter(names = {"--key"},
            description = "Is necessary to run the program, no need to parse it in parameter if it's stated in environmental variable: \'API_KE\'")
    private String parsedApiKey;

    @Parameter(names = {"--history"},
            description = "Shows shortened recap of data from past 24h")
    private boolean showHistory;

    private String mode;


    public Integer getSensorId() {
        return sensorId;
    }

    public String getParsedApiKey() {
        return parsedApiKey;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public boolean getShowHistory() {
        return showHistory;
    }

    public String getMode() {
        return mode;
    }
}

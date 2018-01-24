import java.util.ArrayList;
import java.util.List;

public class Viewer {
    private Measurements measurements;
    private String header =
                    "+--------------------------------------------------+\n" +
                    "|*                                                *|\n" +
                    "|*                  \033[0;34mAirly client\033[0m                  *|\n" +
                    "|*                                                *|\n" +
                    "+--------------------------------------------------+";
    private String separator = "+--------------------------------------------------+";


    private final String red = "\033[0;31m";
    private final String yellow = "\033[0;33m";
    private final String green = "\033[0;32m";
    private final String reset = "\033[0m";


    public Viewer(Measurements measurements) {
        this.measurements = measurements;
    }


    public void print(boolean showHistory) {
        System.out.println(header);
        System.out.println("Current measurements:");
        System.out.println(separator);
        MeasurementDetails currentMeasurements = this.measurements.getCurrentMeasurements();
        List<String> measurements = new ArrayList<>();
        measurements.add("Air Quality Index |" + getAqiText(currentMeasurements));
        measurements.add("Humidity          |" + getMeasurementWithColor(currentMeasurements.getHumidity(),90.0) + " %");
        measurements.add("PM 1              |" + getMeasurementWithColor(currentMeasurements.getPm1(), 20.0) + " μg/m³");
        measurements.add("PM 2,5            |" + getMeasurementWithColor(currentMeasurements.getPm25(), 30.0) + " μg/m³");
        measurements.add("PM 10             |" + getMeasurementWithColor(currentMeasurements.getPm10(), 40.0) + " μg/m³");
        measurements.add("Pressure          |" + (int)(currentMeasurements.getPressure() / 100.0) + " hPa");
        measurements.add("Temperature       |" + getMeasurementWithColor(currentMeasurements.getTemperature(), 2) + " \u00B0C");
        for(String measurement : measurements)
            System.out.println(measurement);
        System.out.println(separator);
        if(showHistory){
            System.out.println("Historical measurments:");
            System.out.println(separator);
            for(History entry : this.measurements.getHistory()) {
                System.out.println("from: " + entry.getFromDateTime().replaceAll("[TZ]", " ") +
                        " to: " + entry.getTillDateTime().replaceAll("[TZ]", " "));
                System.out.println("PM 2,5            |" + getMeasurementWithColor(entry.getMeasurments().getPm25(), 30.0) + " μg/m³");
                System.out.println("PM 10             |" + getMeasurementWithColor(entry.getMeasurments().getPm10(), 40.0) + " μg/m³ \n");
            }
        }
    }


    private String getAqiText(MeasurementDetails measurementDetails) {
        double AQI = measurementDetails.getAirQualityIndex();
        if (AQI >= 75.0) {
            return red + "VERY HIGH POLLUTION" + reset;
        }
        if (AQI >= 50.0) {
            return red + "HIGH POLLUTION" + reset;
        }
        if (AQI >= 50.0) {
            return yellow + "MEDIUM POLLUTION" + reset;
        }
        if (AQI >= 25.0) {
            return green + "LOW POLLUTION" + reset;
        }
        return green + "VERY LOW POLLUTION" + reset;
    }

    private String getMeasurementWithColor(double measurment, double threshold) {
        measurment = round(measurment, 2);
        if (measurment >= threshold) { return red + measurment + reset; }
        return Double.toString(measurment);
    }

    private static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }


}

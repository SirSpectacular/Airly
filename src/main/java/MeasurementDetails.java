import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class MeasurementDetails {
    private double airQualityIndex;
    private double humidity;
    private double pm1;
    private double pm25;
    private double pm10;
    private double pressure;
    private double temperature;

    private MeasurementDetails(){}

    public double getAirQualityIndex(){
        return airQualityIndex;
    }

    public double getHumidity(){
        return humidity;
    }

    public double getPm1(){
        return pm1;
    }

    public double getPm25(){
        return pm25;
    }

    public double getPm10(){
        return pm10;
    }

    public double getPressure(){
        return pressure;
    }

    public double getTemperature(){
        return temperature;
    }
}
import java.util.List;

public class Measurements {
    private MeasurementDetails currentMeasurements;
    private List<History> history;

    private Measurements(){}

    public MeasurementDetails getCurrentMeasurements(){
        return currentMeasurements;
    }
    public List<History> getHistory(){
        return history;
    }
}

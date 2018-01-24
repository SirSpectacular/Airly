public class History {
    private String tillDateTime;
    private String fromDateTime;
    private MeasurementDetails measurements;

    private History(){}

    public MeasurementDetails getMeasurments() {
        return measurements;
    }

    public String getFromDateTime() {
        return fromDateTime;
    }

    public String getTillDateTime() {
        return tillDateTime;
    }
}

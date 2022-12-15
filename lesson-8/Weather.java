public class Weather{
    private final Forecast forecast;
    public Weather(Forecast forec){
        forecast = forec;
    }
    public int temperature(){
        return forecast.todaysTemp();
    } 
}
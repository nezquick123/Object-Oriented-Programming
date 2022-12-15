
public class MyClass {
    public static void main(String args[]) {
        Forecast forecast = new Forecast.Fake();
        Weather today = new Weather(forecast);
        int temperature = today.temperature();
        assert "20".equals(temperature.toString());
    }
}
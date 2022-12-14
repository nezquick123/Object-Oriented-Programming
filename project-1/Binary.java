import java.io.IOException;

public class Binary implements NumSystem{
    private String svalue;
    public Binary(String b){
        svalue = b;
    }
    public Binary(String value, String system){
        svalue = convert(value, system);
    }
    public String convert(String value, String system){
        Decimal dec = new Decimal(value, system);
        String res = "";
        try {
            res = dec.convertedTo("bin");
        }catch (IOException ex){
            System.err.println(ex.getMessage());
        }
        return res;
    }
    public String value(){return svalue;}
}

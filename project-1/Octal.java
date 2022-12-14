import java.io.IOException;

public class Octal implements NumSystem {
    private String svalue;
    public Octal(String o){
        svalue = o;
    }
    public Octal(String value, String system){
        svalue = convert(value, system);
    }
    public String convert(String value, String system){
        Decimal dec = new Decimal(value, system);
        String res = "";
        try {
            res = dec.convertedTo("oct");
        }catch (IOException ex){
            System.err.println(ex.getMessage());
        }
        return res;
    }
    public String value(){return svalue;}
}

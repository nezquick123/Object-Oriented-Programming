import java.io.IOException;

public class HexDec implements NumSystem{
    private String svalue;
    public HexDec(String h){
        svalue = h;
    }
    public HexDec(String value, String system){
        svalue = convert(value, system);
    }
    public String convert(String value, String system){
        Decimal dec = new Decimal(value, system);
        String res = "";
        try {
        res = dec.convertedTo("hex");
        }catch (IOException ex){
            System.err.println(ex.getMessage());
        }
        return res;
    }
    public String value(){return svalue;}
}

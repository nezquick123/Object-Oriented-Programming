package pl.poznan.put;

import java.io.IOException;

public class HexDec implements NumSystem{
    private final String svalue;
    public HexDec(String h){
        svalue = h;
    }
    public HexDec(String value, String system){
        svalue = converted(value, system);
    }
    public String converted(String value, String system){
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

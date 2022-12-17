package pl.poznan.put;

import java.io.IOException;

public class Binary implements NumSystem{
    private final String svalue;
    public Binary(String b){
        svalue = b;
    }
    public Binary(String value, String system){
        svalue = converted(value, system);
    }
    public String converted(String value, String system){
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

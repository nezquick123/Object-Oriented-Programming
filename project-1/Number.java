import java.util.Objects;

public class Number {
    String value;
    String system;
    public Number(String s){
        if(s.length()>1 && s.substring(0, 2).equals("0x")) {
            value = s.substring(2);
            system = "hex";
        }
        else if(s.length()>1 && s.substring(0, 1).equals("0")) {
            value = s.substring(1);
            system = "oct";
        }
        else if(s.substring(0, 1).equals("b")) {
            value = s.substring(1);
            system = "bin";
        }
        else {
            value = s;
            system = "dec";
        }

    }
    public Decimal Dec(){
        if (Objects.equals(system, "dec")){
            return new Decimal(Integer.parseInt(value));
        }
        else
        {
            return new Decimal(value, system);
        }
    }

    public HexDec Hex(){
        if (Objects.equals(system, "hex")){
            return new HexDec(value);
        }
        else
        {
            return new HexDec(value, system);
        }
    }

    public Octal Oct(){
        if (Objects.equals(system, "oct")){
            return new Octal(value);
        }
        else
        {
            return new Octal(value, system);
        }
    }

    public Binary Bin(){
        if (Objects.equals(system, "bin")){
            return new Binary(value);
        }
        else
        {
            return new Binary(value, system);
        }
    }
}

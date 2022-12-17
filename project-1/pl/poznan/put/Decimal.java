package pl.poznan.put;

import java.util.Objects;
import java.io.IOException;

import static java.lang.System.exit;

public class Decimal {
    private int svalue;
    public Decimal(int n){
        svalue = n;
    }
    public Decimal(String value,String system){
        try {
            svalue = convertedFrom(value, system);
        }
        catch (IOException ex){
            System.err.println(ex.getMessage());
            exit(1);
        }
    }
    int convertedFrom(String value, String system) throws IOException{
        if(Objects.equals(system, "dec")){
            return Integer.parseInt(value);
        }
        int base = 0;
        if(Objects.equals(system, "hex")){
            base = 16;
        }
        if(Objects.equals(system, "bin")){
            base = 2;
        }
        if(Objects.equals(system, "oct")){
            base = 8;
        }
        //ELSE: EXCEPTION
        int dec = 0;
        int val = 0;
        int neg = 0;
        if(value.charAt(0)=='-')
        {
            neg = 1;
        }
        for(int i = neg; i < value.length(); i++){
            if(base != 16 && Character.getNumericValue(value.charAt(i)) >=base){
                throw new IOException(String.format("Invalid digit in %s value (system: %s))",value, system));
            }
            if(base == 16){
                switch (value.charAt(i)){
                    case 'A':
                        val = 10;
                        break;
                    case 'B':
                        val = 11;
                        break;
                    case 'C':
                        val = 12;
                        break;
                    case 'D':
                        val = 13;
                        break;
                    case 'E':
                        val = 14;
                        break;
                    case 'F':
                        val = 15;
                        break;
                    default:
                        val = Character.getNumericValue(value.charAt(i));
                }
            }
            else {
            val = Character.getNumericValue(value.charAt(i));
            }
            dec += val*java.lang.Math.pow(base, value.length()-i-1);
        }
        if (neg == 1){
            dec*=-1;
        }
        return dec;
    }
    public String convertedTo(String system) throws IOException{
        boolean neg = false;
        if(Objects.equals(system, "hex")){
            int base = 16;
            char[] characters = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
            int value = svalue;
            StringBuilder result = new StringBuilder();

            if(value < 0){
                value*=-1;
                neg = true;
            }

            while (value>=1){
                result.append(characters[value % base]);
                value/=base;
            }
            StringBuilder sb = new StringBuilder(result.toString());
            sb.append("x0");
            if(neg) sb.append('-');
            return sb.reverse().toString();
        }
        else if(Objects.equals(system, "oct")){
            int base = 8;
            char[] characters = {'0','1','2','3','4','5','6','7'};
            int value = svalue;
            StringBuilder result = new StringBuilder();
            if(value < 0){
                neg = true;
                value*=-1;
            }
            while (value>=1){
                result.append(characters[value % base]);
                value/=base;
            }
            StringBuilder sb = new StringBuilder(result.toString());
            sb.append("0");
            if(neg) sb.append('-');
            return sb.reverse().toString();
        }
        else if(Objects.equals(system, "bin")){
            int base = 2;
            char[] characters = {'0','1'};
            int value = svalue;
            StringBuilder result = new StringBuilder();
            if(value < 0){
                neg = true;
                value*=-1;
            }
            while (value>=1){
                result.append(characters[value % base]);
                value/=base;
            }
            StringBuilder sb = new StringBuilder(result.toString());
            sb.append("b");
            if(neg) sb.append('-');
            return sb.reverse().toString();
        }
        else{
            throw new IOException("Invalid number system");
        }
    }
    public int value(){
        return svalue;
    }
}

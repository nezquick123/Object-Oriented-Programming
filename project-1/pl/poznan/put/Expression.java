package pl.poznan.put;

import java.util.Objects;
import java.io.IOException;

import static java.lang.System.exit;

public class Expression {
    private final String expression;
    private int idopen, idclose;

    public Expression(String s) {
        expression = s;
        idopen = 0;
        idclose = s.length() - 1;
    }

    private ValParams valueLen(String expr, int idstart) { //Function returns a Decimal type of number and the length of number given as input
        boolean gotValue = false;
        StringBuilder v = new StringBuilder();
        for (int i = idstart; i < expr.length(); i++) {
            if (!gotValue) {
                if (expr.charAt(i) == '-') {
                    v.append('-');
                }
                if (Character.isDigit(expr.charAt(i)) || expr.charAt(i) == 'b') { //check if it is a first char of a number
                    gotValue = true;
                    v.append(expr.charAt(i));
                    if (i < expr.length() - 1 && expr.charAt(i + 1) == 'x') { //skip x in hexadecimal representation
                        v.append(expr.charAt(i + 1));
                        i += 1;
                    }
                }

            } else {
                if (Character.isDigit(expr.charAt(i))||(expr.charAt(i) >='A'&&expr.charAt(i)<='F')) { //if gotValue is true assign to v
                    v.append(expr.charAt(i));
                } else {
                    break;
                }
            }
        }
        Number n = new Number(v.toString());
        return new ValParams(n.Dec(), v.length());
    }

    boolean isFinal = false;

    private String mostNested(String expr) {//returns the most nested expression
        idopen = 0;
        idclose = expr.length() - 1;
        for (int i = 0; i < expr.length(); i++) {
            if (expr.charAt(i) == '(') idopen = i;
            else if (expr.charAt(i) == ')') {
                idclose = i;
                break;
            }//TODO: EXCEPTIONS IF IDOPEN > IDCLOSE
        }
        if (idopen == 0 && idclose == expr.length() - 1 &&expr.charAt(idopen)!='(') {
            isFinal = true;
            return expr;
        }

        return expr.substring(idopen + 1, idclose);
    }

    public Number calculatedVal() {//main calculating function
        try{
            checkBrackets(expression);
        }
        catch (IOException ex){
            System.err.println(ex.getMessage());
            exit(1);
        }
        String input = expression;
        String partExpr = expression;
        while (!isFinal) {
            try {
                partExpr = mostNested(input);
                validate(partExpr);
                partExpr = multDiv(partExpr);
                partExpr = addSubtr(partExpr);
            }
            catch (IOException ex){
                System.err.println(ex.getMessage());
                exit(1);
            }
            if (!isFinal) {
                input = input.substring(0, idopen) + partExpr + input.substring(idclose + 1);//Delete last bracket;
            }
        }
        if (Objects.equals(partExpr, ""))
            partExpr = expression;
        return new Number(partExpr);
    }

    private String multDiv(String expr) {
        Decimal loperand = new Decimal(0);
        StringBuilder resStr = new StringBuilder();
        boolean used = false;//dealing with single value additions/subtractions
        int res = 1;
        for (int i = 0; i < expr.length(); i++) {
            if (Character.isDigit(expr.charAt(i)) || expr.charAt(i) == 'b') {//assigning the left-operand
                loperand = valueLen(expr, i).dec;
                i += valueLen(expr, i).len;
                res *= loperand.value();
                if (i == expr.length()) {
                    resStr.append(Integer.toString(loperand.value()));
                    res = 1;
                    break;
                }
                used = false;
            }
            if (expr.charAt(i) == '*') {
                Decimal roperand = valueLen(expr, i).dec;
                res *= roperand.value();
                i += valueLen(expr, i).len;
                used = true;
            }
            if (expr.charAt(i) == '/') {
                Decimal roperand = valueLen(expr, i).dec;
                res /= roperand.value();
                i += valueLen(expr, i).len;
                used = true;
            }
            if (expr.charAt(i) == '+' || expr.charAt(i) == '-') {
                if (!used) {//if loperand hasn't been used in any calculation add it to resStr
                    resStr.append(Integer.toString(loperand.value()));
                } else { //add result of the calculation to resStr
                    resStr.append(Integer.toString(res));
                }
                res = 1;
                resStr.append(expr.charAt(i));
            }
        }
        //if (Objects.equals(resStr, ""))
        //    resStr = Integer.toString(res); ////resStr == 0 means that this function have done nothing with input
        if (res != 1) resStr.append(res); //if res hasn't been added yet add it now
        return resStr.toString();
    }

    private String addSubtr (String expr) {
        String resStr = "";
        Decimal loperand;
        int res = 0;
        for (int i = 0; i < expr.length(); i++) {
            if (Character.isDigit(expr.charAt(i)) || expr.charAt(i) == 'b') {
                loperand = valueLen(expr, i).dec;
                res += loperand.value();
                i += valueLen(expr, i).len;
                if (i == expr.length())
                    break;
                ;
            }
            if (expr.charAt(i) == '+') {
                Decimal roperand = valueLen(expr, i + 1).dec;
                res += roperand.value();
                i += valueLen(expr, i + 1).len;
            } else if (expr.charAt(i) == '-') {
                Decimal roperand = valueLen(expr, i + 1).dec;
                res -= roperand.value();
                i += valueLen(expr, i + 1).len;
            }
        }
        resStr = Integer.toString(res);
        if (resStr.length() == 0)//resStr == 0 means that this function have done nothing with input (means that it was single value)
            resStr = expr;
        return resStr;
    }
    private void validate (String expr) throws IOException{

        if((!Character.isDigit(expr.charAt(0))&&expr.charAt(0)!='-'&&(expr.charAt(0)!='b'))||!(Character.isDigit(expr.charAt(expr.length()-1))||(expr.charAt(expr.length()-1) >='A'&&expr.charAt(expr.length()-1)<='F'))){
            throw new IOException(String.format("Invalid character in expression: %s", expr));
        }

        for(int i = 0; i < expr.length()-1; i++){
            if(!(Character.isDigit(expr.charAt(i)) ||(expr.charAt(i) >='A'&&expr.charAt(i)<='F'))&&!(Character.isDigit(expr.charAt(i+1)) ||(expr.charAt(i+1) >='A'&&expr.charAt(i+1)<='F'))&&expr.charAt(i+1)!='-'&& expr.charAt(i+1) != 'b'){
                throw new IOException(String.format("Invalid character in expression: %s", expr));
            }
        }
    }

    private void checkBrackets (String expr) throws IOException{

        int lbrack = 0;
        int rbrack = 0;
        for(int i = 0; i < expr.length(); i++){
            if(expr.charAt(i) == '('){
                lbrack +=1;
            }
            if(expr.charAt(i) == ')'){
                rbrack +=1;
            }
        }
        if(lbrack!=rbrack){
            throw new IOException("Invalid brackets placement");
        }

    }
}

import java.net.SocketOption;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        System.out.println("Number format: <prefix> <value>");
        System.out.println("Examples: 0x12 - hexadecimal, 012 - octal, b10 - binary, 12 - decimal");
        System.out.println("Enter a number or expression to calculate: ");

        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        Expression exp = new Expression(input);
        Number outp = exp.calculatedVal();
        Decimal decout = outp.Dec();
        HexDec hex = outp.Hex();
        Octal oct = outp.Oct();
        Binary bin = outp.Bin();
        System.out.println("Dec: " + decout.value());
        System.out.println("Hex: " + hex.value());
        System.out.println("Oct: " + oct.value());
        System.out.println("Bin: " + bin.value());
    }
}

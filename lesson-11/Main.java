public class Main {
    public static void main(String args[]) {
      Sequence str = new Characters("hahaha");
      System.out.println(str.printedSeq());
      String out1 = str.printedSeq();
      System.out.println(out1);
      
      Sequence str1 = new LowerCased(new Characters("PTCPTCPTCPTC"));
      String out2 = str1.printedSeq();
      System.out.println(out2);
      
      Sequence str2 = new Concatenation(new Characters("AaAaAaAaAa"),str1);
      String out3 = str2.printedSeq();
      System.out.println(out3);
    }
}

public class LowerCased implements Sequence {
    private final Sequence str;
    public String printedSeq() {
        return str.printedSeq().toLowerCase();
    }
    public LowerCased(Sequence st) {
        str=st;
    }

}

public class LowerCased implements Sequence {
    private final Sequence str;
    public String printedSeq() {
        return this.str.printedSeq().toLowerCase();
    }
    public LowerCased(Sequence str) {
        this.str=str;
    }

}

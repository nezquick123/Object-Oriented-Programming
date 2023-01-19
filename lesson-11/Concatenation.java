public class Concatenation implements Sequence {
        private final Sequence first;
        private final Sequence second;
        public String printedSeq() {
            return first.printedSeq()+this.second.printedSeq();
        }
        public Concatenation(Sequence fir, Sequence sec) {
            first= fir;
            second = sec;
        }
    }

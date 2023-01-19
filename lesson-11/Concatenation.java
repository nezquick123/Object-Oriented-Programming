public class Concatenation implements Sequence {
        private final Sequence first;
        private final Sequence second;
        public String printedSeq() {
            return this.first.printedSeq()+this.second.printedSeq();
        }
        public Concatenation(Sequence fir, Sequence sec) {
            this.first= fir;
            this.second = sec;
        }
    }

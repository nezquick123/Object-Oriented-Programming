public interface Forecast{
    int todaysTemp(int day);
    final class Fake implements Forecast{
        @Override
        public int todaysTemp(int day){
            return 20;
        }
        
    }
}
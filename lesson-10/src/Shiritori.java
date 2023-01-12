import javax.swing.table.TableRowSorter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public final class Shiritori {
    private ArrayList<String> words = new ArrayList<String>();
    private boolean gameOver = false;
    public void play(String word){
        if(!gameOver){
        gameOver = !isValid(word);
        if(!gameOver) {
            words.add(word);
            printWords();
        }
        }
        else
            System.out.println("Game has already ended");

    }
    private boolean isValid(String word){
        if(words.size()>1){
            String last_word = words.get(words.size()-1);
            if(last_word.charAt(last_word.length()-1)!=word.charAt(0)) {
                System.out.printf("%s doesn't start with %s%n", word, last_word.charAt(last_word.length()-1));
                return false;
            }
            else {
                for(int i = 0; i < words.size(); i++){
                    if(words.get(i).equals(word)) {
                        System.out.printf("%s has already been used%n", word);
                        return false;

                    }
                }
            }
        }
        return true;
    }
    public void restart(){
        gameOver = false;
        words.clear();
        System.out.println("Game restarted!");
    }
    public void printWords(){
        System.out.println(words);
    }
}

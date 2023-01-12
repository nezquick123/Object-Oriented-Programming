public class Main {
    public static void main(String[] args) {
        Shiritori my_shiritori = new Shiritori();
        my_shiritori.play("apple");
        my_shiritori.play("ear");
        my_shiritori.play("rhino");
        my_shiritori.play("corn") ;
        my_shiritori.printWords();
        my_shiritori.restart();
        my_shiritori.printWords();
        my_shiritori.play("hostess");
        my_shiritori.play("stash");
        my_shiritori.play("hostess");
        my_shiritori.play("something");

    }
}
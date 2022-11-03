#include <iostream>

using namespace std;

class Platform{
private:
    string name[3];
    int count = 3;
public:
    Platform(){
        name[0] = "PC";
        name[1] = "Playstation";
        name[2] = "Xbox";
    }
    void update(string s1){
        name[0] = s1;
        count = 1;
    }
    void update(string s1, string s2){
        name[0] = s1;
        name[1] = s2;
        count = 2;
    }
    void show(){
        for(int i = 0; i < count; i++){
            cout << name [i] << endl;
        }
    }
};

class Game{
private:
    string title;
    string studio;
    string genre;
    int pegi;
    Platform platform;
public:
    Game(string t, string s, string g, int p){
        title = t;
        studio = s;
        genre = g;
        pegi = p;
    }
    Game(string t, string s, string g, int p, string s1){
        title = t;
        studio = s;
        genre = g;
        pegi = p;
        platform.update(s1);
        
    }
        Game(string t, string s, string g, int p, string s1, string s2){
        title = t;
        studio = s;
        genre = g;
        pegi = p;
        platform.update(s1, s2);
    }
    
    void isAvailableOn(){
        cout << "Game is available on: \n";
        platform.show();
    }
};



int main()
{
    Game game("The Witcher 3", "CDProjekt Red", "RPG", 18);
    game.isAvailableOn();

    return 0;
}                                                                                    

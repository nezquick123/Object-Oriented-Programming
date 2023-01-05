#include <iostream>
using namespace std;
class Game{
    virtual string result() = 0;
};

class FakeFootballGame : public Game{
public:
    string result(){
        return "2:0";
    }
};

int main() {
    FakeFootballGame game;
    if(game.result() == "2:0")
        cout << "Test passed!"<<endl;

    return 0;
}

#include <iostream>

using namespace std;

class NumberRelation{
    double a, b;
    public:
    NumberRelation(double n1, double n2){
        a = n1;
        b = n2;   
    }
    double max(){
    return a > b ? a : b;
    }
    
    double min(){
    return a < b ? a : b;
    }
    
    double avg(){
    return (a+b)/2;
    }
};

int main()
{
    NumberRelation nr(5, 12);
    cout << nr.max() << "\n" << nr.min() << "\n" <<nr.avg();

    return 0;
}

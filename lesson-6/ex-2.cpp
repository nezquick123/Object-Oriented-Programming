#include <iostream>
#include <cmath>
using namespace std;

class Number{
    public:
    virtual double doubleValue() = 0;
};
class Logarithm : public Number{
    private:
        double base, argument;
    public:
        double doubleValue(){ 
            if((this -> base <= 0 || this -> base == 1) &&this -> argument <= 0)    
                throw invalid_argument("Invalid base and argument\n");
            if(this -> base <= 0 || this -> base == 1)    
                throw invalid_argument("Invalid base\n");
            if (this -> argument <= 0)
                throw invalid_argument("Invalid argument");
            return log(this->argument) / log(this->base);
        }
        Logarithm(double inputBase, double inputArgument) {
            this -> base = inputBase;
            this -> argument = inputArgument;
        }
};
int main(){   
    Logarithm lg(5, 0);
    try{
    cout <<lg.doubleValue();
    } catch (invalid_argument &ex){
        cerr << ex.what(); 
        return 1;
    }
    
    return 0;
}

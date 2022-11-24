#include <iostream>
#include <map>
#include <sstream>
#include <iomanip>
#include <string>
using namespace std;
class FakeCantor {
 private:
  map<string, float> rates{{"USD", 1.0366f},
                                     {"GBP", 0.87063f},
                                     {"CHF", 0.9881f},
                                     {"JPY", 145.12f}};
 public:
  FakeCantor() = default;
  float EuroToRate(const string &currency) {
    return rates[currency];
  };
};

class Currency {
 public:
  virtual Currency *AddedCurrency(float value, string currency) = 0;
  virtual Currency *SubtractedCurrency(float value, string currency) = 0;
  virtual string Abbreviation() = 0;
  virtual string Symbol() = 0;
  virtual string Balance() = 0;
  virtual float DollarExchangeRate() = 0;
};

class Euro : public Currency {
  // TODO: implement class
    FakeCantor fc;
    string balance = "0";
    Euro(string bal){balance = bal;};
    string Abbreviation(){
        return "EUR";
    }
    string Symbol(){
        return "€";
    }
    string Balance(){
        return balance;
    }
    float DollarExchangeRate(){
        return fc.EuroToRate["USD"];
    }
    Euro* AddedCurrency(float value, string currency){
        float curr = 0;

        curr = fc.EuroToRate[currency];

        float val = stof(balance);
        val += value*(1/curr);
        Euro * e = new Euro(to_string(val));
        return e;
    }
    
    Euro* SubtractedCurrencyCurrency(float value, string currency){
        float curr = 0;
        curr = fc.EuroToRate[currency];
        float val = stof(balance);
        val -= value*(1/curr);
        Euro * e = new Euro(to_string(val));
        return e;
    }
    
};

int main() {
  // TODO: showcase usage
  Euro eur("255");
  Euro * eur2 = eur.AddedCurrency(23.0, "GBP")
  return 0;
}

#include <iostream>

using namespace std;


class Laboratory
{
public:
    int number_of_PCs;
    int number_of_desks;
    string name;
    void parameters(string name, int pc_count, int desk_count){
        this->name = name;
        number_of_desks = desk_count;
        number_of_PCs = pc_count;
    }
    void view(){
    cout << "Number of PCs: " << number_of_PCs << "\nNumber of desks: " << number_of_desks <<"\nClass name" << number_of_desks;
    }
};

class Keyboard
{
public:
  string color;
  string brand;
  string lab_name;
  void parameters(string brand, string color){
  this->brand = brand;
  this->color = color;
  }
  void lab(Laboratory lab){
  lab_name = lab.name;
  }
    void view(){
    cout << "Keyboard specification\nColor: " << color << "\nBrand: " << brand <<"\nIn class:" << lab_name;
    }
};


int main()
{
    Keyboard keyb1;
    Laboratory lab1;
    keyb1.parameters("natec", "black");
    lab1.parameters("L.2.6.21", 16, 16);
    keyb1.lab(lab1);
    keyb1.view();
    return 0;
}

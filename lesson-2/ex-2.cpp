#include <iostream>
using namespace std;

class Phone{
string name;
public:
	Phone(string n){ this->name = n;}
	string phoneName(){
	return this->name;
	}
	
};

class Headphones{
	string brand;
	int price;
	bool isWireless;
	bool isTurnedOn=0;
public:
	Headphones(string br, int p, int w){
		this->brand = br;
		this->price = p;
		this->isWireless = w;
	}
	void connectionViaWiFi(Phone phone){
		if(isWireless){
			cout << "Success! You can connect to "<< phone.phoneName() << endl;
		}
		else{
			cout << "You can't connect via Wifi" << endl;
		}
	}
	
	void turnOn(){
		if(!isTurnedOn)
			isTurnedOn = 1;
	}
	void turnOff(){
		if(isTurnedOn)
			isTurnedOn = 0;
	}
};


int main(){

	Phone phone ("Xiaomi");
	Headphones headph("Sony", 50, 1);
	
	return 0;
};





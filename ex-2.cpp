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


class SandPaper{
	int width;
	int length;
	string material;
	string size;
public:
	SandPaper(int w, int l, string m){
		this->width = w;
		this->length = l;
		this->material = m;
	}
	SandPaper(int w, int l){
		this->width = w;
		this->length = l;
		this->material = "corundum";
	}
	SandPaper(string s, string m){
		this->size = s;
		this->material = m;
	}
	SandPaper(string s){
		this->size = s;
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



//object: sand paper        method: headphones

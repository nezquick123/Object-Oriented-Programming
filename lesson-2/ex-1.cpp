#include <iostream>
using namespace std;

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


int main(){

	return 0;
};



//object: sand paper        method: headphones

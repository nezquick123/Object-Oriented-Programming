#include <iostream>
#include <string>
using namespace std;

class StringChanger{
    public:
        virtual string strWithoutSpaces();
        
}

class Sentence : StringChanger
{
    private:
    string sent;
    int numberOfChars(){
        return sent.length();
    }
    int numberOfWords(){
        int c = 0;
        for(int i = 0; i < charCount(); i++){
            if(sent[i] == ' ' || sent[i] == '\n')
                c++;
                
        return c;
        }
    }
    public:
    Sentence(string s){
        this->sent = s;
    }
    
    string strWithoutSpaces(){
        string newString = "";
        for(int i = 0; i < charCount(); i++){
            if(sent[i] != ' '){
                newString += sent[i];
            }
        return newString;
    }
} 

int main()
{

    return 0;
}

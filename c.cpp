#include<iostream>
#include<string>
using namespace std;
class store{
	string x;
	int ham;
public:
	store(){;}
	void set(string a, int b){
		x = a; ham = b;
	}
	string getString(){
		return x;
	}
	int getHam(){
	return ham;
	}
	void setString(string s){
		x = s ;
	}
};
int check(char ch){
	for(int i=0;i<=25;i++)
		if(int(ch)>i)
			return i;
	return -1;
}
int check1(char ch){
	for(int i=0;i<=25;i++)
		if(int(ch)<i)
			return i;
	return -1;
}
string processString(string s){
		//char[] arr = s.toCharArray();
		int i,k = -1, p =-1;
		for(i =0;i<s.length()-1;i++){
			if(s[i]<s[i+1]){
				k =i;
			}
		}
		/*if(k==-1)
			return null;*/
		for(i =k+1;i<s.length();i++){
			if(s[i]>s[k]){
				p =i;
			}
		}
		char t = s[k];
		s[k] =s[p];
		s[p] = t;
		for(int m = k+1, n = s.length()-1 ; m<n;m++,n--){
			t  = s[m];
			s[m] = s[n];
			s[n] = t;			
		}
		return s;
	}
int main(){
	int t;
	cin>>t;
	store *s = new store[t];
	for(int  i=0;i<t;i++){
		string str;
		int ham;
		cin>>str>>ham;
		s[i].set(str,ham);
	}
	for(int  i=0;i<t;i++){
		string str = s[i].getString();
	}
	int j =0; int change=0;
	for(int  i=0;i<t;i++){
		string str = s[i].getString();
			for(int m =0;change<s[i].getHam()&&m<str.length();m++){
				//cout<<str[m]-'a'<<" str[m]-'a'"<<"\n";
				int temp = check(str[m]-'a');
				if(temp==-1){
					//change--;
					continue;
				}
				else{
				str[m] = temp+'a';
				cout<<"change is here1 "<<change<<"\n";
				change++;
				}
			}
			if(s[i].getHam()- change>0){
		
		    for(int  i=0;i<t;i++){
				string str = s[i].getString();
				/*string str1 = processString(str);
				change++;
				for(;change<s[i].getHam();change++)
					str1 = processString(str1);
				s[i].setString(str1);*/
				//string str = s[i].getString();
			for(int m =str.length()-1;change<s[i].getHam()&&m>=0;m--){
				//cout<<str[m]-'a'<<" str[m]-'a'"<<"\n";
				int temp = check1(str[m]-'a');
				if(temp==-1){
					//change--;
					continue;
				}
				else{
				str[m] = temp+'a';
				cout<<"change is here2 "<<change<<"\n";
				change++;
				}
			}
			cout<<"the string became "<<str<<"\n";
			s[i].setString(str);
			cout<<j<<" j  is \n";
			}
	}
			//s[i].setString(str);
	}	
	for(int  i=0;i<t;i++)
		cout<<s[i].getString()<<"\n";
	return 0;
}
#include<iostream>
#include<math.h>
using namespace std;
int main(){
	int T;
	cin>>T;
	string *fin = new string[T];
	int temp=T;
	while(T-->0){
	int n;
	cin>>n;
	int flag = 0;
	for(int  i =2;i<sqrt(n);i++)
		if(n%i==0){
			flag = 1;
		    break;
		}
	if(flag)
		fin[T] = "no";
	else
		fin[T] = "yes";
	}
	T=temp;
	for(int i=T-1;i>=0;i--)
		cout<<fin[i]<<"\n";
	return 0;
}
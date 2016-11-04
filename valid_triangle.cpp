#include<iostream>
#include <iomanip>
#include<stdio.h>
using namespace std;
int main(){
	int T;
	cin>>T;
	string *fin = new string[T];
	int temp=T;
	while(T-->0){
	int a,b,c;
	cin>>a>>b>>c;
	if(a<=0||b<=0||c<=0)
		fin[T] = "NO";
	else if(a+b+c==180)
		fin[T] = "YES";
	else
		fin[T] = "NO";
	}
	T=temp;
	for(int i=T-1;i>=0;i--)
		cout<<fin[i]<<"\n";
	return 0;
}
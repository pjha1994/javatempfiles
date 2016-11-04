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
	char c;
	cin>>c;
	if(c=='b' ||c == 'B')
		fin[T] = "BattleShip";
	else if(c=='c' || c =='C')
		fin[T] = "Cruiser";
	else if(c=='d'||c=='D')
		fin[T] = "Destroyer";
	else
		fin[T] = "Frigate";
	
	}
	T=temp;
	for(int i=T-1;i>=0;i--)
		cout<<fin[i]<<"\n";
	return 0;
}
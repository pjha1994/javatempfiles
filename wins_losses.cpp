#include<iostream>
#include <iomanip>
#include<stdio.h>
using namespace std;
int pow(int n){
	int  p =1;
	for(int i=0;i<n;i++)
		p*=10;
	return p;
}
int main(){
	int T;
	cin>>T;
	string *fin = new string[T];
	int temp=T;
	while(T-->0){
	int n;
	cin>>n;
	int t = n;
	int c =0;
	while(t!=0){
		t = t/10;
		c++;
	}
	int  m =n,  p =n, flag = 0, t1 = c-1;
	for(int i = 0;i<=c/2;i++){
		int a = pow(t1--);
		if(m/a!=p%10){
			flag = 1;
			break;
		}
		m = m - (m/a)*a;
		p = p / 10;
	}
	if(flag)
		fin[T] = "losses";
    else
		fin[T] = "wins";
	}
	T=temp;
	for(int i=T-1;i>=0;i--)
		cout<<fin[i]<<"\n";
	return 0;
}
#include<iostream>
#include <iomanip>
#include<stdio.h>
using namespace std;
int main(){
	int T;
	cin>>T;
	float *fin = new float[T];
	int temp=T;
	while(T-->0){
	int n;
	cin>>n;
	int sum = 0;
	while(n!=0){
		if(n%10==4)
			sum++;
		n = n/10;
	}
	fin[T] = sum;
	}
	T=temp;
	for(int i=T-1;i>=0;i--)
		cout<<fin[i]<<"\n";
	return 0;
}
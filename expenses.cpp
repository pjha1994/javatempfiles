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
	float q,p;
	cin>>q>>p;
	float sum = q*p;
	if(q>=1000)
		sum = sum - (10.0/100)*sum;
	fin[T] = sum;
	}
	T=temp;
	for(int i=T-1;i>=0;i--)
		printf("%.6f\n",fin[i]);
	return 0;
}
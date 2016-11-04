#include<iostream>
#include<math.h>
using namespace std;
int main(){
	int T;
	cin>>T;
	unsigned long long int *fin = new unsigned long long int[T];
	int temp=T;
	while(T-->0){
		unsigned long long int n;
		cin>>n;
		unsigned long long int sum = 0;
		for(unsigned long long int j = 1;j<n;j++)
			if((j!=n)&&((j^n) == j + n))
				sum++;
		fin[T]=sum;
	}
	T=temp;
	for(int i=T-1;i>=0;i--)
		cout<<fin[i]<<"\n";
	return 0;
}
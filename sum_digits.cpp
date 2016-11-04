#include<iostream>
using namespace std;
int main(){
	int T;
	cin>>T;
	int *fin = new int[T];
	int temp=T;
	while(T-->0){
		int n;
		cin>>n;
		int k = 0;
		while(n!=0){
			k = k + n%10;
			n = n/10;
		}
		fin[T] = k;
	}
	T=temp;
	for(int i=T-1;i>=0;i--)
		cout<<fin[i]<<"\n";
	return 0;
}
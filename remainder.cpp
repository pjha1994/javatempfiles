#include<iostream>
using namespace std;
int main(){
	int T;
	cin>>T;
	int *fin = new int[T];
	int temp=T;
	while(T-->0){
		int a,b;
		cin>>a>>b;
		fin[T] = a%b;
	}
	T=temp;
	for(int i=T-1;i>=0;i--)
		cout<<fin[i]<<"\n";
		return 0;
}
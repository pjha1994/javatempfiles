#include<iostream>
using namespace std;
int gcd1(int a,int b){
	return b==0?a:gcd1(b,a%b);
}
int main(){
	int T;
	cin>>T;
	int *gcd = new int[T];
	int *lcm = new int[T];
	int temp=T;
	while(T-->0){
		int a,b;
		cin>>a>>b;
		gcd[T] = gcd1(a,b);
		lcm[T] = (a*b)/gcd[T];
	}
	T=temp;
	for(int i=T-1;i>=0;i--)
		cout<<gcd[i]<<" "<<lcm[i]<<"\n";
	return 0;
}
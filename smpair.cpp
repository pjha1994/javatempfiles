#include<iostream>
using namespace std;
int gcd1(int a,int b){
	return b==0?a:gcd1(b,a%b);
}
int main(){
	int T;
	cin>>T;
	int temp=T;
	int *fin = new int[T];
	while(T-->0){
		int n;
		cin>>n;
		int *arr = new int[n];
		for(int i=0;i<n;i++)
			cin>>arr[i];
		int sum = arr[0]+arr[1];
		for(int i=0;i<n-1;i++)
			if(arr[i]+arr[i+1]<sum)
				sum = arr[i]+ arr[i+1];
		fin[T] = sum;
	}
	T=temp;
	for(int i=T-1;i>=0;i--)
		cout<<fin[i]<<"\n";
	return 0;
}
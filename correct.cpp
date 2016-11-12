#include<iostream>
using namespace std;
int main(){
	int n;
	cin>>n;
	
	int a , sum = 0;
	cin>>a;
	if(a!=1)
		sum++;
	for(int i=0;i<n-1;i++){
		int b;
		cin>>b;
		if(b!= a+1)
			sum++;
		a = b;
	}
	cout<<sum;
	return 0;
}
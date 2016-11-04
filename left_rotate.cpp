#include<iostream>
using namespace std;
int main(){
    ios_base::sync_with_stdio(false);
	int n,temp,d;
	cin>>n>>d;
	int *a = new int[n];
	for(int i =0;i<n;i++){
		cin>>temp;
		a[(i+n-d)%n] = temp;
	}
	return 0;
}
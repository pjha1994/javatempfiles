#include<iostream>
using namespace std;
int main(){
	unsigned long long int arr[5], min = 101000000000, max = 0;
	for(int i=0;i<5;i++)
		cin>>arr[i];
	int k =0;
	la:
	unsigned long long int temp =0;
	for(int i=0;i<5;i++){
		if(i!=k)
			temp = temp + arr[i];
	}
	k++;
	if(temp<min)
		min = temp;
	if(temp>max)
		max = temp;
	if(k<5)
		goto la;
	cout<<min<<" "<<max<<"\n";
	return 0;
}
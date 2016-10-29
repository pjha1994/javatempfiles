#include<iostream>
using namespace std;
void rotate(int arr[], int n){
    int temp = arr[0];
	for(int  i=0;i<n-1;i++)
		arr[i] = arr[i+1];
	arr[n-1]=temp;
}
void print(int arr[],int n){
	for(int  i =0;i<n;i++)
		cout<<arr[i]<<" ";
	cout<<"\n";
}
int main(){
	int n,temp;
	cin>>n;
	int *a = new int[n];
	int *b = new int[n];
	for(int i =0;i<n;i++){
		cin>>temp;
		a[i] = temp;
	}
	for(int i =0;i<n;i++){
		cin>>temp;
		b[i] = temp;
	}
	int min = 0;
	for(int  i=0;i<n;i++)
		min = min + a[i]*b[i];
	for(int  i=0;i<n;i++){
		rotate(b,n);
		//print(b,n);
		int t = 0;
		for(int  i=0;i<n;i++){
		
		t = t + a[i]*b[i];
		}
		if(t<min)
			min  = t;
	}
	for(int  i=0;i<n;i++){
		rotate(a,n);
		//print(a,n);
		int t = 0;
		for(int  i=0;i<n;i++){
		
		t = t + a[i]*b[i];
		}
		if(t<min)
			min  = t;
	}
	/*for(int  i=0;i<n;i++){
		rotate(a,n);rotate(b,n);
		//print(a,n);print(b,n);
		int t = 0;
		for(int  i=0;i<n;i++){
		t = t + a[i]*b[i];
		}
		if(t<min)
			min  = t;
	}*/
	cout<<min;
	return 0;
}
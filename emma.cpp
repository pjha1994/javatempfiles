#include<iostream>
#include<math.h>
using namespace std;
int main(){
	ios_base::sync_with_stdio(false);
	long long int a,b;
	cin>>a>>b;
	long long int n;
    //cin>>n;
	long long int min_max_sum = 0;
	while(a<=b){
		n = a;
		long long int  k =n;
		long long int y = k, c =0;
		while(y!=0){
			c++;
			y = y/10;
		}
		long long int  p = k;
		long long int *arr = new long long int[c];
		long long int  m =1;
		for(int i =c-1;i>=0&&p!=0;i--){
			arr[i] = p%int(pow(10,m));
			p = p/10;
		}
		for(int i =1;i<c-1;i++)
			if(arr[i]<arr[i-1] && arr[i]<arr[i+1])
				min_max_sum++;
			else if(arr[i]>arr[i-1] && arr[i]>arr[i+1])
				min_max_sum++;
		a++;
		delete[] arr;
	}
	cout<<min_max_sum<<"\n";
    /*for(int i=0;i<c;i++)
      cout<<arr[i]<<" ";*/		
	return 0;
}
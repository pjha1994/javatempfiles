#include<iostream>
#include<math.h>
using namespace std;
int main(){
	int n,m;
	cin>>n>>m;
	int *a = new int[n];
	int *b = new int[m];
	int max_a = 0;
	int min_b = 10000;
	for(int i=0;i<n;i++){
		cin>>a[i];
		if(a[i]>max_a)
			max_a = a[i];
	}
	
	for(int i=0;i<m;i++){
		cin>>b[i];
		if(b[i]<min_b)
			min_b = b[i];
	}
	int num =0;
	int x = max_a;
	m:
	int flag = 0;
	for(int i=0;i<n;i++){
		if(x%a[i]==0){
			flag = 1;
		}
		else{
			flag = 0;
			break;
		}
	}
	int flag1 = 0;
	for(int i=0;i<m;i++){
		if(flag){
			if(b[i]%x==0){
				flag1 = 1;
			}
			else{
				flag1 = 0;
				break;
			}
		}
	}
	if(flag1)
		num++;
    if(x<min_b){
		x++;
		goto m;
	}
	cout<<num<<"\n";
	return 0;
}
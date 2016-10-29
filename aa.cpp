#include<iostream>
#include<math.h>
using namespace std;
int main(){
    int n;
	cin>>n;
	int  k =n;
x:
	k++;
	int y = k, c =0;;
	while(y!=0){
		c++;
		y = y/10;
	}
	int  p = k;
	int *arr = new int[c];
	int  m =1;
	for(int i =0;i<c&&p!=0;i++){
		arr[i] = p%int(pow(10,m));
		p = p/10;
	}
	for(int i =0;i<c;i++){
		if(arr[i]==0)
			goto x;
		for(int  j=i+1;j<c;j++)
			if(arr[i] == arr[j]){
				goto x;
			}
	}
	cout<<k<<"\n";
	return 0;
}
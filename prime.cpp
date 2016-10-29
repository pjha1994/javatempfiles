#include<iostream>
#include<math.h>
using namespace std;
int main(){
	int n;
	cin>>n;
	
	int  l =n+1;
	x:
	int k = l, c =0;;
	while(k!=0){
		c++;
		k = k/10;
	}
	int  p = l;
	int *arr = new int[c];
	int  m =1;
	for(int i =0;i<c&&p!=0;i++){
		arr[i] = p%int(pow(10,m));
		p = p/10;
	}
	int flag1  = 1;
	
	for(int  i =0, j =c-1;i<c/2;i++,j--){//checking plaindrome
		if(arr[i]!=arr[j])
			flag1=0;
	}
	for(;;){
		int flag = 1;
		for(int  i = 2;i<int(sqrt(l));i++){
			if(l%i == 0){
				flag = 0;
				break;
			}
		}
		if(flag)
			break;
		l++;
		goto x;
	}
	qq:
	if(flag1){
		cout<<l;
		
	}
	else{
		l++;
		goto x;
	}
	return 0;
}
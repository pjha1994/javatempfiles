#include<iostream>
using namespace std;
int main(){
	int T;
	cin>>T;
	int *fin = new int[T];
	int temp=T;
	while(T-->0){
		int a,b,c;
		cin>>a>>b>>c;
		int  k = a;
		if(a>b && a>c){
			if(b>c)
				k = b;
			else
				k = c;
		}
		else if(b>a && b>c){
			if(a>c)
				k = a;
			else 
				k = c;
		}
		 else if(c>a && c>b){
			 if(a>b)
				  k = a;
			  else
				  k = b;
		 }
		fin[T] = k;
	}
	T=temp;
	for(int i=T-1;i>=0;i--)
		cout<<fin[i]<<"\n";
	return 0;
}

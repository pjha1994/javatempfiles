#include<iostream>
#include<math.h>
using namespace std;
int main(){
	int q;
	cin>>q;
	int *fin = new int[q];
	for(int i=0;i<q;i++){
		int a,b,d;
		cin>>a>>b>>d;
		if(d<a && d<b && d!=0){
			int max = a>b?a:b;
			int min = a<b?a:b;
			for(int j =0;;j++){
				if(sqrt((d/2)*(d/2)+i*i) + sqrt((d/2-1)*( d/2-1)+i*i) == min ||sqrt((d/2)*(d/2)+i*i) + sqrt((d/2-1)*( d/2-1)+i*i)==max){
					fin[i] = 2;
					break;
				}
				
			}
		}
		if(d>a &&d>b){
			int max = a>b?a:b;
			int min = a<b?a:b;
			int k1 = d/max;
			int k2 = (d-max*k1)/min;
			if(k1*max+k2*min==d)
				fin[i] = k1+k2;
		}
		else if(d==0)
			fin[i] = 0;
			
	}
	for(int i=0;i<q;i++)
		cout<<fin[i]<<"\n";
	return 0;
}
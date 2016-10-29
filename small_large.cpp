#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;


int main() {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */   
	
	int N,Q;
	cin>>N>>Q;
	int *array = new int[N];
	int *fin = new int[Q];
	for(int i =0;i<N;i++)
		cin>>array[i];
	for(int i=0;i<Q;i++){
		int X,Y,type;
		cin>>X>>Y>>type;
		int m=0;
		while(X>array[m]&&m<N)
			m++;
		if(type == 0&&array[m-1]<X &&array[m]>X)
			m--;
		if(type == 1&&array[m]<X &&array[m+1]>X)
			m++;
		if(type==0){
			if(m+Y<N)
				fin[i] = array[m+Y];
			else
				fin[i] = -1;
		}
		else{
			if(m-Y>=0 && m-Y<N)
				fin[i] = array[m-Y];
			else
				fin[i] = -1;
		}
	}
	for(int i=0;i<Q;i++)
		cout<<fin[i]<<"\n";
    return 0;
}

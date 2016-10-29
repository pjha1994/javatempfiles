#include <iostream>
using namespace std;
int main() {
    int N, U;
	cin>>N>>U;
	int *array = new int[N];
	for(int  i=0;i<N;i++)
		array[i] = 0;
	for(int i=0;i<U;i++){
		int a,b;
		cin>>a>>b;
		for(int x = 0;(a*x+b-1)<N;x++)
			array[a*x+b-1]++;	
	}
	for(int i=0;i<N;i++)
		cout<<array[i]<<" ";
	
    return 0;
}
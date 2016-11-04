#include<iostream>
#include<math.h>
using namespace std;
int main(){
    int t;
    cin >> t;
	unsigned long long int *fin = new unsigned long long int[t];
    for(int a0 = 0; a0 < t; a0++){
        long n;
        cin >> n;
		unsigned long long int a = 1, b= 2;
		unsigned long long int sum = 0;
		for(;b<=n;){
			//int k = b;
			if(b%2==0)
				sum += b;
			int k =a;
			a = b;
			b = b+k;
		}
		fin[a0] = sum;
    }
	for(int a0 = 0; a0 < t; a0++)
		cout<<fin[a0]<<"\n";
    return 0;
}

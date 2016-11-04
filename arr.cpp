#include<iostream>
using namespace std;
int main(){
	int T;
	cin>>T;
	string *fin = new string[T];
	for(int i=0;i<T;i++){
		int N;
		cin>>N;
		int *array = new int[N];
		for(int k=0;k<N;k++)
			cin>>array[k];
		int left =0, right = 0;
		for(int m=1;m<N;m++){
			left+=array[m-1];
		for(int j=m+1;j<N;j++)
			right+=array[j];
		cout<<"left is "<<left<<" right is "<<right<<"\n";
		}
		if(left==right)
			fin[i] = "YES";
		else
			fin[i] = "NO";
	}
	for(int i=0;i<T;i++)
		cout<<fin[i]<<"\n";
	return 0;
}
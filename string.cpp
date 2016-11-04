#include<iostream>
#include<math.h>
using namespace std;
int main(){
	string a,b;
	cin>>a>>b;
	int k;
	cin>>k;
	int q =0;
	for(int i=0;i<a.length();i++)
		if((i<b.length())&&a[i]==b[i])
			q++;
		else
			break;
	int p1 = a.length() - q;
	int p2 = b.length() - q;
	//cout<<p1+p2<<"\n";
	int max = a.length()>b.length()?a.length():b.length();
	int min = a.length()<b.length()?a.length():b.length();
	if((p1+p2-k)%2==0)
		cout<<"Yes";
	else if(k>=p1+p2)
		cout<<"Yes";
	else if(a.compare(b)==0 && k>=a.length())
		cout<<"Yes";
	else if(p1+p2==0&&k>=2*max)
		cout<<"Yes her";
	else if(k>=2*max)
		cout<<"Yes her1";
	else if(p1+p2>=k)
		cout<<"Yes her2";
	else
		cout<<"No";
	return 0;
}
#include<iostream>
#include<math.h>
using namespace std;
long long int factorial(long long int x){
	if(x==0)
		return 1;
	else
		return x*factorial(x-1);
}
long long int factorial1(long long int x){
	long long int p =1;
	for(long long int i =1;i<=x;i++)
		p = p*i;
	return p;
}
char res[200000];
inline int fact(int n)
{
    int i,j;
    register int m,c;
    m=1;
    res[0]='1';
    for(i=2;i<=n;i++)
    {
        c=0;

        for(j=0; j< m; j++){

            c =((res[j]-48)*i)+c;

            res[j]=(c%10)+48;

            c=c/10;

        }
        while(c>0){
            res[m]=(c%10)+48;

            c=c/10;

            m++;

        }
    }
    return m;
}

int main(){
	int n;
	cin>>n;
	/*long long *input = new long long[n];
	for(int i =0;i<n;i++)
		cin>>(input[i]);
	for(int i =0;i<n;i++)
		input[i] = input[i]/2;
	long long int *fin = new long long int[n];
	for(int i =0;i<n;i++)
		fin[i] = 0;
	for(int i =0;i<n;i++){
		int  k =input[i];
		int sum =0;
		for(int j =1;j<=k;j++){
			//cout<<"finding for "<<j<<"\n";
			int temp1 = factorial1(2*j);
			int temp2 = factorial1(j+1);
			int temp3 = factorial1(j);
			//sum+= (temp1/(temp2*temp3));
			cout<<" number is "<<temp1/(temp2*temp3)<<"\n";
			fin[i] += (temp1/(temp2*temp3));
			//cout<<"catlan number is "<<fin[i]<<"\n";
		}
		
	}
	for(int i=0;i<n;i++)
		cout<<fin[i]<<"\n";*/
	int d = fact(4000);
	unsigned long long int num = 0;
	unsigned long long int  p =1;
	for(int i=d-1;i>=0;i--){
      num = num + p*(res[i]-'0');
	  p*=10;
	}
        //printf("%c",res[i]-'0');
		cout<<num<<"\n";

	return 0;
}
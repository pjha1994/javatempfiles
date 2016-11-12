#include<iostream>
using namespace std;
int z = 1000;
string check(int *arr[z],int m,int n,int k){
	int horX = 0, horO = 0;
	int m1 =0;
	for(int i=0;i<n;i++){
		int temp=0;
		for(int j=0;j<m;j++)
			if(arr[i][j]!='O')
				//horO = 1;
			    break;
			else
				temp++;
		//if(!horO)
		//	break;
		//horO = 0;
		if(temp>m1)
		   m1 =temp;
	}
	int m2 =0;
	for(int i=0;i<n;i++){
		int temp=0;
		for(int j=0;j<m;j++)
			if(arr[i][j]!='X')
				//horX = 1;
			    break;
			else
				temp++;
		//if(!horX)
		//	break;
		//horX = 0;
		if(temp>m2)
		   m2 =temp;
	}
   int verX = 0, verY =0;
   int m3 =0;
   for(int i=0;i<n;i++){
	   int temp=0;
		for(int j=0;j<m;j++)
			if(arr[j][i]!='O')
				//verO = 1;
			    break;
			else
				temp++;
		//if(!verO)
		//	break;
		//verO = 0;
		if(temp>m3)
		   m3 =temp;
	}
	int m4 =0;
	for(int i=0;i<n;i++){
		int temp =0;
		for(int j=0;j<m;j++)
			if(arr[j][i]!='X')
				//verX = 1;
			    break;
			else
				temp++;
		//if(!verX)
		//	break;
		//verX = 0;
		if(temp>m4)
		   m4 =temp;
	}
    int diagX =0, diagO =0;
	int m5 =0;
    for(int i=0,j=0;i<n&&j<m;i++,j++){
			if(arr[i][j]!='O')
				//diaO = 1;
			    break;
			else
				m5++;
	}
	int m6 =0;
	for(int i=0,j=0;i<n&&j<m;i++,j++){
			if(arr[i][j]!='X')
				//diagX = 1;
			    break;
			else
				m6++;
	}
	int m7 =0;
	for(int i=0,j=m-1;i<n&&j>=0;i++,j--){
			if(arr[i][j]!='O')
				//diaO = 1;
			    break;
			else
				m7++;
	}
	int m8=0; 
	for(int i=0,j=m-1;i<n&&j>=0;i++,j--){
			if(arr[i][j]!='X')
				//diagX = 1;
			    break;
			else
				m8++;
	}
	if(m1==m2 || m3 == m4|| m5 == m6 || m7==m8)
		return "none";
	else if(m1>=k || m3 >=k||m5>=k || m7>=k)
		return "WIN";
	else if(m2>=k || m4 >=k||m6>=k || m8>=k)
		return "Lose";
}
int main(){
	int g;
	cin>>g;
	string *fin = new string[g];
	for(int i=0;i<g;i++){
		int n,m,k;
		cin>>n>>m>>k;
		
		int *arr[] = new int[n][m];
		for(int i=0;i<n;i++)
			for(int j=0;j<m;j++)
				cin>>arr[i][j];
		fin[i] = check(m,arr,n,k);
		
	}
	for(int i=0;i<g;i++)
		cout<<fin[i]<<"\n";
	return 0;
}
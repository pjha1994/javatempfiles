#include<iostream>
#include<math.h>
using namespace std;
int findLast(string s,char c,int t){
		for(int i=s.length()-1;i>t;i--)
			if(c==s[i])
				return i;
		return -1;
	}
int main(){
		int T ;
		cin>>T;
		int *fin = new int[T];
		for(int i =0;i<T;i++){
			string s;
			cin>>s;
			char q = s[0];
			int min=s.length();
			int flag = 0;
			for(int j=0;j<s.length();j++){
				int first = s[j];
				int last = findLast(s,s[j],j);
				if(last==-1)
					continue;
				else if(j+s.length()-1-last<min){
					flag = 1;
					min = j+s.length()-1-last;
					//break;
				}
			}
			if(flag ==0)
				min = -1;
			fin[i]=min;
		}
		for(int i =0;i<T;i++)
			cout<<fin[i]<<"\n";
	}
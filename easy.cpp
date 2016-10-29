#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;


int main() {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    int t;
    cin>>t; 
    string *fin = new string[t];
    for(int i=0;i<t;i++){
        int x, y;
        cin>>x>>y;
        int temp = -1;
        for(int j =0;j<x;j++){
            int temp1;
            cin>>temp1;
            if(temp1>temp)
                temp=temp1;
        }
        if(temp%y==0)
               fin[i] = "YES";
        else
            fin[i] = "NO";
    }
	fflush(stdin);
    for(int i=0;i<t;i++)
        cout<<fin[i]<<"\n";
    return 0;
}
/*#include <map>
#include <set>
#include <list>
#include <cmath>
#include <ctime>
#include <deque>
#include <queue>
#include <stack>
#include <string>
#include <bitset>
#include <cstdio>
#include <limits>

#include <climits>
#include <cstring>
#include <cstdlib>
#include <fstream>
#include <numeric>
#include <sstream>

#include <algorithm>
#include <unordered_map>*/
#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

int main(){
    string time;
    cin >> time;
	int *a = new int[time.length()];
	for(int  i =0;i<time.length();i++)
		a[i] = int(time[i])-'0';
	int hr = a[0]*10+a[1];
	int min = a[3]*10+a[4];
	int sc = a[6]*10 + a[7];
	if(time[time.length()-2]=='A' and time[time.length()-1]=='M'){
		if(hr==12) hr = 12-hr;
		if(sc ==0&& min == 0 && hr==0){
			cout<<"00"<<":"<<"00"<<":"<<"00"; return 0;
		}
		if(hr>10)
		{
	    if(min<10&&sc<10){cout<<hr<<":0"<<min<<":0"<<sc; return 0;}
		else if(min>10&&sc<10){cout<<hr<<":"<<min<<":0"<<sc; return 0;}
		else if(min<10&&sc>10){cout<<hr<<":0"<<min<<":"<<sc; return 0;}
		else {cout<<hr<<":"<<min<<":"<<sc; return 0;}
	    }
		else
		{
		if(min<10&&sc<10){cout<<"0"<<hr<<":0"<<min<<":0"<<sc; return 0;}
		else if(min>10&&sc<10){cout<<"0"<<hr<<":"<<min<<":0"<<sc; return 0;}
		else if(min<10&&sc>10){cout<<"0"<<hr<<":0"<<min<<":"<<sc; return 0;}
		else {cout<<"0"<<hr<<":"<<min<<":"<<sc; return 0;}
		}
	}
	else
	{
		/*if(hr ==23 &&min == 59 && sc ==59){
			cout<<00<<":"<<00<<":"<<00;return 0;
		}*/
		/*if(sc ==0&& min == 0 && hr==12){
			cout<<hr<<":"<<00<<":"<<00; return 0;
		}*/
		
		if(hr>0 &&hr<12){
			hr = hr + 12;
		}
	}
		
	//cout<<time[time.length()-2]<<" "<<time[time.length()-1];

    return 0;
}
/*int main(){
    int n;
    cin >> n;
    for(int  i = 1; i<=n;i++){
        for(int  j = n-i;j>0;j--)
            cout<<" ";
		for(int  j =1;j<=i;j++)
			cout<<"#";
        cout<<"\n"; 
   }
    return 0;
}
*/

/*int main(){
    int n;
    cin >> n;
    //vector< vector<int> > a(n,vector<int>(n));
    //int *a[] = new int[n][n];
    int** a = new int*[n];
    for (int i = 0; i < n; ++i)
        a[i] = new int[n];
    for(int a_i = 0;a_i < n;a_i++){
       for(int a_j = 0;a_j < n;a_j++){
          cin >> a[a_i][a_j];
       }
    }
    int s1 = 0;
    for(int a_i = 0;a_i < n;a_i++){
       for(int a_j = 0;a_j < n;a_j++){
           if(a_i  == a_j)
                  s1 = s1 + a[a_i][a_j];
       }
    }
    int s2 = 0;
    for(int a_i = n-1, a_j = 0;a_i >= 0&&a_j < n;a_i--,a_j++){
                  s2 = s2 + a[a_i][a_j];
    }
	int k =s1-s2;
	if(k<0)
		k = -k;
    cout<<k;
	for (int i = 0; i < rows; ++i)
		delete [] matrix[i];
	delete [] matrix;
    return 0;
}*/

/*
#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;


int main(){
    int n;
    cin >> n;
    vector<int> arr(n);
    for(int arr_i = 0;arr_i < n;arr_i++){
       cin >> arr[arr_i];
    }
    unsigned long int sum = 0;
    for(int arr_i = 0;arr_i < n;arr_i++)
        sum = sum + arr[arr_i];
    cout<<sum;
    return 0;
}
*/
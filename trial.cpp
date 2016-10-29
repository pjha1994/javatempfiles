#include<iostream>
//#include<vector>
using namespace std;
int main()
{
	
	int test_case;
	cin >> test_case;
	//vector<int>p(test_case);
	int *p = new int[test_case];
	for (int i = 0; i < test_case; i++){
		//int n, 
		int s = 0;
		//cin >> n;
		while (char c = getc(stdin) != '\n'){
			cout<<int(c)-'0'<<" ";
			s = s + int(c)-'0';
		}
			//n = n / 10;
		p[i] = s;
	}
	for (int i = 0; i < test_case;i++)
		cout << "\n" << p[i];
	//getchar(); getchar();
	return 0;
}
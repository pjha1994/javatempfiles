#include<iostream>
#include <vector>
using namespace std;
int main(){
       // Scanner scan = new Scanner(System.in);
		int T;
		cin>>T;
		std::vector<char*> arr();
		std::vector<int> a;
		//ArrayList<String> arr = new ArrayList<String>();
		//ArrayList<Integer> a = new ArrayList<Integer>();
		for(int i =0;i<T;i++){
			char *s;
			cin>>s;
			arr.push_back(s);
		}
		for(int i =0;i<T;i++){
			//char *array = arr[i];
			int length = 0;
			while(arr[i]>='a'&&arr[i]<='z')
				length++;
			int flag = 0;
			for(int  j =0;j<length;j++){
				for(int k = j+1;j<length;j++)
					if(arr[j]!=arr[k]){
						flag = 1;
						break;
					}
				if(flag)
					break;
			}
			if(flag)
				cout<<length<"\n";
			else
				cout<<1<<"\n";
		}
    }
/*class family{
private:
	char food;
    int	sleep;
public:
	family(){;}
	void setfood(char food){
		this->food  = food;
	}
	void setsleep(int sleep){
		this->sleep = sleep;
	}
	char getfood(){
		return this->food;
	}
	int getsleep(){
		return this->sleep;
	}
};
int main(){
	int N;
	cin>>N;
	family *arr  = new family[N];
	char *ch = new char[N];
	char *it = new char[N];
	for(int  i =0;i<N;i++){
		cin>>ch[i];
	}
	
	for(int  i =0;i<N;i++){
		cin>>it[i];
	}
	for(int i =0;i<N;i++){
		arr[i].setfood(ch[i]);
		arr[i].setsleep(int(it[i])-'0');
	}
	delete[]ch;
	delete[]it;
	int queries = 0;
	cin>>queries;
	int *res = new int[queries];
	for(int  k =0 ;k<queries;k++)
	{ int L,R;
      cin>>L>>R;
	int special  = 0;
	for(int  i =L-1;i<R;i++)
		for(int  j = i+1;j<R;j++){
			if((arr[i].getfood() == arr[j].getfood())||(arr[i].getsleep() == arr[j].getsleep())) 
				special++;
		}
		res[k] = special;
	}
	for(int i =0;i<queries;i++)
		cout<<res[i]<<"\n";
	delete[]res;
	delete[]arr;
	return 0;
}*/
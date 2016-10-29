#include<iostream>
class val{
private:	int s, e;
public:
	void sets(int start){
		s = start;
	}
	void sete(int end){
		e = end;
	}
	int gets(){
		return s;
	}
	int gete(){
		return e;
	}
	int f(int a, int b){
		
		if(a<=s && b>=e){
			return 1;
		}
		else
			return 0;
	}
};
int main(){
	int N, Q;;
	std::cin>>N>>Q;
	val v[N];
	
	for(int i =0;i<N;i++)
	{
		int a ,b;
		std::cin>>a>>b;
		v[i].sets(a);
		v[i].sete(b);
	}
	int array[Q];
	int A=0 ,B=0 ,X=0 ,Y=0;
		for(int i =0;i<Q;i++){
			std::cin>>A>>B>>X>>Y;
			
			int s = 0;
			for(int j = X;j<=Y;j++){
				
				s = s +v[j].f(A,B);
			}
			array[i]=s;
		}
		for(int i =0;i<Q;i++)
			std::cout<<array[i]<<'\n';
		return 0;
}

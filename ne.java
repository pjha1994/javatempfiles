import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import static java.lang.System.out;
class Solution17{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int N = 0;
		int Q = 0;
		N = scan.nextInt();
		Q = scan.nextInt();
		
		val[] a = new val[N];
		for(int i =0;i<N;i++){
				 int q=scan.nextInt(); int w=scan.nextInt();
				 a[i] = new val(q,w);
			}
		
	    ArrayList<Integer> p = new ArrayList<Integer>();
		int A=0 ,B=0 ,X=0 ,Y=0;
		for(int i =0;i<Q;i++){
			A = scan.nextInt(); B = scan.nextInt();
			X = scan.nextInt(); Y = scan.nextInt();
			
			int s = 0;
			for(int j = X;j<=Y;j++){
				
				s = s +a[j].f(A,B);
			}
			p.add(s);
		}
		for(int i =0;i<Q;i++)
			out.println(p.get(i));
	}
}

class val{
	int s, e;
	val(int start, int end){
		s = start; e = end;
	}
	int getss(){
		return s;
	}
	int getee(){
		return e;
	}
	int f(int a, int b){
		
		if(a<=s && b>=e){
			return 1;
		}
		else
			return 0;
	}
}
import java.io.*;
import java.util.*;
class x{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		ArrayList<Integer> array = new ArrayList<Integer>();
		for(int i =0;i<T;i++){
		int n= scan.nextInt();
		int sum = 0;
		for(int j = 1;j<n;j++)
			if((j^n) == j + n)
				sum++;
		array.add(new Integer(sum));
		}
		for(int i =0;i<T;i++)
			System.out.println(array.get(i));
	}
}
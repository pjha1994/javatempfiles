import java.io.*;
import java.util.*;
class x{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		ArrayList<Integer> array = new ArrayList<Integer>();
		for(int i =0;i<T;i++){
			String s = scan.next();
			char[] arr = s.toCharArray();
			char q = arr[0];
			int index = 0;
			int min=0;
			int flag = 0;
			for(int j=0;j<arr.length;j++){
				int first = arr[j];
				int last = findLast(arr,arr[j],j);
				if(last==-1)
					continue;
				else if(j+arr.length-1-last>=min){
					flag = 1;
					min = j+arr.length-1-last;
					break;
				}
			}
			if(flag ==0)
				min = -1;
			array.add(new Integer(min));
		}
		for(int i =0;i<T;i++)
			System.out.println(array.get(i));
	}
	public static int findLast(char[] arr,char c,int t){
		for(int i=arr.length-1;i>t;i--)
			if(c==arr[i])
				return i;
		return -1;
	}
}
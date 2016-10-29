import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


class Difference {
  	private int[] elements;
  	public int maximumDifference;
	// Add your code here
    Difference(int[] ele){
        elements = ele;
    }
    void computeDifference(){
		int temp = elements[0] - elements[1];
		maximumDifference = temp;
        for(int  i=0;i<elements.length;i++)
            for(int j = i +1; j<elements.length;j++){
            temp = elements[i] - elements[j];			
            temp = temp>0?temp:-temp;
		    if(temp>maximumDifference)
				maximumDifference = temp;
        }
    }
} // End of Difference class

class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        sc.close();

        Difference difference = new Difference(a);

        difference.computeDifference();

        System.out.print(difference.maximumDifference);
    }
}
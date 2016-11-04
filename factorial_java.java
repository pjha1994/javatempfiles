import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import static java.lang.System.out;
class r{
	static BigInteger fact(BigInteger num) {
        if (num.equals(BigInteger.ONE))
            return BigInteger.ONE;
        else
            return num.multiply(fact(num.subtract(BigInteger.ONE)));
    }
	public static void main(String[] args){
		int n;
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		ArrayList<Integer> input = new ArrayList<Integer>();
	for(int i =0;i<n;i++){
		int temp = scan.nextInt();
		input.add(new Integer(temp/2));
	}
    ArrayList<BigInteger> fin = new ArrayList<BigInteger>();
	for(int i =0;i<n;i++){
		int  k =input.get(i);
		BigInteger sum = new BigInteger("0");
		for(int j =1;j<=k;j++){
			//System.out.println("finading for "+j);
			BigInteger temp1 = fact(BigInteger.valueOf(2).multiply(BigInteger.valueOf(j)));
			BigInteger temp2 = fact(BigInteger.valueOf(j).add(BigInteger.valueOf(1)));
			BigInteger temp3 = fact(BigInteger.valueOf(j));
			sum = sum.add(temp1.divide((temp2.multiply(temp3))));
			//System.out.println(" next catatlan number is "+sum);
		}
		fin.add(sum);
	}
	for(int i=0;i<n;i++)
		System.out.println(fin.get(i));
	}
}
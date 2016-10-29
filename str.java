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
			//out.println("called me : "+s+" "+e);
			return 1;
		}
		else
			return 0;
	}
}
class Solution16
{
   
   public static void main(String []args)
   {
      Scanner sc=new Scanner(System.in);
      String title=sc.nextLine();
      String author=sc.nextLine();
      int price=sc.nextInt();
      Book new_novel=new MyBook(title,author,price);
      new_novel.display();
      
   }
}

abstract class Book
{
    String title;
    String author;
    Book(String t,String a){
        title=t;
        author=a;
    }
    abstract void display();


}
class MyBook extends Book{
	private int price;
	MyBook(String title, String author, int price) {
		super(title,author);
		this.price = price;
	}
	void display(){
		System.out.println("Title: "+ title);
		System.out.println("Author: "+ author);
		System.out.println("Price: "+price);  
	}
}

class Solution15 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String firstName = scan.next();
		String lastName = scan.next();
		int id = scan.nextInt();
		int numScores = scan.nextInt();
		int[] testScores = new int[numScores];
		for(int i = 0; i < numScores; i++){
			testScores[i] = scan.nextInt();
		}
		scan.close();
		
		Student1 s = new Student1(firstName, lastName, id, testScores);
		s.printPerson();
		System.out.println("Grade: " + s.calculate() );
	}
}
class Person1 {
	protected String firstName;
	protected String lastName;
	protected int idNumber;
	
	// Constructor
	Person1(String firstName, String lastName, int identification){
		this.firstName = firstName;
		this.lastName = lastName;
		this.idNumber = identification;
	}
	
	// Print person data
	public void printPerson(){
		 System.out.println(
				"Name: " + lastName + ", " + firstName 
			+ 	"\nID: " + idNumber); 
	}
	 
}
class Student1 extends Person1{
	private int[] testScores;
	Student1(String firstName, String lastName, int id, int[] scores){
		super(firstName,lastName,id);
		testScores = scores;
	}
	Object calculate(){
		int s  = 0;
		for(int i  = 0 ; i<testScores.length; i++)
			s = s + testScores[i];
		int  a = s/testScores.length;
		if(a<40)
			return 'T';
		else if(a>=40 && a<55)
			return 'D';
		else if(a>=55 && a<70)
			return 'P';
		else if(a>=70 && a<80)
			return 'A';
		else if(a>=80 && a<90)
			return 'E';
		else if(a>=90 && a<=100)
			return 'O';
		return null;
	}
}
class Solution14{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int[][] arr = new int[6][6];
		int[] t = new int[6];
		int m =0,q=0;;
		while(true){
		  while(m<6){
			t[m] = scan.nextInt();
			m++;
		  }
		  m = 0;
			for(int j = 0; j<6; j++)
				arr[q][j] = t[j];
			q++;
			if(q>=6)
				break;
		}
		int max = 0;
		max = arr[0][0]+arr[0][1]+arr[0][2];
		max = max + arr[1][1];
		max = max + arr[2][1]+arr[2][0]+arr[2][2];
		for(int  i =0;i<4;i++)
			for(int j =0;j<4;j++)
			{
				int temp = 0;
				temp = arr[i][j]+arr[i][j+1]+arr[i][j+2];
				temp = temp + arr[i+1][j+1];
				temp = temp + arr[i+2][j+1]+arr[i+2][j]+arr[i+2][j+2];
				if(temp>max)
					max = temp;
			}
			System.out.println(max);
	}
}
class Solution13 {//counts numer of 1s in binary representation of a decimal number

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextInt();
		long k =bin(n);
		long c = 0L;
		long flag = 0L;
		long max = 0L;
		while(k>0){
			long m = k%10;
			if(m == 1)
				c = c+1;
			else{
				if(max<c)
				   max = c;
				c = 0;
			}
			k = k/10;
		}
		if(max<c)
			max = c;
		System.out.println(max);
    }
	static long bin(long n){
		long k = 0L;
		long p = 1L;
		while(n>0){
			long m = n%2;
			k = k+p*m;
			n = n/2;
			p = p *10;
		}
		return k;
	}
}

class Solution12{
    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Map<String, Integer> dictionary = new HashMap<String, Integer>();
        for(int i = 0; i < n; i++){
            String name = in.next();
            int phone = in.nextInt();
            dictionary.put(name, new Integer(phone));
            // Write code here
        }
        ArrayList<String> arr = new ArrayList<String>();
        while(in.hasNext()){
            String s = in.next();
            arr.add(s);
            
            // Write code here
        }
        for(String ele : arr){
            Integer i = dictionary.get(ele);
            System.out.println(i!=null?ele+"="+i:"Not found");
        }
        in.close();
    }
}


class Solution11 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        int k = 10;
		ArrayList<String> s = new ArrayList<String>();
		ArrayList<String> fin = new ArrayList<String>();
        for(int i = 0; i<T;i++){
			s.add(in.next());
		}
		for(int i =0;i<T;i++){
			char[] temp = (s.get(i)).toCharArray();
			String temp1 ="", temp2 ="";
			for(int j = 0;j<temp.length;j++)
				if(j%2 == 0)
					temp1 = temp1 + String.valueOf(temp[j]);
				else
					temp2 = temp2 + String.valueOf(temp[j]);
			fin.add(new String(temp1+" "+temp2));
		}
		for(String ele : fin)
			out.println(ele);
    }
}
class Solution10 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = 10;
        for(int i = 1; i<=k;i++)
            System.out.println(n+" "+"x"+" "+i+" = "+n*i);
    }
}

class Person {
    private int age;	
  
	public Person(int initialAge) {
  		// Add some more code to run some checks on initialAge
		if(initialAge<0){
			age = 0;
			System.out.println("Age is not valid, setting age to 0.");
		}
		else
			age = initialAge;
	}

	public void amIOld() {
  		// Write code determining if this person's age is old and print the correct statement:
		if(age<13)
			System.out.println("You are young.");
		else if(age>=13 && age<18)
			System.out.println("You are a teenager.");
		else
			System.out.println("You are old.");
	}

	public void yearPasses() {
  		// Increment this person's age.
		age++;
	}
public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			int age = sc.nextInt();
			Person p = new Person(age);
			p.amIOld();
			for (int j = 0; j < 3; j++) {
				p.yearPasses();
			}
			p.amIOld();
			System.out.println();
        }
		sc.close();
    }
}
public class str{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		String s = new String(scan.next());
		String t = new String(scan.next());
        char[] temp1 = s.toCharArray();
		char[] temp2 = t.toCharArray();
		boolean flag = true;
		if(temp1.length!=temp2.length)
		{
			out.println("NO");
			return;
		}
		for(int i = 0, j = temp2.length-1;i<temp1.length&&j>-1;i++,j--)
			if(temp1[i]!=temp2[j])
				flag = false;
		if(flag)
			out.println("YES");
		else
			out.println("NO");
	}
}
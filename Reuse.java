//package Reuse; //check package and another class execution conflict
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import static java.lang.System.out;

abstract class SortDouble{
	private double[] values;
	private final SortMetrics cutMetrics = new SortMetrics();
	
	public final SortMetrics sort(double[] data){
		values = data;
		cutMetrics.init();
		doSort();
		return getMetrics();
	}
	public final SortMetrics getMetrics(){
		return (SortMetrics)cutMetrics.clone();
	}
	protected final int getDataLength(){
		return values.length;
	}
	protected final double probe(int i){
		cutMetrics.probeCnt++;
		return values[i];
	}
	protected final int compare(int i, int j){
		cutMetrics.compareCnt++;
		double d1 = values[i];
		double d2 = values[j];
		if(d1 == d2)
			return 0;
		else
			return d1<d2?-1:1;
	}
	protected final void swap(int i, int j){
		cutMetrics.swapCnt++;
		double tmp = values[i];
		values[i] = values[j];
		values[j] = tmp;
	}
	protected abstract void doSort();
}
final class SortMetrics implements Cloneable{
	public long probeCnt, compareCnt, swapCnt;
	public void init(){
		probeCnt=compareCnt=swapCnt=0;
	}
	public String toString(){
		return probeCnt + " probes " + compareCnt + " compares " + swapCnt + " swaps ";
	}
	public Object clone(){
		try{
			return super.clone();
		}
		catch(CloneNotSupportedException e){
			throw new InternalError(e.toString());
		}
	}
}
class SimpleSortDouble extends SortDouble{
	protected void doSort(){
		for(int i=0;i<getDataLength();i++)
			for(int j=i+1;j<getDataLength();j++)
				if(compare(i,j)>0)
					swap(i,j);
	}
}
class TestSort{//benchmarking
	static double[] testData = {12.56,67.8,90.9,0.3,1.3e-2,7.9,3.17};

	public static void main(String[] args){
		SortDouble bsort = new SimpleSortDouble();
		SortMetrics metrics = bsort.sort(testData);
		out.println("Metrics: "+metrics);
		for(int  i =0;i<testData.length;i++)
			out.println("\t"+testData[i]);
	}
}
class MyArrayList{
	private int current_capacity;
	private Object elements[];
	
	static final int CAPACITY = 10;
	private int size = 0;
	
	public MyArrayList(){
		this(CAPACITY);
	}
	MyArrayList(int acapacity){
		current_capacity = acapacity;
		elements = new Object[current_capacity];
	}
	public int size(){return size;}
	public int capacity(){return current_capacity;}
	public boolean isEmpty(){return size==0;}
	
	public boolean isValidIndex(int position){
		return(position<0||position>size)?false:true;//fixed the bug here
	}
	public Object getElement(int position){
		if(isValidIndex(position))
			return elements[position];
		return null;
	}
	public void setElement(int position, Object currentElement){
		if(isValidIndex(position))
			elements[position] = currentElement;
		else
			out.println("invalid insertion");
	}
	public int indexOf(Object anElement){
		for(int i =0;i<size;i++)
			if(elements[i].equals(anElement))
				return i;
		return -1;
	}
	public void addElement(int position, Object anElement){
		if(isValidIndex(position)){
			if(size==current_capacity){
				out.println("list is full, addition is not possible");
				System.exit(1);
			}
			else{
				for(int i =size-1;i>=position;i--)
					elements[i+1]= elements[i];
			}
			elements[position]=anElement;
			size++;
		}
	}
	public void printList(){
		for(int i=0;i<size();i++)
			out.println(elements[i]+"\t");
	}
	public Object remove(int position){
		Object temp=null;
		if(isValidIndex(position)){
			temp=elements[position];
			for(int i=position+1;i<size;i++){
				elements[i-1]=elements[i];
				elements[--size]=null;
			}
		}
		return temp;
	}
}
class MyArrayStack extends MyArrayList{
	private int top = -1;
	MyArrayStack(int capacity){
		super(capacity);
	}
	public void push(Object o){
		super.addElement(size(),o);
		++top;
	}
	public Object peek(){
		if(isEmpty()){
			out.println("stack is empty illegal top");
			System.exit(2);
		}
		return getElement(top);
	}
	public Object pop(){
		Object temp = null;
		if(isEmpty()){
			out.println("stack is empty illegal pop");
			System.exit(3);
		}
		else{
			temp=remove(top);
			top--;
		}
		return temp;
	}
}

class StackInheritance{
	public static void main(String[] args){
		MyArrayStack stack = new MyArrayStack(4);
		stack.push(new Character('F'));
		stack.push(new Character('I'));
		stack.push(new Character('L'));
		stack.push(new Character('E'));
		String reverse = "";
		for(int i=0;i<stack.capacity();i++)
			reverse+=(Character)stack.pop();
		out.println("the reverse of the string FILE is : "+reverse);
	}
};
class IntegerStack implements Cloneable{
	private int[] buffer;
	private int top;
	
	public IntegerStack(int maxContents){
		buffer = new int[maxContents];
		top = -1;
	}
	public void push(int val){
		buffer[++top] = val;
	}
	public int pop(){
		return buffer[top--];
	}
	public void printVal(){
		for(int  i=0;i<=top;i++)
			out.print(buffer[i]+" ");
	}
	/*public Object clone()
	//throws CloneNotSupportedException
	{
		try{
			IntegerStack nObj = (IntegerStack)super.clone();
			nObj.buffer = (int[])buffer.clone();
			return nObj;
		}
		catch(CloneNotSupportedException e){
			throw new InternalError(e.toString());
		}
	}*/
	public static void main(String[] args)//doesn't work for shared objects like array references in an onject.
	throws CloneNotSupportedException
	{
		IntegerStack first = new IntegerStack(2);
		first.push(2);
		first.push(9);
		first.printVal();
		IntegerStack second =  (IntegerStack)first.clone();//cloning
		second.printVal();//different object with same initial values as the state of first
	}
}
class RunIntegerStack{//this works with clone() method declared above
	/*public static void main(String[] args)	{
		IntegerStack first = new IntegerStack(2);
		first.push(2);
		first.push(9);
		first.printVal();
		IntegerStack second =  (IntegerStack)((IntegerStack)first).clone();//cloning
		second.printVal();//different object with same initial values as the state of first
	}*/
}
class MyClass extends HerClass implements Cloneable{
	public Object clone()throws CloneNotSupportedException{
		return super.clone();
	}
} 
class HerClass{}
abstract class Account1{
	protected double balance;
	Account1(double openingbalance){
		balance = openingbalance;
	}
	double getBalance(){
		return this.balance;
	}
	void setAmount(double newAmount){
		balance = newAmount;
	}
	abstract boolean terminateAccount();
};
class SavingAccount1 extends Account1{
	SavingAccount1(double currentvalue){
		super(currentvalue);
	}
	boolean terminateAccount(){
		return balance>0?true:false;
	}
};
class CreditCardAccount1 extends Account1{
	private double balance;
	private final int NoOfTransactions_perYear = 20;
	
	CreditCardAccount1(int balance){
		super(balance);
	}
	boolean terminateAccount(){
		return (getBalance()<1000 && NoOfTransactions_perYear>20)?true:false;
	}
	int getNoOfTranscationsPerYr(){
		return this.NoOfTransactions_perYear;
	}
}
class LSP2{
	public static void main(String[] args){
		SavingAccount1 sa = new SavingAccount1(2000);
		CreditCardAccount1 cca = new CreditCardAccount1(1000);
		out.println("Account close status is : "+sa.terminateAccount());
		out.println("Account close status is : "+cca.terminateAccount());
	}
}
abstract class Benchmark{
	abstract void benchmark();
	
	public final long repeat(int count){
		long start = System.currentTimeMillis();
		for(int  i =0;i<count;i++)
			benchmark();
		return (System.currentTimeMillis()-start);
	}
}

class MethodBenchmark extends Benchmark{
	void benchmark(){
		
	}
	public static void main(String[] args){
		int count = Integer.parseInt(args[0]);
		long time = new MethodBenchmark().repeat(count);
		out.println(count+" methods in "+time +" milliseconds ");
	}
}
class Cell{
	private Cell next;
	private Object element;
	public Cell(Object element){
		this.element = element;
	}
	public Cell(Object element, Cell next){
		this.element = element;
		this.next = next;
	}
	public Object getElement(){
		return element;
	}
	public void setElement(Object element){
		this.element = element;
	}
	public Cell getNext(){
		return next;
	}
	public void setNext(Cell next){
		this.next = next;
	}
}
class SingleLinkedQueue{
	protected Cell head;
	protected Cell tail;
	public void add(Object item){}
	public Object remove(){return null;}
} 
class SavingAccount{
	private double balance;
	private final int lifetime = 20;
	SavingAccount(int balance){
		this.balance = balance;
	}
	boolean terminateAccount(){
		return (this.balance>0)?true:false;
	}
	double getCurrentBalance(){
		return this.balance;
	}
	void setAmount(double newAmount){
		balance = newAmount;
	}
	int getLifeTime(){
		return this.lifetime;
	}
};
class CreditCardAccount extends SavingAccount{
	private double balance;
	private final int NoOfTransactions_perYear = 20;
	
	CreditCardAccount(int balance){
		super(balance);
	}
	boolean terminateAccount(){
		return (getCurrentBalance()<1000 && NoOfTransactions_perYear>20)?true:false;
	}
	int getNoOfTranscationsPerYr(){
		return this.NoOfTransactions_perYear;
	}
}
class AccountChecker{
	void terminateAnAccount(SavingAccount sa){
		out.println("Account close result: "+sa.terminateAccount());
	}
};
class LSP1{
	public static void main(String[] args){
		AccountChecker ac = new AccountChecker();
		SavingAccount sa = new SavingAccount(2000);
		CreditCardAccount cca = new CreditCardAccount(1000);
		ac.terminateAnAccount(sa);
		ac.terminateAnAccount(cca);
	}
};
class A2{
	protected void method1() throws ExceptionQWERTY{
		//...
	}
}
class B2 extends A2{
	/*void method1()throws ExceptionQWERTY{
		//...
	}
	public void method1()throws ExceptionQWERT1{
		//...
	}*/
	public void method1()throws SubClassOfExceptionQWERTY{
		//...
	}
}
class ExceptionQWERTY extends Exception{}
class ExceptionQWERT1 extends Exception{}
class SubClassOfExceptionQWERTY extends ExceptionQWERTY{}

class TestB2{
	public static void main(String[] args){
		B2 b = new B2();
	}
}
class A1{
	static void method1(){
		out.println("method1 in class A1");
	}
}
class B1 extends A1{
	public static void method1(){
		out.println("method1 in class B1");
	}
}
class TestB1{
	public static void main(String[] args){
		A1 a = new B1();
		a.method1();//method of A1 invoked and not B1
	}
}
class Worker2{
	private String name;
	private int age;
	private Date DoJ;
	
	Worker2(String name, Date doj, int age){
		this.name = name; DoJ = doj; this.age = age;
	}
	public String getName(){return name;}
	public Date getDateOfJoining(){return DoJ;}
	public int getAge(){return age;}
	public double computeSalary(double basic, double DA){
		return basic + DA;
	}
};

class HourlyWorker extends Worker2{
	private int NoOfHours;
	HourlyWorker(String name, Date date_of_joining, int age){
		super(name, date_of_joining, age);
	}
	public int getNoOfHoursWorked(){
		return NoOfHours;
	}
	public void setNoOfHoursWorked(int hours){
		NoOfHours = hours;
	}
	public double computeSalary(double amountperHour,
	double otherperks){
		return amountperHour*NoOfHours + otherperks;
	}
};
class DailyWorker extends Worker2{
	private int NoOfDays;
	DailyWorker(String name, Date date_of_joining, int age){
		super(name, date_of_joining, age);
	}
	public int getNoOfDaysWorked(){return NoOfDays;}
	public void setNoOfDaysWorked(int days){NoOfDays = days;}
	public double computeSalary(double amountperDay,
	double otherperks){
		return amountperDay*NoOfDays + otherperks;
	}
};
class WorkerClient{
	public static void main(String[] args){
		Worker2 w = new HourlyWorker("Ramesh", new Date(2005, 3, 30),25);
	}
}
class Person1{
	private String name;
	private int age;
	private Date DoB;
	Person1(String name, Date date_of_birth, int age){
		this.name = name;
		DoB = date_of_birth;
		this.age = age;
	}
	public String getName(){return name;}
	public Date DoB(){return DoB;}
	public int gatAge(){return age;}	
};

class Worker1 extends Person1{
	private double current_basic  = 0, currentDA = 0;
	Worker1(String name, Date date_of_birth, int age){
		super(name, date_of_birth, age);
	}
	public double getBasicSalary(){return current_basic;}
	public void setBasicSalary(double newbasic){
		current_basic = newbasic;
	}
	public double computeSalary(){
		return current_basic + currentDA;
	}
};
class Student1 extends Person1{
	private double cgpa;
	private String college_name;
	
	Student1(String name, Date date_of_birth, int Age, String college){
		super(name, date_of_birth, Age);
		college_name = college;
	}
	public String getCollegeName(){
		return college_name;
	}
	public double getCG(){
		return cgpa;
	}
	public void setCG(double newval){
		cgpa = newval;
	}
	public char computeGrade(){
		return (cgpa>=7.5)?'A':'B';
	}
};
class That{
	protected String nm(){
		return "That";
	}
}
class More extends That{
	protected String nm(){
		return "More";
	}
	protected void printNM(){
		That sref = (That)this;//widening
		System.out.println("this.nm(): "+ this.nm());
		System.out.println("sref.nm(): "+ sref.nm());
		System.out.println("super.nm(): "+ super.nm());
		More mref = (More)sref;//narrowing
	}
	public static void main(String[] args){
		    More m = new More();
			m.printNM();
	}
	public static void sortList(List<Integer> list){
		if(list instanceof SortedList)
			return;
		else
			out.println("write the implementation to sort the lsit");
	}
	
}
class SortedList{}
class SuperShow{
	public String str = "SuperStr";
	
	public void show(){
		System.out.println("Super.show: "+ str);
	}
}
class ExtendsShow extends SuperShow{//Accessing inheited members
	public String str = "ExtendStr";
	
	public void show(){
		System.out.println("Extend.show: "+ str);
	}
	
	public static void main(String[] args){
		ExtendsShow ext = new ExtendsShow();
		SuperShow sup = ext;
		sup.show();
		ext.show();
		System.out.println("sup.str = "+sup.str);
		System.out.println("ext.str = "+ext.str);
	}
}
class A
{
    public static void f()
    {
        System.out.println("A.f()");
    }
}

class B extends A
{   
    //@Override
    public static void f()
    {
        System.out.println("B.f()");
        //return 0;
    }
}

class X1{
	protected int xMask = 0x00ff;
	protected int fullMask;
	public X1(){
		fullMask = xMask;
	}
	public int mask(int orig){
		return(orig&fullMask);
	}
}
class Y1 extends X1{
	protected int yMask  = 0xff00;
	public Y1(){
		fullMask |= yMask;
	}
}
class Attr{
	private final String name;
	private Object value = null;
	
	public Attr(String name){
		this.name = name;
	}
	public Attr(String name, Object value){
		this.name = name;
		this.value = value;
	}
	public String getName(){
		return name;
	}
	public Object getValue(){
		return value;
	}
	public Object setValue(Object newValue){
		Object oldVal = value;
		value = newValue;
		return oldVal;
	}
	public String toString(){
		return name+"="+value+"";
	}
}
class ColorAttr extends Attr{
	private ScreenColor myColor;
	public ColorAttr(String name, Object value){
		super(name, value);
		decodeColor();
	}
	public ColorAttr(String name){
		this(name,"transparent");
	}
	public ColorAttr(String name, ScreenColor value){
		super(name, value.toString());
		myColor = value;
	}
	public Object setValue(Object newValue){
		Object retval  = super.setValue(newValue);
		decodeColor();
		return retval;
	}
	public ScreenColor setValue(ScreenColor newValue){
		super.setValue(newValue.toString());
		ScreenColor oldValue  = myColor;
		myColor = newValue;
		return oldValue;
	}
	public ScreenColor getColor(){
		return myColor;
	}
	protected void decodeColor(){
		if(getValue()==null)
			myColor  = null;
		/*else
			myColor = new ScreenColor(getValue());*/ //implement the class and then uncomment 
	}
}
class ScreenColor{}//ScreenColor dummy class used/needed above
//Inheritance from here on and upwards.
class s5{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		ArrayList<String> arr = new ArrayList<String>();
		for(int i =0;i<T;i++){
			String s  = scan.next();
			arr.add(s);
		}
		for(int i =0;i<T;i++){
			char[] array = (arr.get(i)).toCharArray();
			boolean flag = false;
			for(int  j =0;j<array.length;j++){
				for(int k = j+1;j<array.length;j++)
					if(array[j]!=array[k]){
						flag = true;
						break;
					}
				if(flag)
					break;
			}
			if(flag)
				System.out.println(array.length);
			else
				System.out.println(1);
		}
		
	}
}
class s4{
	public static void main(String[] args){
		/*Scanner scan = new Scanner(System.in);
		String s = scan.next();
		int[] arr = s.toCharArray();*/
	}
}
class s3{
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
class s2{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int n =scan.nextInt();
		ArrayList<String> arr = new ArrayList<String>();
		for(int i = 0;i<n;i++){
			String s = scan.next(); 
			if(s.length()>10){
				char[] c = s.toCharArray();
				String temp ="";
				temp = temp+ String.valueOf(c[0]);
				temp =temp + String.valueOf(c.length-2);
				temp = temp+ String.valueOf(c[c.length-1]);
				arr.add(temp);
			}
		}
		for(String ele : arr)
			out.println(ele);
	}
}
class s1{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
	    ArrayList<String> fin = new ArrayList<String>();
		for(;;){
			int k = scan.nextInt();
			if(k==0)
				break;
			gibArray a = new gibArray(k);
			for(int i =1;i<=k;i++){
				a.put(scan.nextInt(),i-1);
			}
			gibArray b = new gibArray(k);
			for(int i = 1; i<=k;i++){
				b.put(a.search(i)+1,i-1);
			}
			boolean flag = true;
			for(int i =0;i<k;i++)
				if(a.get(i) != b.get(i)){
						flag = false;
						break;
				}
			if(flag)
				fin.add(new String("ambiguous"));
			else
				fin.add(new String("not ambiguous"));
		}
		for(int i =0;i<fin.size();i++)
			out.println(fin.get(i));
		
			/*int counttemp = scan.nextInt();
			for(int j =0;j<counttemp;j++){
				int k = scan.nextInt();
					if(k==0)
						break;
					n.add(new Integer(k));
			}
		m = scan.nextInt();*/
	}
}
class gibArray{
	int[] arr;
	int size;
	gibArray(int size){
		this.size = size;
		arr = new int[size];
	}
	void put(int x,int i){
		arr[i] = x;
	}
	int get(int i){
		return arr[i];
	}
	int search(int a){
		int i = 0;
		for(i =0;i<size;i++)
			if(arr[i] == a)
				break;
		return i;
	}
	void rotate(){
		int i = 0;
		int l = arr[0];
		while(i<size-1){
			arr[i] = arr[i+1];
			i++;
		}
		arr[size-1]= l;
	}
}
class Solution9{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		
		int n = -1,m = -1; 
		
		n = scan.nextInt();	
		m = scan.nextInt();
		//gibArray a = new gibArray(n);
		//gibArray b = new gibArray(m);
		ArrayList<Integer> a = new ArrayList<Integer>();
		ArrayList<Integer> b = new ArrayList<Integer>();
		ArrayList<Integer> c = new ArrayList<Integer>();
		for(int i = 0; i < n; i++)
				a.add(new Integer(scan.nextInt()));
		for(int i = 0; i < m; i++)
				b.add(new Integer(scan.nextInt()));
		
		
		int len1 = n<m?n:m;
		int len2 = n>m?m:n;
		int p = 0;
		int q = 0;
		
		for(int i = p; i<len1; i++)
			for(int j = q; j<len2;j++){
				if(a.get(i) == b.get(j) ){
					p = i+1;
					c.add(new Integer(a.get(i)));
					q = j+1;
					ArrayList<Integer> temp = new ArrayList<Integer>();
					temp = a;
					a = b;
					b = temp;
					break;
				}
			}
			
		//char[] x = common.toCharArray();
		
		for(int i =0 ;i<c.size();i++)
			System.out.print(c.get(i)+" ");
		
	}
}

class SolutionSomeBODYElse {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        String[] a = new String[t];
        for(int i=0;i<t;i++){
            a[i]=sc.next();
        }
        for(int i=0;i<t;i++){
            StringBuffer element = new StringBuffer(a[i]);
            element.reverse();
           
            int len=element.length();
            
            
            //System.out.println(element);
                int j=0;
            int index=-1;
            int swapindex=-1;
      
                while(j<len-1){
                            int k=j+1;
                            if(element.charAt(j)>element.charAt(k)){
                            index=j;
                            break;
                           }
                    j++;
                    }
          //  System.out.println(index);
            for(int range=0;range<=index;range++){
                if(element.charAt(range)>element.charAt(index+1)){
                    swapindex=range;
                    break;
                }
            }
         //   System.out.println(swapindex);
            if(index!=-1 && swapindex!=-1){
                                               StringBuffer w = new StringBuffer(element.substring(0,swapindex));
                                               StringBuffer x = new StringBuffer(element.substring(swapindex,swapindex+1));
                                               StringBuffer y = new StringBuffer(element.substring(swapindex+1,index+2));
                                                StringBuffer z = new StringBuffer(element.substring(index+2,element.length()));
                                              
                                               StringBuffer newString = new StringBuffer();
                                               newString.append(w);
                                               newString.append(y);
                                               String str=new String(newString);
                                               char[] chars = str.toCharArray();
                                               Arrays.sort(chars);
                                               StringBuffer sorted = new StringBuffer(new String(chars));
                                               sorted.reverse();
                                            
                                                element.setLength(0);
                                                element.append(sorted);
                                           
                                                element.append(x);
                                         
                                                element.append(z);
            
            
            
                   System.out.println(element.reverse());
               }
            else{
                System.out.println("no answer");
            }
                
            
           // System.out.println("---------------------");
        }
    }
}

class Solution8{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int d = scan.nextInt();
		gibArray arr = new gibArray(n);
		for(int i =0; i<n;i++)
			arr.put(scan.nextInt(),i);
		for(int i =0;i<d;i++)
			arr.rotate();
		for(int i =0; i<n;i++)
			System.out.print(arr.get(i)+" ");
	}
}

class Solution7{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		ArrayList<String> a = new ArrayList<String>();
		for(int i =0;i<t; i++){
				String s = scan.next();
				a.add(s);
		}
		for(int  i =0; i<a.size();i++){
			String  k =processString(a.get(i));
			out.println(k!=null?k:"no answer");
		}
	}
	static String processString(String s){
		char[] arr = s.toCharArray();
		int i,k = -1, p =-1;
		for(i =0;i<arr.length-1;i++){
			if(arr[i]<arr[i+1]){
				k =i;
			}
		}
		if(k==-1)
			return null;
		for(i =k+1;i<arr.length;i++){
			if(arr[i]>arr[k]){
				p =i;
			}
		}
		char t = arr[k];
		arr[k] =arr[p];
		arr[p] = t;
		for(int m = k+1, n = arr.length-1 ; m<n;m++,n--){
			t  = arr[m];
			arr[m] = arr[n];
			arr[n] = t;			
		}
		return new String(arr);
	}
}
class nestedLogic{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int actD  = scan.nextInt(), actM = scan.nextInt(), actY = scan.nextInt();
	    //out.println("actual Y : "+actY+" actual M : "+actM+" actual D : "+actD);
		int dueD  = scan.nextInt(), dueM = scan.nextInt(), dueY = scan.nextInt() ;
		//out.println("due Y : "+dueY+" due M : "+dueM+" due D : "+dueD);
		
		boolean flag1=false,flag2=false,flag3=false;
		int sum = 0;
		if((actY-dueY)>0)
			flag1 = true;
		if(!flag1&&(actM-dueM)>0)
			flag2 = true;
		if(!flag1&&!flag2&&(actD-dueD)>0)
			flag3 = true;
		//out.println(flag1);
		//out.println(flag2);
		//out.println(flag3);
		if(actY>=dueY ){
			if(flag1)
				sum = sum +10000;
			if(flag2)
				sum = sum +500*(actM-dueM);
			if(flag3)
				sum = sum + 15*(actD-dueD);
		}
		System.out.println(sum);
	}
}
class binSearch{
	private String[] table;
	
	binSearch(int len, String[]arr){
		table = new String[len];
		table = arr;
		arr = null;
	}
	public int position(String key){//needs a SORTED ARRAY
		int lo  = 0;
		int hi = table.length -1;
		while(lo<=hi){
			int mid = lo +(hi-lo)/2;
			int cmp = key.compareTo(table[mid]);
			if(cmp ==0)
				return mid;
			else  if(cmp<0)
				hi = mid-1;
			else
				lo = mid + 1;
		}
		out.println("control here");
		return -1;
	}
	public void printAll(){
		for(int i =0;i<table.length;i++)
			out.println(table[i]);
	}
}
class tryingString{
	public static void main(String[] args){
		String first = "first";out.println("first : "+first);
		String second = "escond";out.println("second : "+second);
		String third = second+first; out.println("third : "+third);
		String fourth = new String("hola");out.println("fourth : "+fourth);
		String fifth = new String(fourth);out.println("fifth : "+fifth);
		String[] arr ={first, second, third, fourth, fifth};
		for(int i =0;i <arr.length; i++)
			out.println(arr[i]);
		char[] counts = new char[300]; 
		for(int i =0;i <third.length(); i++)
			counts[third.charAt(i)]++;
		for(char i =0;i<300;i++)
			if(counts[i]>0)
				out.println((int)i+"  : "+i+" ");
		System.out.println(countBetween(third,'s'));
		binSearch b = new binSearch(arr.length,arr);
		//out.println(b.position(first)); //sort the list first
		b.printAll();
		mainMethod(args);
		System.out.println(delimitedString("howareyouoing", 'w', 'd'));
	}
	static String delimitedString(String from, char start, char end){
		int startPos = from.indexOf(start);
		int endPos = from.lastIndexOf(end);
		if(startPos>endPos)
			return null;
		else if(startPos == -1)
			return null;
		else if(endPos == -1)
			return from.substring(startPos);
		else
			return from.substring(startPos,endPos+1);
	}
	static int putIn(String key, String[] table, int tableSize){
		String unique = key.intern();
		int i;
		for(i = 0 ;  i<tableSize; i++)
			if(table[i] == unique)
				return i;
		table[i] = unique;
		tableSize++;
		return i;
	}
	static void mainMethod(String[] args){
		String str  = "Look, look!";
		boolean b1, b2, b3;
		
		b1 = str.regionMatches(6, "Look", 0, 4);
		b2 = str.regionMatches(true,6, "Look", 0, 4);
		b3 = str.regionMatches(true,6, "Look", 0, 5);
		
		out.println("b1  = "+b1);
		out.println("b2  = "+b2);
		out.println("b3  = "+b3);
	} 
	static int countBetween(String str, char ch){
		int begPos = str.indexOf(ch);//first occurrence
		System.out.println("beginning position : "+begPos);
		if(begPos < 0)
			return -1;
		int endPos  = str.lastIndexOf(ch);
		System.out.println("ending position : "+endPos);
		return endPos - begPos -1;
	}
}

public class Reuse{
	/*Reuse Reuse(Reuse Reuse){
		Reuse:
		for(;;){
			if(Reuse.Reuse(Reuse)== Reuse)
				break Reuse;
		}
		return Reuse;
	}*/
}
class trial3{
	public static void main(String[] args){
		{//block1
			int x =5, y=9;out.println("x: " + x+" y: "+y);
		}
		{//block2
			int x=45;
			float y  =9.0f;out.println("x: " + x+" y: "+y);
		}
		int i = 5;//primitives
		int j = 0;
		j = i++ + ++i;
		out.println("i is "+i+" j  is "+j);
		float x = 3.14f, y = 2.81f;
		final int id = i++;
		
		int[] ia = new int[3];//Or (int ia[]  = new int[3];)
		for(int a = 0; a < ia.length; a++)
			out.println(a+": " + ia[a]);
		
		int[] emptyArray = {};
		out.println(emptyArray.length);
		
		int[] emptyArray1 = new int[0];
		out.println(emptyArray.length);
		
		int[] nullArray = null;
		if(nullArray == null)
			out.println("null array");
		
		Float[][] mat = new Float[4][4];//wrapper class
		setupMatrix(mat);
		printGeneric2D(mat);
		
		Float[][] mat1 = new Float[4][];//Wrapper class
		for(int a = 0; a<mat1.length; a++)
			mat1[a] = new Float[4];//each nested array can have a different size;
		out.println("");
		setupMatrix(mat1);
		printGeneric2D(mat1);
		
		BuilderContext[] attrs = new BuilderContext[12];//12 reference vars
		for(i =0; i<attrs.length; i++)
			attrs[i] = new BuilderContext(); //initialize each ref. vars(object creation)
		
		String[] dangers = {"Lions", "Tigers", "Bears"};
		printGeneric1D(dangers);
		
		String[] dangers1  = new String[3];
		dangers1[1] = "Tigers";
		dangers1[0] = "Lions";
		dangers1[2] = "Bears";
		printGeneric1D(dangers1);
		
		printGeneric1D(new String[]{"one","two","many\n"});//anonymous array
		
		Integer[][] pascalsTriangle = {//Wrapper class
			{1},
				{1,1},
					{1,2,1},
						{1,3,3,1},
							{1,4,6,4,1},
		};
		printGeneric2D(pascalsTriangle);
		
		Y[] yArray = new Y[3];
		X[] xArray = yArray;
		xArray[0] = new Y();
		//xArray[2] = new X();
		//xArray[1] = new Z();
		
		xArray = new X[3];
		xArray[0] = new Y();
		xArray[2] = new X();
		xArray[1] = new Z();
		
		xArray = new Z[3];
		//xArray[0] = new Y();
		//xArray[2] = new X();
		xArray[1] = new Z();
		
		int val = 5;
		out.println("val : "+val);
		val = -val; //unary negation
		out.println("val : "+val);
		
		out.println(7/2);out.println(-7/2);out.println(7/-2);out.println(-7/-2);
		out.println(7%2);out.println(7%-2);out.println(-7%2);out.println(-7%-2);
		
		someValues();
		
		//++arr[where()];//implement where()
		//arr[where()] = arr[where()] + 1;
		
		int h = 16;
		out.println(++h + " " + h++ + " " + h);
		char a ='a';
		out.println(a);
		++a;
		out.println(a);
		
		
	}
	static void someValues(){
		int xx =3,yy =4;
		out.println(xx/yy);out.println(xx%yy);out.println((xx/yy)*yy);
		out.println((xx/yy)*yy + (xx%yy));
		//out.println(xx/0);
		out.println(xx/0f);out.println(xx/-0f);out.println(0f/0f);out.println(0f/-0f);
		out.println((xx/-0f)/(xx/0f));out.println((xx/0f)/(xx/-0f));
		out.println((int)Character.MAX_VALUE);out.println((int)Character.MIN_VALUE);
		out.println(Byte.MAX_VALUE);out.println(Byte.MIN_VALUE);
		out.println(Short.MAX_VALUE);out.println(Short.MIN_VALUE);
		//out.println(Boolean.MAX_VALUE);out.println(Boolean.MIN_VALUE);
		out.println(Integer.MAX_VALUE);out.println(Integer.MIN_VALUE);
		out.println(Long.MAX_VALUE);out.println(Long.MIN_VALUE);
		out.println(Float.POSITIVE_INFINITY);out.println(Float.MAX_VALUE);
		out.println(Double.NEGATIVE_INFINITY);out.println(Double.MAX_VALUE);
	}
	static void printGeneric1D(Object[] obj){
		for(int  i =0 ;i <obj.length; i++)
			out.print(obj[i]+" ");
	}
	static void printGeneric2D(Object[][] obj){
		for(int  i =0 ;i <obj.length; i++){
			for(int j =0; j < obj[i].length; j++)
					out.print(obj[i][j]+" ");
			out.println();
		}
	}
	static void setupMatrix(Float[][] mat){
		for(int i = 0; i <mat.length; i++)
			for(int j =0; j<mat.length; j++)
				mat[i][j] = new Float(i+j);
		/*for(int i = 0; i <mat.length; i++){
			for(int j =0; j<mat[i].length; j++)
				out.print(" "+mat[i][j]+" ");
			out.println();
		
		}*/
	}
}
class X{}
class Y extends X{}
class Z extends X{}

/*class ScaleVector extends Double{//no inheritance
	
}*/
/*class ScaleVector extends double[]{}//ERROR, arrays are like final classes*/
class NamedObj{
	static final int[] numbers = numberlist();
	static final int maxNumber;
	
	static{
		int max = numbers[0];
		for(int  i = 1; i < numbers.length; i++)
			if(numbers[i] > max)
				max = numbers[i];
		maxNumber = max;
	}
	
	final String name;
	
	NamedObj(String name){
		this.name = name;
	}
	static int[] numberlist(){
		int[] arr = {1,2,3,4,5};
		return arr;
	}
}
class RunBuilder{
	public static void main(String[] args){
		Builder b = Builder.New();
		out.println(b);
	}
}
class Builder{
    final BuilderContext context;

    private Builder(BuilderContext context){
        this.context=context;
    }       

    public static Builder New(){
        return new Builder(new BuilderContext());
    }
}
class BuilderContext{}
class Foo {
    static {
		for(int i = 0;i <5;i++)
         System.out.println("Message");
         System.exit(0);
    }
public static void main(String[] args){;}	
}	
class RunStudentATMCard{
	public static void main(String[] args) 
	{
		Student Ramesh = new Student("Ramesh","20/11/05","BE ComputerScience");
		ATMCard rameshcard = new ATMCard(Ramesh);
		
		Student Sowjanya = new Student("Sowjanya","15/7/89","BE Electronics");
		ATMCard sowjanyacard = new ATMCard(Sowjanya);
		
		//Ramesh.setATMCard(sowjanyacard);//improper assignment
		//Sowjanya.setATMCard(rameshcard);//improper assignment
		//Ramesh.setATMCard(rameshcard);//correct assigment
		//out.println(rameshcard);
		Ramesh.addATMCard(sowjanyacard);
		out.println(Ramesh);
		Sowjanya.addATMCard(rameshcard);
		out.println(Sowjanya);
		//rameshcard.reAssignCard(Ramesh);
	}
}
class Student{
	private ATMCard card;
	private String name;
	private String DateofBirth;
	private String courseRegistered;
	
	Student(String aname, String aDob, String acourseRegistered){
		name = name; DateofBirth  = aDob; courseRegistered = acourseRegistered;
	}
	public ATMCard getCard(){return card;}
	public void addATMCard(ATMCard acard){card = new ATMCard(this);}	
	//public void setATMCard(ATMCard acard){card = acard;}
	public void deleteCard(){card = null;}
	//...
}
class AlreadyCardExistsException{}
class ATMCard{
	private Student student;
	public ATMCard(Student astudent){student = astudent;}
	public Student getStudentDetails(){return student;}
	/*public void reAssignCard(Student newStudent){
		if(newStudent.getCard()!=null) 
			throw new AlreadyCardExistsException();
				System.out.println("error!, can't ssign");
		else{
			student.deleteCard();
			newStudent.addATMCard(this);
		}
	}*/
}
class Book{
	private String title, author;
	private float price;
	private ArrayList<Integer> Chapters;
	Book(String atitle, String anauthor, float aprice){
		title = atitle; author = anauthor; price = aprice;
		Chapters  = new ArrayList<Integer>(1);
	}
	
}
class LectureClass{
	private ArrayList<Student> StudentList;
	LectureClass(ArrayList<Student> L){StudentList = L;}
	//...
	public void addStudent(Student s){
		StudentList.add(s);
	}
}
class Solution6 {
	
    public static void main(String[] args) {
        int i = 4;
        double d = 4.0;
        String s = "HackerRank ";
		
        Scanner scan = new Scanner(System.in);
		/* Declare second integer, double, and String variables. */
        int in; double doub; String var="";
        /* Read and save an integer, double, and String to your variables.*/
        in = scan.nextInt();doub = scan.nextDouble(); scan.nextLine(); var = scan.nextLine();
        /* Print the sum of both integer variables on a new line. */
        System.out.println(i+in);
        /* Print the sum of the double variables on a new line. */
		 System.out.println(d+doub);
        /* Concatenate and print the String variables on a new line; 
        	the 's' variable above should be printed first. */
         System.out.println(s+var);
		 scan.close();
		//WAYS OF READING FROM STDIN.
		
		int option = scan.nextInt();
		scan.nextLine();  // Consume newline left-over
		String str1 = scan.nextLine(); 
		      //OR
		option = 0;
		try {
			option = Integer.parseInt(scan.nextLine());
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		str1 = scan.nextLine();
    }
}
class Solution5{
    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        final int n = in.nextInt();
		Map<String,Integer> map = new HashMap<String,Integer>();
        for(int i = 0; i < n; i++){
            String name = in.next();
            int phone = in.nextInt();
            // Write code here
			map.put(name,new Integer(phone));
        }
		ArrayList<String> list = new ArrayList<String>();
        while(in.hasNext()){
            String s = in.next();
            // Write code here
			list.add(s);
        }
		for (String s : list) {
			if(map.get(s)!=null)
				System.out.println(s+"="+map.get(s));
			else
				System.out.println("Not found");
		}
        in.close();
    }
}
class p{
	String s;
	int val;
	p(String S, int VAL){
		s = S; val = VAL;
	}
	String getString(){
		return s;
	}
	int getVal(){
		return val;
	}
}
class Solution4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = in.next();
		char[] charArray = s.toCharArray();
        int k = in.nextInt();
		k = k%26;//taking the value from 0 to 25 anyway,rotations
		for(int i =0;i<charArray.length;i++){
			if(charArray[i]>='a'&&charArray[i]<='z'){
				   charArray[i] = (char)((int)charArray[i] + k);
				   if(charArray[i]>'z'){
					   charArray[i] = (char)((int)charArray[i]-26);
				   }
			}
			if(charArray[i]>='A'&&charArray[i]<='Z'){
				 charArray[i] = (char)((int)charArray[i] + k);
				if(charArray[i]>'Z')
					charArray[i] = (char)((int)charArray[i]-26);		
			}
		}
		s = new String(charArray);
		System.out.println(/*charArray[i]*/s);
    }
}
class Solution3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
		int count=0;
		for(int m=0; m<a.length;m++)
			for(int q = m+1; q<a.length; q++)
				if((a[m]+a[q])%k == 0){
					count++;
			}
				System.out.println(count);
		/*while( i<j ){
			if((a[i]+a[j])%k == 0){
				
			}
		}*/
    }
}
class Solution2 {

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

class Solution1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int k = in.nextInt();
			int temp = 1&2;
			for(int  i = 1; i<n;i++)
				for(int j = i+1; j<=n;j++)
					if((i&j)<k && (i&j)>temp)
						temp = i&j;
					System.out.println(temp);
        }
    }
}
//import java.io;
//import java.util.FileInputStream;
class trial1{//MAIN
	static final int MAX_INDEX = 10;
	public static void main(String[] args){
			System.out.println("Hello World\n");
			fibonacci();
			fibonacci1();
			
			Point p1 = new Point(3.0f, 4.0f);
			Point p2 = new Point();
			p1.clear(1,2);
			System.out.println("The norm of the point (3,4) is " + p1.getNorm());
			System.out.println("p1 to p2 dist is  "+p2.distance(p1));
			
			Point lowerLeft = new Point();
			Point upperRight = new Point();
			Point middlePoint = new Point();
			
			lowerLeft.xCo = 0.0;
			lowerLeft.yCo = 0.0;
			
			upperRight.xCo = 1280.0;
			upperRight.yCo = 1024.0;
			
			middlePoint.xCo = 640.0;
			middlePoint.yCo = 512.0;
			
			double d = lowerLeft.distance(upperRight);
			
			System.out.println("dist is "+ d);
			
			Numbers num = new Numbers(5);
			System.out.println(""+num.compuetfactorial());
			System.out.println(""+num.computePower(5));
			num.printPrimeList();
			
			//ArrayListExample arr = new ArrayListExample();;
			ArrayListExample.example(args); //Static method called via class name, can use 'arr' variable as well.
			StringsDemo.demo(args);
			
			char[] array = {'h','e','l','l','o','h','i','e',' '};
			System.out.println(new String(array)+"\t"+ array.length);//FIX THIS
	
			String array1 =  new String(array);
			System.out.println(array1+'\t'+array1.length());
			
			if(array1==(new String(array)))
				System.out.println("true");
			if(array1.equals(array))
				System.out.println("true");
			
			StringsDemo x = null;
			//x.demo1();//Even null can access the static method, gives a warning though
            StringsDemo.demo1();
				
			SimpleLookup look = new SimpleLookup();
			look.setName("Abhi",34);
			look.setName("add",67);
			look.setName("allowed",55);
			look.setName("args",1280);
			look.setName("arr",90);
			System.out.println("val is "+look.find("Abhi"));
			
			ArrayList<String> list = new ArrayList<String>();
			list.add("a");list.add("b");list.add("c");list.add("d");
			look.processValues(list,look);
			look.printAll();
			
			Date1.daTe();
	}
	public static void fibonacci(){
		int lo = 1;
		int hi = 1;
		System.out.println(lo);
		while(hi<MAX_INDEX){
			System.out.println(hi);
			hi = lo + hi;
			lo = hi - lo;
		}
	}
	public static void fibonacci1(){
		int lo = 1;
		int hi = 1;
		String mark;
		
		System.out.println("1: "+lo);
		for(int i = 2; i<= MAX_INDEX; i++){
			if(hi%2 == 0)
				mark = "*";
			else
				mark = "";
			System.out.println(i + ": " + hi + mark);
			hi = lo + hi;
			lo = hi - lo;
		}
	}
}
class M{
  static int c(char[] a){
    int i = 3;
    for(int c : a){
      if(i == (i = c%2)){
        return 0;
      }
    }
    return 1;
  }

  public static void main(String[] a){
    System.out.print(c("#define".toCharArray()) + ",");
    System.out.print(c("EvenSt-ring$!".toCharArray()) + ",");
    System.out.print(c("long".toCharArray()) + ",");
    System.out.print(c("abcdABCD".toCharArray()) + ",");
    System.out.print(c("3.141".toCharArray()) + ",");
    System.out.print(c("~".toCharArray()) + ",");
    System.out.print(c("0123456789".toCharArray()) + ",");
    System.out.print(c("C ode - g ol!f".toCharArray()) + ",");
    System.out.println(c("HatchingLobstersVexinglyPopulateJuvenileFoxglove".toCharArray()));

    System.out.print(c("Hello World".toCharArray()) + ",");
    System.out.print(c("PPCG".toCharArray()) + ",");
    System.out.print(c("3.1415".toCharArray()) + ",");
    System.out.print(c("babbage".toCharArray()) + ",");
    System.out.print(c("Code-golf".toCharArray()) + ",");
    System.out.print(c("Standard loopholes apply".toCharArray()) + ",");
    System.out.print(c("Shortest answer in bytes wins".toCharArray()) + ",");
    System.out.print(c("Happy golfing!".toCharArray()));
  }
}
class RunDatabase{
	public static void main(String[] args){
		Database db = Database.getInstance("hello");//Only one object can be instantiated at a time
		System.out.println(db.getName());
		Database db1 = Database.getInstance("helloDKVBAKHVBIVHAEFIHB");
		System.out.println(db1.getName());
	}
}
class Database {

    private static Database singleObject;
    private int record;
    private String name;

    private Database(String n) {
        name = n;
        record = 0;
    }

    public static synchronized Database getInstance(String n) {
        if (singleObject == null) {
            Database singleObject = new Database(n);
        }

        return singleObject;
		
		//return new Database(n);
    }

    public void doSomething() {
        System.out.println("Hello StackOverflow.");
    }

    public String getName() {
        return name;
    }
}
class StackTest{
	public static void main(String[] args){
		ArrayStack stack = new ArrayStack(4);
		
		stack.push(new Character('A'));
		stack.push(new Character('B'));
		stack.push(new Character('H'));
		stack.push(new Character('I'));
		
		String reverse = "";
		for(int i = 0; i<stack.capacity(); i++)
			reverse += (Character)stack.pop();//typecast
		System.out.println("The reverse of the string ABHI is: "+reverse);
		
		stack.push(new Integer(1));
		stack.push(new Integer(2));
		stack.push(new Integer(3));
		stack.push(new Integer(4));
		
		reverse = "";
		for(int i = 0; i<stack.capacity(); i++)
			reverse += (Integer)stack.pop();//typecast
		System.out.println("The reverse of the string 1234 is: "+reverse);
	}
}
/** 
@Class invariance : ArrayStack should satisfy S.size()>= 0 && S.top >= -1
*/
class ArrayStack{
	private int capacity;
	private Object  S[];
	private int top = -1;
	
	static final int CAPACITY = 10;
	
/**
Constructs a Stack with default capacity 10
*/
public ArrayStack(){
	capacity = CAPACITY;
}
/**
Constructs a Stack with capacity set to @param size provided as argument
*/
ArrayStack(int size){
	capacity = size;
	S = new Object[capacity];
}
public int size(){return top+1;}
public int capacity(){return capacity;}
public boolean isEmpty(){return top<0;}

/**
It adds an object with @param O at the top of the stack; 
@pre-conditon: top>=0
*/
public void push(Object o){
	if(size() == capacity){
		System.out.println("Stack is full");
		System.exit(1);
	}
	S[++top] = o;
}
/**
@post-condition for the above method top>=1 && size>0
*/


/**
@pre-condition for peek method is: top>=0
*/
public Object peek(){
	if(isEmpty()){
		System.out.println("Stack is empty, illegal pop! ");
		System.exit(2);
	}
	return S[top];
}
/**
@post-condition for this method: top>= 0
*/
/**
@pre-condition for the pop method: top>-1
*/
public Object pop(){
	if(isEmpty()){
		System.out.println("Stack is empty, illegal pop! ");
		System.exit(3);
	}
	Object top_element = S[top];
	S[top--] = null;
	return top_element;
}
/**
@post-condition: top>=-1
*/
};
class Echo{
	public static void main(String[] args){
		for(int i = 0; i<args.length; i++)
			System.out.print(args[i]+" ");
		System.out.println();
	}
}
class trial2{//MAIN
	public static void main(String[] args){
		Body sun = new Body();
		//sun.idNum = Body.nextID++;
		//sun.name = "Sun";
		//sun.orbits = null;
		
		sun.print();
		
		Body earth = new Body();
		//earth.idNum  = Body.nextID++;
		//earth.name = "Earth";
		//earth.orbits = sun;
		
		earth.print();
		
		Body mercury = new Body("mercury",sun);
		mercury.print();
		Body moon = new Body("moon",earth);
		moon.print();
		
		//Body venus = new Body("venus", sun);
		//venus.print();
	}
}
class RunVertex{
	public static void main(String[] args){
		Vertex A = new Vertex(1.0, 2.0);
		Vertex B = new Vertex(3.0, 4.0);
		
		Line AB = new Line(A, B);
		AB.printLine();
		System.out.println("slope is "+AB.computeSlope());
	    (AB.getStart()).setX(4.0);//state changed due to Vertex's mutators, unknown to Line class
		AB.printLine();
		System.out.println("slope is "+AB.computeSlope());
	}
	
}
class Vertex{
	double x,
			y;
	Vertex(double xVal, double yVal){ x = xVal; y = yVal;}
	double getX(){return x;}
	double getY(){return y;}
	void setX(double newVal){x = newVal;}
	void setY(double newVal){y = newVal;}
	
	double computeDistance(Vertex other){
		return Math.sqrt((x-other.x)*(x-other.x)+(y-other.y)*(y-other.y));
	}
}
class Line{
	Vertex start,
			end;
	Line(Vertex start, Vertex end){
		this.start = start;
		this.end = end;
	}
	Line(double xStart, double yStart,double xEnd,double yEnd){
		start = new Vertex(xStart, yStart);
		end = new Vertex(xEnd, yEnd);
	}
	double computeSlope(){
		return (end.y-start.y)/(end.x-start.x);
	}
	double computeLength(){
		return start.computeDistance(end);//method from Vertex class
	}
	Vertex getStart(){return start;}
	Vertex getEnd(){return end;}
	void printLine(){
		System.out.println("\nstart-x "+start.getX()+" start-y "+start.getY()+"\n end-x "+end.getX()+" end-y "+end.getY()+"\n");
	}
}
class PassRef{
	public static void main(String[] args){
		Body sirius = new Body("Sirius",null);
		
		System.out.println("before: one "+sirius);
		commonName(sirius);
		System.out.println("after: one "+sirius);
	}
	public static void commonName(Body bodyRef){
		bodyRef.setName("Dog Star");//could have done bodyRef.name if it was public
		bodyRef = null;
	}
}
class PassByValue{
	public static void main(String[] args){
		double one = 1.0;
		
		System.out.println("before: one "+one);
		halveIt(one);
		System.out.println("after: one "+one);
	}
	public static void halveIt(double arg){
		arg/=2.0;
		System.out.println("halved: arg = "+ arg);
	}
}
class Permissions{
	public boolean canDeposit,
					canWithdraw,
					canClose;
}
class Person{}
class BankAccount{
	private long number;
	private long balance;
	
	public Permissions permissionsFor(Person who){
		Permissions perm = new Permissions();
		/*perm.canDeposit = canDeposit(who);
		perm.canWithdraw = canWithdraw(who);
		perm.canClose = canClose(who);*/
		return perm;
	}
	//define the functions...
}
class Matrix1{
	public static void main(String[] args){
		int r,c,choice,status=1;
		Matrix A, B, AplusB, difference, transpose;
		
		Random rand = new Random();
		A = new Matrix(3,3);
		for(int i = 0;i<A.getRows();i++)
			for(int j = 0;j<A.getCols(); j++){
				int val = rand.nextInt(10);
				A.setElement(i, j, val);
			}
		A.printMatrix();
		
		B = new Matrix(3,3);
		for(int i = 0;i<B.getRows();i++)
			for(int j = 0;j<B.getCols(); j++){
				int val = rand.nextInt(10);
				B.setElement(i, j, val);
			}
		System.out.println();
		B.printMatrix();
		AplusB = A.addWith(B);
		System.out.println();
		AplusB.printMatrix();
		difference = A.subtract(B);
		System.out.println();
		difference.printMatrix();
		difference = B.subtract(A);
		System.out.println();
		difference.printMatrix();
		(A.getTranspose()).printMatrix();
	}
}
class Matrix{
	private int a[][];
	private int Rows, Cols;
	int getRows(){return Rows;}
	int getCols(){return Cols;}
	
	Matrix(int Rows, int Cols){this.Rows = Rows; this.Cols = Cols; a = new int[Rows][Cols];}
    Matrix(){this(3,3);}
	int getElement(int i, int j){return a[i][j];}
	void setElement(int i, int j, int newVal){a[i][j] = newVal;}
	boolean findElement(int element){
		boolean isthere = false;
		for(int i = 0; i<Rows; i++)
			for(int j = 0; j<Cols; j++)
				if (a[i][j] == element){isthere = true;break;}
		return isthere;
	}
	void printMatrix(){
		for(int i = 0 ;i<getRows(); i++){
			//System.out.print("|");
			for(int j = 0; j<getCols(); j++){
				System.out.print(getElement(i,j));
				//if(j<getCols()-1)
					System.out.print("\t");
			}
			System.out.println("\n");
		}
	}
	Matrix addWith(Matrix other){
		Matrix m;
		if(this.getRows()==other.getRows() && this.getCols()==other.getCols()){
				m = new Matrix(getRows(),getCols());
				for(int i = 0; i<getRows(); i++)
					for(int j = 0; j<getCols(); j++){
							m.setElement(i,j,this.getElement(i,j)+other.getElement(i,j));
					}
		return m;
		}
		else{
			System.out.println("Here for A and B, Rows and columns does not match! Invalid Operation");
			return null;
		}
	}
	Matrix subtract(Matrix other){
		Matrix m;
		if(this.getRows()==other.getRows() && this.getCols()==other.getCols()){
				m = new Matrix(getRows(),getCols());
				for(int i = 0; i<getRows(); i++)
					for(int j = 0; j<getCols(); j++){
							m.setElement(i,j,this.getElement(i,j)-other.getElement(i,j));
					}
		return m;
		}
		else{
			System.out.println("Here for A and B, Rows and columns does not match! Invalid Operation");
			return null;
		}
	}
	Matrix getTranspose(){
		Matrix m;
		m = new Matrix(getCols(),getRows());
		for(int i =0; i<m.getRows(); i++)
			for(int j = 0; j<m.getCols(); j++)
				m.setElement(i,j,this.getElement(j,i));
		return m;
	}
};
class MediaTest{//MAIN
	public static void main(String[] args){
		MediaPlayer bpl = new MediaPlayer("BPL");
		
		MediaPlayer sansui = new MediaPlayer("Sansui");
		
		System.out.println("BPL type is "+bpl.getType());
		System.out.println("Sansui type is "+sansui.getType());
		System.out.println("Sansui color is "+sansui.getColor());
		System.out.println("types are equal is "+bpl.isIdentical(sansui));
		System.out.println(sansui.getType());
		System.out.println(bpl.getType());
	}
}
class MediaPlayer{
	private String Name;
	private String Type;
	private String Color;
	private boolean FMsupported = false;
	
	MediaPlayer(String name, String type, String col){
		this(name, type); Color = col;
	}
	MediaPlayer(String name,  String type){
		Name = name; Type = type; Color = "gray";
	}
	MediaPlayer(String comp_name){
		Name = comp_name; Type = "Radio";
	}
	String getName(){return Name;}
	String getType(){return Type;}
	String getColor(){return Color;}
	
	void setType(String newType){Type = newType;}
	boolean isRadio(){return Type.equals("Radio");}
	boolean isIdentical(MediaPlayer another){return this.getType().equals(another.getType());}
}
class TriangleTest{//MAIN
	public static void main(String[] args){
		Triangle t1 = new Triangle(3,4,5);
		Triangle t2 = new Triangle(3);
		Triangle t3 = new Triangle(3);
		
		System.out.println("Perimeter of t1 = "+t1.computePerimeter());
		System.out.println("Perimeter of t2 = "+t2.computePerimeter());
		System.out.println("Perimeter of t3 = "+t3.computePerimeter());
	}
}
class Triangle{
	double side1, side2, side3;
	
	Triangle(double a, double b, double c){
		side1 = a; side2 = b; side3 = c;
	}
	
	Triangle(double a){
		side1 = side2 = side3 = a;
	}
	
	Triangle(){
		side1 = side2 = side3 = 1.0d;
	}
	double getSide1(){return side1;}
	double getSide2(){return side2;}
	double getSide3(){return side3;}
	
	void setSide1(double newval){side1 = newval;}
	void setSide2(double newval){side2 = newval;}
	void setSide3(double newval){side3 = newval;}
	
	double computePerimeter(){
		return side1 + side2 + side3;
	}
}
class Body{
	private long idNum;
	private String name = "<unnamed>";
	private Body orbits = null;

	private static long nextID = 0;//was public earlier
	
	Body(){idNum = ++nextID;}//pre and post increment difference;
    Body(String bodyName){this(bodyName, null);}
	Body(String bodyName, Body orbitsAround){this();name = bodyName;orbits = orbitsAround;}		
	Body(Body other){idNum = other.idNum; name = other.name; orbits = other.orbits;}//copy constructor
	
	public long getID(){return idNum;}
	public String getName(){return name;}
	public void setName(String newName){name = newName;}
	public Body getOrbits(){return orbits;}
	public void setOrbits(Body orbitsAround){orbits = orbitsAround;}
	public void capture(Body victim){ victim.orbits = this;}//victim's private member accessed by 'this' another object
	public void print(){
		System.out.println("idNum   "+idNum+" name  "+name+" orbits  "+(orbits== null? "none":orbits.name));
	}
	public void printAll(){
		for(int i = 1;i<=nextID; i++){
			//...
		}
	}
	public String toString(){//default toString() is available to each class
		String desc = idNum + " ("+name +")";
		if(orbits != null)
			desc += " orbits" + orbits.toString();//recursive call
		return desc;
	}
}
class Date1{
	public static void daTe(){
		java.util.Date now = new java.util.Date();
		System.out.println(now);
	}
}
@SuppressWarnings("serial")
class BadDataSetException extends Exception {}

class MyUtilities{
	/*public double[] getDataSet(String setName)
		throws BadDataSetException
	{
		String file = setName + ".dset";
		FileInputStream in = null;
		try{
			in = new FileInputStream(file);
			return readDataSet(in);
		}
		catch(IOException e){
			throw new BadDataSetException();
		}
		finally {
			try{
				if(in != null)
					in.close();
			}
			catch(IOException e){;}
		}
	}*/
}
interface Lookup{
	Object find(String name);
	public void setName(String s, int a);
}
class SimpleLookup implements Lookup{
	private ArrayList<String> names = new ArrayList<String>() ;
	private ArrayList<Object> values = new ArrayList<Object>();
	public Object find(String name){
		for(int i = 0; i<names.size(); i++){
			if((names.get(i)).equals(name))
				return values.get(i);
		}
		return null;
	}
	public void setName(String s, int a){
		names.add(s); values.add(a);
	}
	void processValues(ArrayList<String> names, Lookup table){
		/*for(int i = 0; i<names.size(); i++){
			Object value = table.find(names.get(i));
			if(value != null)
				System.out.println("here");
				setName(names.get(i), (int)value);
		}*/
	}
	void printAll(){
		for(int i = 0 ; i<names.size(); i++)
			System.out.println("Name is "+names.get(i)+" value is "+ values.get(i));
	}
}
class Pixel extends Point{
	//Color color;
	public void clear(){
		super.clear(0,0); //takes two arguments
		//color = null;
	}
}
class StringsDemo{
	static public void demo(String[] args){
		String myName = "Petronius";
		String occupation = "Reorganization Specialist";
		
		myName += " Arbiter";
		myName += " ";
		myName += "(" + occupation + ")";
 
		System.out.println("Name = " + myName);
	}
	static public void demo1(){
		Object oref = new Pixel();
		oref = "Some String";
		
		System.out.println(oref);
		
		String name = "Abhi";
		Object obj = name;
		
		System.out.println(obj);
		
		name = (String)obj;//TYPE CAST NECESSARY.
	}
}
class ArrayListExample{
	public static void example(String a[]){
		ArrayList<String> List = new ArrayList<String>();//generic-type like String, Integer, Float, Double allowed instead of int, float, double; wrapper/boxing/unboxing
		List.add("Ramesh");
		System.out.println("Length of array now is "+ List.size());
		List.add("Kishore");
		System.out.println("Length of array now is "+ List.size());
		List.add("Siva");
		System.out.println("Length of array now is "+ List.size());
		
		for(int i = 0; i<List.size(); i++)
			System.out.println(List.get(i));
	}
}
class Deck{
	public static final int DECK_SIZE = 52;
	
	/*private Card[] cards = new Card[DECK_SIZE];
	public void print(){
		for(int i = 0; i< cards.length; i++)
			System.out.println(cards[i]);
	}*/
	//...
	static double average(int[] values){
		if(values == null || values.length == 0)
			throw new IllegalArgumentException();
		else{
			double sum = 0.0;
			for(int i = 0; i<values.length; i++)
				sum += values[i];
			return sum / values.length;
		}
	}
}
class Point{
	public static Point origin  =  new Point();
	public double xCo , yCo;
	Point(){xCo = 0.0f; yCo = 0.0f;}
	Point(double x, double y){xCo = x; yCo = y;}
	double getX(){return xCo;}
	double getY(){return yCo;}
	void setX(double val){xCo = val;}
	void setY(double val){yCo = val;}
	
	double getNorm(){return Math.sqrt(xCo*xCo + yCo*yCo);}
	public void clear(double xCo, double yCo){this.xCo = xCo; this.yCo = yCo;}
	public double distance(Point that){
		double xdiff = xCo - that.xCo;
		double ydiff = yCo - that.yCo;
		return Math.sqrt(xdiff*xdiff + ydiff*ydiff);
	}
}
class Numbers{//A KINDA WRAPPER CLASS FOR INTEGERS
	private int Num;
	Numbers(int n){Num = n;}
	
	public int intValue(){
		return Num;
	}
	void printPrimeList(){
		long[] Primes  = new long[Num];
		int count  = 0;
		boolean isPrime =  true;
		for(int  i = 2; i<=Num ; i++){
			isPrime = true;
			for(int j = 2; j<= Math.sqrt(i); j++){
				if(i%j == 0){
					isPrime = false;
					break;
				}
			}
			if(isPrime) {Primes[count++] = i;}
		}
		for (int i = 0; i < count; i++)
			System.out.println(Primes[i]);
	}
	double computePower(int n){
		if(n > 1) return Num * computePower(n-1);
		else if(n<0) return 1.0/computePower(-n);
		else return (n == 0? 1.0 : Num);
	}
	long compuetfactorial(){
		long result = 1;
		for(int j = 2; j<= Num ; result *= j, j++);
		return result;
	}
}

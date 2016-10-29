import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import static java.lang.System.out;

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
		Ramesh.addATMCard(rameshcard);
		out.println(Ramesh);
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
public class ArrayStack{
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

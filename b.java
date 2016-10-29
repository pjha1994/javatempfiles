import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import static java.lang.System.out;               
class StackX
   {
   private int maxSize;
   private char[] stackArray;
   private int top;
   public StackX(int s)       
      {
      maxSize = s;
      stackArray = new char[maxSize];
      top = -1;
      }
   public void push(char j) 
      {
      stackArray[++top] = j;
      }
   public char pop()         
      {
      return stackArray[top--];
      }
   public char peek()        
      {
      return stackArray[top];
      }
   public boolean isEmpty()   
      {
      return (top == -1);
      }

   } 
class BracketChecker
   {
   private String input; 
   private int sum = 0;   
   public BracketChecker(String in)        
      { input = in; }
   public int check()
      {
      int stackSize = input.length();      
      StackX theStack = new StackX(stackSize);  

      for(int j=0; j<input.length(); j++)  
         {
         char ch = input.charAt(j);        
         switch(ch)
            {
            case '(':
               theStack.push(ch);          
               break;
            case ')':
               if( !theStack.isEmpty() )  
                  {
                  char chx = theStack.pop(); 
                  if(ch==')' && chx=='(')
					   sum++;
                  }                       
               break;
            default:    
               break;
            } 
         } 
      /*if( !theStack.isEmpty() )
		  return;*/
	  return sum*2;
      }
   } 
class BracketsApp
   {
   public static void main(String[] args) throws IOException
      {
		  Scanner scan = new Scanner(System.in);
		  int T = scan.nextInt();
		  ArrayList<String> s  = new ArrayList<String>();
          String input="";
	  for(int i = 0;i<T;i++)
	       s.add(new String(scan.next()));
      for(int i =0;i<T;i++){
         input = s.get(i);     
         if( input.equals(null)) {  
		    System.out.println(0);
            continue;     
         }  
		 BracketChecker theChecker = new BracketChecker(input);
         System.out.println(theChecker.check()); 
      }  
   /*public static String getString() throws IOException
      {
      InputStreamReader isr = new InputStreamReader(System.in);
      BufferedReader br = new BufferedReader(isr);
      String s = br.readLine();
      return s;
      }*/
   }
   }
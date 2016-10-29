import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import static java.lang.System.out;
class Link{
	private String name;
	private int val;
	Link next;
	Link(String name, int val){
		this.name = name;
		this.val = val;
	}
	String getName(){
		return name;
	}
	int getValue(){
		return val;
	}
}
class linkList{
	Link first;
	Link last;
	/*linkList(){}
	linkList(Link first,Link last){
		this.first = first;
		this.last = last;
	}*/
	void insertLink(Link newLink){
		if(first==null)
			first = newLink;
		else
			last.next = newLink;
		last = newLink;
	}
	void printList(){
		Link x = first;
		while(x!=null){
			System.out.println("Name  is : "+x.getName()+" and the value is : "+x.getValue());
			x = x.next;
		}
	}
}
class runNow{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		out.println("enter name and values");
		int b = 45;
		linkList newList = new linkList();
		while(b!=0){
			String a = scan.next();
			b = scan.nextInt();
			Link newLink = new Link(a,b);
			if(b!=0)
				newList.insertLink(newLink);
		}
		newList.printList();
		newList.printList();
	}
}

class Node {
	int data;
	Node next;
	Node(int d) {
        data = d;
        next = null;
    }
}

class Solution20 {//Another Link List implementation
    static Node head;
    static Node last1;
    public static  Node insert(Node head1,int data) {
        //Complete this method
        head1 = new Node(data); 
        if(head == null)
            head = head1;
        else
            last1.next = head1;
        last1 = head1;
        return head;
    }
public static void display(Node head) {
        Node start = head;
        while(start != null) {
            System.out.print(start.data + " ");
            start = start.next;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Node head = null;
        int N = sc.nextInt();

        while(N-- > 0) {
            int ele = sc.nextInt();
            head = insert(head,ele);
        }
        display(head);
        sc.close();
    }
}
import java.util.*;

class Node{
	int data;
	Node next;
	Node(int d){
        data=d;
        next=null;
    }
	
}
class Solution
{

    public static Node removeDuplicates(Node head) {
        //If node is not initialized or there is a single element on the list
        //we dont have to do anything
        //only return the node itself
        if(head == null) return  head;
        else if(head.next == null) return head;
        //if we got consectutive elements
        else if(head.data == head.next.data){
            head.next = findNextElement(head);
            removeDuplicates(head.next);
        }
        //Move on the list
        else removeDuplicates(head.next);     
    
             
        return head;
    }
    
    public static Node findNextElement(Node head){
        Node nextElement = head.next;
        while(head.data == nextElement.data){
            nextElement = findNextElement(head.next);
        }
        
        return nextElement;
        
        
    }

	 public static  Node insert(Node head,int data)
     {
        Node p=new Node(data);			
        if(head==null)
            head=p;
        else if(head.next==null)
            head.next=p;
        else
        {
            Node start=head;
            while(start.next!=null)
                start=start.next;
            start.next=p;

        }
        return head;
    }
    public static void display(Node head)
        {
              Node start=head;
              while(start!=null)
              {
                  System.out.print(start.data+" ");
                  start=start.next;
              }
        }
        public static void main(String args[])
        {
              Scanner sc=new Scanner(System.in);
              Node head=null;
              int T=sc.nextInt();
              while(T-->0){
                  int ele=sc.nextInt();
                  head=insert(head,ele);
              }
              head=removeDuplicates(head);
              display(head);

              sc.close();

       }
    }
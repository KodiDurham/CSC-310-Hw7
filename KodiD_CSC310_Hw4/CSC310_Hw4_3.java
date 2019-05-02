
import java.util.*;

class LinkedQueue{
    private Node head;              //Keeps track of the head of the list
    private Node tail;              //Keeps track of the tail of the list
    private int size;               //Keeps track of the size of the list
    
    /////////Nested Node Class/////////
    //Keeps the element and the next elements location
    private class Node{             
        private int element;
        private Node next;
        
        Node(int e, Node n){        //sets the nodes element and next one
            element=e;
            next=n;
        }
    }
    
    //constructor
    public LinkedQueue(){
        head=null;                  //sets head to a null                 
        tail=null;                  //sets tail to a null
        size=0;                     //sets size to 0
    }
    
    public int len(){               //returns the size
        return size;
    }
    
    public boolean isEmpty(){       //returns if list is empty
        return size==0;
    }
    
    public int first(){             //returns the fist element w/o removing
        if(isEmpty())
            throw new NoSuchElementException();
        
        return head.element;
    }
    
    public int last(){              //returns the last element w/o removing
        if(isEmpty())
            throw new NoSuchElementException();
        
        return tail.element;
    }
    
    //returns the first element while removing
    public int dequeue(){          
        if(isEmpty())
            throw new NoSuchElementException();
        
        int out = head.element;     //stores element so it can be removed
        head = head.next;           //sets head as next node
        size-=1;                    //reduce size
        
        //makes sure if the list is empty that the tell is null
        if(isEmpty())               
            tail=null;
            
        return out;   
    }
    
    public void enqueue(int e){     //places element in the new tail postion
        Node newN=new Node(e,null);
        
        if(isEmpty())
            head=newN;
        else
            tail.next=newN;
        tail=newN;
        size+=1;
    }
    
    //searches the list for key and returns if its in or not
    public boolean search(int key){
        Node c = head;
        while(c!=null){
            if(c.element==key)
                return true;
            c=c.next;
        }
        return false;
    }
}

public class CSC310_Hw4_3 {
    public static void main(String[] args) {
        LinkedQueue a= new LinkedQueue();
        a.enqueue(1);
        a.enqueue(2);
        a.enqueue(3);
        a.enqueue(4);
        a.enqueue(5);
        a.enqueue(6);
        System.out.println(a.isEmpty());                //false
        System.out.println(a.search(1));                //true
        System.out.println(a.search(2));                //true
        System.out.println(a.search(3));                //true
        System.out.println(a.search(4));                //true
        System.out.println(a.search(5));                //true
        System.out.println(a.search(6));                //true
        System.out.println(a.search(7));                //false
        a.dequeue();
        System.out.println(a.search(1));                //false
        a.enqueue(1);
        System.out.println(a.search(1));                //true
        System.out.println("size: "+a.len());           //6
        a.dequeue();
        System.out.println("size: "+a.len());           //5
        System.out.println("First: "+a.first());        //3
        a.dequeue();
        System.out.println("First: "+a.first());        //4
        System.out.println(a.dequeue());                //4
        System.out.println(a.dequeue());                //5
        System.out.println(a.dequeue());                //6
        System.out.println(a.dequeue());                //1
        System.out.println(a.isEmpty());                //true
    }   
}

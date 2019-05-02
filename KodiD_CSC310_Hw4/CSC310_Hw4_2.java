/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;

class LinkedQueue{
    private Node head;              //Keeps track of the head of the list
    private Node tail;              //Keeps track of the tail of the list
    private int size;               //Keeps track of the size of the list
    
    /////////Nested Node Class/////////
    private class Node{             //Keeps the element and the next elements location
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
    
    public int dequeue(){           //returns the first element while removing
        if(isEmpty())
            throw new NoSuchElementException();
        
        int out = head.element;     //stores element so it can be removed
        head = head.next;           //sets head as next node
        size-=1;                    //reduce size
        
        if(isEmpty())               //makes sure if the list is empty that the tell is null
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
    
    //function to merges two lists into new lists
    public LinkedQueue mergeQueues(LinkedQueue a, LinkedQueue b){
        LinkedQueue c = new LinkedQueue();      //creates a new list
        
        //keeps the merge goint until the lists are empty
        while((!a.isEmpty())||(!b.isEmpty())){
            if((!a.isEmpty()) && (!b.isEmpty()))//for checking which one is lower
                if(a.first()<= b.first())       //for when the first a is less then b first
                    c.enqueue(a.dequeue());
                else                            //for when its not
                    c.enqueue(b.dequeue());
            else if(a.isEmpty())                //for when or or the other is more
                c.enqueue(b.dequeue());
            else
                c.enqueue(a.dequeue());
        }
        return c;
    }
}

public class CSC310_Hw4_2 {
    public static void main(String[] args) {
        LinkedQueue a= new LinkedQueue();
        a.enqueue(1);
        System.out.print("["+a.last()+", ");
        a.enqueue(2);
        System.out.print(a.last()+", ");
        a.enqueue(4);
        System.out.println(a.last()+"]");
        
        LinkedQueue b= new LinkedQueue();
        b.enqueue(1);
        System.out.print("["+b.last()+", ");
        b.enqueue(3);
        System.out.print(b.last()+", ");
        b.enqueue(4);
        System.out.println(b.last()+"]");
        
        a=a.mergeQueues(a, b);
        while(!a.isEmpty())
            System.out.println(a.dequeue());
    }  
}

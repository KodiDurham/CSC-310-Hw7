import java.util.LinkedList;
import java.util.Scanner;

class LinkedStack{
    private String stackName;
    private LinkedList<Integer> l;
    private int n;
    
    LinkedStack(String name){
        stackName=name;
        l=new LinkedList<>();
        n =0;   
    }
    
    public void push(int num){
        l.add(num);
        n++;
    }
    
    public int size(){
        return n;
    }
    
    public int top(){
        return l.get(n-1);
    }
    
    public int pop(){
        if(n>=0){
            int out = top();
            l.remove(n-1);
            n--;
            return out;
        }else
            return -1;
    }
    
    public String name(){
        return stackName;
    }
}
public class CSC310_Hw5_1 {
    static void towerOfHanoi(int n, LinkedStack first,LinkedStack mid,LinkedStack last){
        if(n==1){
            System.out.println("Move disk "+first.top()+" from peg "+first.name()+" to peg "+last.name());
            last.push(first.pop());
            return;
        }
       
        towerOfHanoi(n-1,first, last, mid);
        
        System.out.println("Move disk "+first.top()+" from peg "+first.name()+" to peg "+last.name());
        last.push(first.pop());
        
        towerOfHanoi(n-1,mid, first, last);
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        while(true){
            try{
                LinkedStack a= new LinkedStack("A");
                LinkedStack b= new LinkedStack("B");
                LinkedStack c= new LinkedStack("C");
                
                System.out.print("Enter integer: ");
                int num = input.nextInt();
                
                for (int i = num; i > 0; i--) {
                    a.push(i);
                }
                
                towerOfHanoi(num, a, b, c);
                System.out.println("");
                
            }catch(Exception e){
                System.out.println("Goodbye!");
                break;
            }
        }      
    }   
}

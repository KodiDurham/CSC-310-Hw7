
import java.util.LinkedList;
import java.util.Scanner;

class Stack{
    
    private LinkedList<String> l;
    private int n;
    
    Stack(){
        l=new LinkedList<>();
        n =0; 
    }
    
    //add new element to stack
    public void push(String c){
        l.add(c);
        n=n+1;
    }
    
    //returns the size of stack
    public int size(){
        return n;
    }
    
    //returns and takes out what is on top of stack
    public String pop(){
        if(n>=0){
            String s = top();
            l.remove(n-1);
            n--;
            return s;
        }else
            return "Stack is empty";
    }
    
    //returns what is on top of stack
    public String top(){
        return l.get(n-1);
    }
    
    //clears stack
    public void emptyStack(){
        l.clear();
    }
    
//    public String toString(){
//        String s=""+l.get(0);
//        for (int i = 1; i < n; i++) {
//            s+=", "+l.get(i);
//        }
//        return s;
//    }
}
public class CSC310_HW_3_3 {
    static Stack valStk= new Stack();
    
    // checks if number
    static boolean isNumeric(String c){
        try{
            Integer.parseInt(c);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    
    static void ops(String s){
        double y = Double.parseDouble(valStk.pop());
        double x = Double.parseDouble(valStk.pop());
        
        switch(s){
            case "+":
                valStk.push(""+(x+y));
                break;
            case "-":
                valStk.push(""+(x-y));
                break;
            case "*":
                valStk.push(""+(x*y));
                break;
            case "/":
                valStk.push(""+(x/y));
                break;
        }
    }
    
    static String EvalExp(String s){
        while(s.length()>0) {
            if(isNumeric(s.substring(0,1))){ 
                valStk.push(s.substring(0,1));
            }else
                ops(s.substring(0,1));
            
            s=s.substring(1);
        }
        
        
        return valStk.top();
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Please enter postfix expression: ");
        System.out.println(EvalExp(input.next()));
    }
    
}

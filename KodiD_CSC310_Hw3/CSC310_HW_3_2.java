
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

public class CSC310_HW_3_2 {
    static Stack valStk= new Stack();
    static Stack opStk= new Stack();
    
                                    //Makes theexpressions with two signs into the one with one
    static String toOne(String s){
        switch(s){
            case "<=":          //less then or equal to
                return "\u2264";
            case ">=":          //greater then or equal to
                return "\u2265";
            case "!=":          //not equal to
                return "\u2260";
            default:
                return "ERROR";
        }
    }
    
    static int prec(String s){
        switch(s){
            case "+":
                return 2;
            case "-":
                return 2;
            case "*":
                return 3;
            case "/":
                return 3;
            case "=":
                return 1;
            case ">":
                return 1;
            case "<":
                return 1;
            case "\u2264":      //less then or equal to
                return 1;
            case "\u2265":      //greater then or equal to
                return 1;
            case "\u2260":      //not equal to
                return 1;
            case "$":      
                return 0;
            default:
                return 0;
        }
    }
                        // does op
    static void doOp(){
        double y = Double.parseDouble(valStk.pop());
        double x = Double.parseDouble(valStk.pop());
        
        switch(opStk.pop()){
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
            case ">":
                valStk.push(""+(x>y));
                break;
            case "<":
                valStk.push(""+(x<y));
                break;
            case "=":
                valStk.push(""+(x==y));
                break;
            case "\u2264":          //less then to equak to
                valStk.push(""+(x<=y));
                break;
            case "\u2265":          //greater then or equal to
                valStk.push(""+(x>=y));
                break;
            case "\u2260":          //not equal
                valStk.push(""+(x!=y));
                break;
            default:
                System.out.println("Not an op"); 
        }
        
    }
    
                                        // decides when to use doOp
    static void repeatOps(String op){
        if(( opStk.size() > 1 && prec(op) <= prec(opStk.top()))){
            doOp();    
        }
        if(op == "$" && valStk.size()==2){
            doOp();
        }
        if(op != "$")
            opStk.push(op);
    }
    
                                            // checks if number
    static boolean isNumeric(String c){
        try{
            Integer.parseInt(c);
            return true;
        }catch(Exception e){
            return false;
        }
    }
                                            // send string to to evaluated
    static String EvalExp(String s){
        while(valStk.size()<=0 || opStk.size()<=0 ){
            if(isNumeric(s.substring(0,1))){            
                if(isNumeric(s.substring(1,2))){        //to handle numbers with multiple digits
                    valStk.push(s.substring(0,2));
                    s=s.substring(2);
                }
                else{
                    valStk.push(s.substring(0,1));
                    s=s.substring(1);
                }
            }
            else{
                if(!(isNumeric(s.substring(1,2)))){
                    String s2= toOne(s.substring(0,2));
                    opStk.push(s2);
                    s=s.substring(2);
                }
                else{   
                    opStk.push(s.substring(0,1));
                    s=s.substring(1);
                }
            }
        }
        
        while(s.length()>0){
            if(isNumeric(s.substring(0,1))){
                if(s.length()>1 && isNumeric(s.substring(1,2))){
                    valStk.push(s.substring(0,2));
                    s=s.substring(2);
                }
                else{
                    valStk.push(s.substring(0,1));
                    s=s.substring(1);
                }
            }
            else{
                if(s.length()>1 && !(isNumeric(s.substring(1,2)))){
                    String s2= (s.substring(0,2));
                    repeatOps(s2);
                    s=s.substring(2);
                }
                else{
                    repeatOps(s.substring(0,1));
                    s=s.substring(1);
                    
                }
            }
            
        }
        while(valStk.size()>1)
            repeatOps("$");
        
        return valStk.top();
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter Expression: ");
        System.out.println(EvalExp(input.next()));
    }
}

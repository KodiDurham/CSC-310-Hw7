import java.util.LinkedList;
import java.util.Scanner;
    
class MinStack{
    
    private LinkedList<Integer> l =new LinkedList<Integer>();
    private int n =-1;
    
    //add new element to stack
    void push(int num){
        l.add(num);
        n++;
        
    }
    
    //removes top element of stack
    void pop(){
        if(n>=0){
            l.remove(n);
            n--;
        }
    }
    
    //returns min in stack
    int getMin(){
        int min=l.get(0);
        for (int i = 0; i < n+1; i++) {
            if(min > l.get(i)) {
                min = l.get(i);
            }
        }
        return min;
    }
    
    //returns what is on top of stack(does not take off of stack)
    int top(){
        return l.get(n);
    }
    
    //empty stack
    void emptyStack(){
        l.clear();
    }
}
        
public class csc310_hw_3_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // simple menu for easy use
        Scanner input = new Scanner(System.in);
        String choice = "";
        MinStack minStack = new MinStack();
        
        do{
            System.out.println("1. Run Demo");
            System.out.println("2. Push");
            System.out.println("3. Pop");
            System.out.println("4. Top");
            System.out.println("5. Get Min");
            System.out.println("6. Empty Stack");
            System.out.println("e. Exit");
            System.out.print("Pick an option from the menu above:");
            choice = input.next();
          
            switch(choice.charAt(0)){
                case '1':
                    minStack.emptyStack();
        
                    minStack.push(-2);
                    minStack.push(0);
                    minStack.push(-3);
        
                    System.out.println(minStack.getMin());
        
                    minStack.pop();
        
                    System.out.println(minStack.top());
                    System.out.println(minStack.getMin());
                    
                    minStack.emptyStack();
                    break;
                  
                case '2':
                    System.out.print("Enter integer: ");
                    minStack.push(input.nextInt());
                    break;
                    
                case '3':
                    try{
                        minStack.pop();
                    }catch(Exception e){
                        System.out.println("Stack is empty");
                    }
                    break;
                    
                case '4':
                    try{
                        System.out.println(minStack.top());
                    }catch(Exception e){
                        System.out.println("Stack is empty");
                    }
                    break;
                    
                case '5':
                    try{
                        System.out.println(minStack.getMin());
                    }catch(Exception e){
                        System.out.println("Stack is empty");
                    }
                    break;
                
                case '6':
                    try{
                        minStack.emptyStack();
                    }catch(Exception e){
                        System.out.println("Stack is empty");
                    }
                    break;
                    
                case 'e': case 'E':
                    System.out.println("Goodbye!");
                    break;
                  
                default:
                    System.out.println("You entered an invalid menu choice.  Please try agin.");
                    break;
            }
            
            System.out.println("");
        } while (choice.charAt(0)!='e' && choice.charAt(0) != 'E');
//        
//        
//        MinStack minStack = new MinStack();
//        minStack.top();
//        
//        minStack.push(-2);
//        minStack.push(0);
//        minStack.push(-3);
//        
//        System.out.println(minStack.getMin());
//        
//        minStack.pop();
//        
//        System.out.println(minStack.top());
//        System.out.println(minStack.getMin());
    } 
}


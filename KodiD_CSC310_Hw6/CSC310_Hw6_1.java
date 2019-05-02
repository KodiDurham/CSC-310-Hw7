
import java.util.LinkedList;
import java.util.Scanner;

class PriorityQueue{
    private LinkedList<Item> l = new LinkedList<Item>();
    
    class Item{
        int key;
        Object value;
        
        Item(int k, Object v){
            key=k;
            value=v;
        }
    }
    
    public void add(int k, Object v){
        Item newest=new Item(k,v);
        if(!(l.isEmpty())){
            Item walk= l.getLast();
            while(walk !=null && k<walk.key){
                if(l.indexOf(walk)-1<0){
                    walk=null;
                }else
                    walk =l.get(l.indexOf(walk)-1);
            }
            if(walk==null){
                l.addFirst(newest);
            }else
                l.add(l.indexOf(walk)+1, newest);
        }else{
            l.add(newest);
        }
    }
    
    public int size(){
        if(l.isEmpty())
            return 0;
        return l.size();
    }
    
    public Object min(){
        if (l.isEmpty())
            return null;
        return l.getFirst().value;
    }
    
    public Object removeMin(){
        if(l.isEmpty())
            return null;
        Item out = l.removeFirst();
        return out.value;
    }
}
public class CSC310_Hw6_1 {

    public static void main(String[] args) {
        // simple menu for easy use
        Scanner input = new Scanner(System.in);
        String choice = "";
        PriorityQueue pq = new PriorityQueue();
        
        do{
            System.out.println("1. Run Demo");
            System.out.println("2. Add to queue");
            System.out.println("3. Get Min");
            System.out.println("4. Remove Min");
            System.out.println("5. Get size");
            System.out.println("e. Exit");
            System.out.print("Pick an option from the menu above:");
            choice = input.next();
          
            switch(choice.charAt(0)){
                case '1':
                    PriorityQueue pqDemo = new PriorityQueue();
                    System.out.println("Sequence: 7 => 4 => 8 => 2 => 5 => 3 => 9");
                    System.out.println("");
                    pqDemo.add(7, 7);
                    pqDemo.add(4, 4);
                    pqDemo.add(8, 8);
                    pqDemo.add(2, 2);
                    pqDemo.add(5, 5);
                    pqDemo.add(3, 3);
                    pqDemo.add(9, 9);
                    
                    int size=pqDemo.size();
                    System.out.print("Priority: ");
                    for (int i = 0; i < size; i++) {
                        System.out.print(pqDemo.removeMin());
                        if(i < size-1){
                            System.out.print(" => ");
                        }
                    }
                    System.out.println("");
                    break;
                case '2':
                    System.out.print("Enter key: ");
                    int key = input.nextInt();
                    
                    System.out.print("Enter object: ");
                    String value=input.next();
                    
                    try{
                        int intval=Integer.parseInt(value);
                        pq.add(key, intval);
                    }catch(Exception e){
                        pq.add(key, value);
                    }
                    break;
                    
                case '3':
                    Object min=pq.min();
                    if(min==null)
                        System.out.println("Queue is Empty");
                    else
                        System.out.println("Min Without Removing: "+ min);
                    break;
                    
                case '4':
                    Object minR=pq.min();
                    if(minR==null)
                        System.out.println("Queue is Empty");
                    else
                        System.out.println("Min Without Removing: "+ minR);
                    break;
                    
                case '5':
                    System.out.println("Size: "+pq.size());
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
    } 
}

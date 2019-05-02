
import java.util.Scanner;


class MaxHeap{
    private int[] heapa;
    
    public int size(){
        return heapa.length;
    }
    
    public int[] inPlaceHeapSort(int[] array){
        heapa=array;
        
        int size=heapa.length;
        for (int i = size/2-1; i >= 0; i--) {
            heap(size, i);
            
        }
        
        for (int i = size-1; i >=0; i--) {
            int t =heapa[i];
            heapa[i]=heapa[0];
            heapa[0]=t;
            
            heap(i,0);
        }
        
        return heapa;
    }
    
    private void heap(int size, int root){
         
    int max = root;
    int l= root*2+1;
    int r= root*2+2;
    
    //finding the largest of the 3 numbers within the heap
    if(!(l>=size) && heapa[l]>heapa[max])
        max=l;
    if(!(r>=size) && heapa[r]>heapa[max])
        max=r;
    
    int t = heapa[max];
    heapa[max]= heapa[root];
    heapa[root]=t;
    
    //to cheack its max
    if (max != root)
        heap(size, max);
    }
    
    public int removeMax(){
        int[] t=  new int[heapa.length-1];
        for (int i = 0; i < t.length; i++) {
            t[i]=heapa[i];
        }
        int out = heapa[heapa.length-1];
        heapa=t;
        return out;
    }
}

public class CSC310_Hw6_2 {

    public static void main(String[] args) {
        // simple menu for easy use
        Scanner input = new Scanner(System.in);
        String choice = "";
        MaxHeap mh = new MaxHeap();
        
        
        do{
            System.out.println("1. Run Demo");
            System.out.println("2. Make heap");
            System.out.println("3. remove max");
            System.out.println("4. Empty heap");
            System.out.println("e. Exit");
            System.out.print("Pick an option from the menu above:");
            choice = input.next();
          
            switch(choice.charAt(0)){
                case '1':
                    MaxHeap mhDemo = new MaxHeap();
                    System.out.println("Sequence: 9 => 7 => 5 => 2 => 6 => 4");
                    System.out.println("");
                    int[] a = {9,7,5,2,6,4};
                    mhDemo.inPlaceHeapSort(a);
                    
                    int size=mhDemo.size();
                    System.out.print("Max Order: ");
                                                //
                    for (int i = 0; i < size; i++) {
                        System.out.print(mhDemo.removeMax());
                        if(i < size-1){
                            System.out.print(" => ");
                        }
                    }
                    System.out.println("");
                    break;
                case '2':
                    while(true){
                        try{
                            System.out.print("Enter heap Size: ");
                            int uinput = input.nextInt();
                            
                            int[] uArray=new int[uinput];
                            for (int i=0; i < uArray.length; i++) {
                                System.out.print("Enter int: ");
                                uArray[i] = input.nextInt();
                            }
                            uArray= mh.inPlaceHeapSort(uArray);
                            for (int i = 0; i < uArray.length; i++) {
                                System.out.print(uArray[i]);
                                if(i < uArray.length-1)
                                    System.out.print(" ");
                            }
                            break;
                        }catch(Exception e){
                            break;
                        }
                    }
                    break;
                    
                case '3':
                        System.out.println("Rmoved: "+ mh.removeMax());
                    break;
                    
                case '4':
                    for (int i = 0; i < mh.size(); i++) {
                        System.out.println(mh.removeMax());
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
    }  
}


import java.util.LinkedList;
import java.util.Scanner;

class BinHeap{
    private LinkedList<Object> heap = new LinkedList<Object>();
    
    //constructors
    BinHeap(){
        
    }
    
    BinHeap(LinkedList<Object> l){
        for (int i = 0; i < l.size(); i++) {
            insert((int)l.get(i));
        }
    }
    
    //public functions
    public int size(){
        return heap.size();
    }
    
    public void insert(int in){
        heap.add(in);
        upheap(heap.size()-1);
    }
    
    public boolean isEmpty(){
        if(heap.size()<1)
            return true;
        return false;
    }
    
    public Object findMin(){
        if(heap.isEmpty())
            return null;
        return heap.get(0);
    }
    
    public Object delMin(){
        if(heap.isEmpty())
            return null;
        swap(0,heap.size()-1);
        Object min = heap.removeLast();
        downheap(0);
        return min;
    }
    
    public void buildHeap(LinkedList<Object> l){
        for (int i = 0; i < heap.size(); i++) {
            heap.remove(0);
        }
        for (int i = 0; i < l.size(); i++) {
            insert((int)l.get(i));
        }
    }
    
    //Private functions
    private int parent(int i){
        return (i-1)/2;
    }
    
    private int left(int i){
        return (i*2)+1;
    }
    
    private int right(int i){
        return (i*2)+2;
    }
    
    private boolean hasLeft(int i){
        return left(i)<heap.size()-1;
    }
    
    private boolean hasRight(int i){
        return left(i)<heap.size()-1;
    }
    
    private void swap(int j, int i){
        int t= (int)heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, t);
    }
    
    private void upheap(int i){
        int parent = parent(i);
        if((i>0) && ((int)heap.get(i)< (int)heap.get(parent))){
            swap(i,parent);
            upheap(parent);
        }
    }
    
    private void downheap(int i){
        if(hasLeft(i)){
            int left=left(i);
            int min=left;
            if(hasRight(i)){
                int right=right(i);
                if(((int)heap.get(right))<((int)heap.get(left))){
                    min=right;
                }
            }
            if((int)heap.get(min)<(int)heap.get(i)){
                swap(i,min);
                downheap(min);
            }
        }
        if(heap.size()==2 && ((int)heap.get(1))<((int)heap.get(0)))
            swap(0,1);
    }
}

public class CSC310_Hw6_3 {
    
    public static void main(String[] args) {
        BinHeap bhDemo1 = new BinHeap();
        bhDemo1.insert(5);
        bhDemo1.insert(7);
        bhDemo1.insert(3);
        bhDemo1.insert(11);

        System.out.println(bhDemo1.delMin());    //3
        System.out.println(bhDemo1.delMin());    //5
        System.out.println(bhDemo1.delMin());    //7
        System.out.println(bhDemo1.delMin());    //11
        System.out.println("");

        System.out.println("IsEmpty: "+bhDemo1.isEmpty());      //true

        bhDemo1.insert(5);
        bhDemo1.insert(7);
        bhDemo1.insert(3);
        bhDemo1.insert(11);

        System.out.println("IsEmpty: "+bhDemo1.isEmpty());      //false
        System.out.println("");

        System.out.println("Find min: "+bhDemo1.findMin());    //3
        System.out.println("Delete min: "+bhDemo1.delMin());    //3
        System.out.println("Find min: "+bhDemo1.findMin());    //5
        System.out.println("");

        System.out.println("Size: "+bhDemo1.size());        //3
        System.out.println("Delete min: "+bhDemo1.delMin());    //5
        System.out.println("Size: "+bhDemo1.size());        //2
        System.out.println("");

        LinkedList<Object> l1 = new LinkedList<Object>();
        l1.add(10);
        l1.add(4);
        l1.add(12);
        l1.add(6);
        l1.add(2);
        l1.add(7);
        l1.add(1);

        bhDemo1.buildHeap(l1);
        System.out.println(bhDemo1.delMin());    //1
        System.out.println(bhDemo1.delMin());    //2
        System.out.println(bhDemo1.delMin());    //4
        System.out.println(bhDemo1.delMin());    //6
        System.out.println(bhDemo1.delMin());    //7
        System.out.println(bhDemo1.delMin());    //10
        System.out.println(bhDemo1.delMin());    //12
        System.out.println("");

        LinkedList<Object> l2 = new LinkedList<Object>();
        l2.add(9);
        l2.add(3);
        l2.add(11);
        l2.add(5);
        l2.add(1);
        l2.add(6);
        l2.add(0);

        BinHeap bhDemo2 = new BinHeap(l2);
        System.out.println(bhDemo2.delMin());    //0
        System.out.println(bhDemo2.delMin());    //1
        System.out.println(bhDemo2.delMin());    //3
        System.out.println(bhDemo2.delMin());    //5
        System.out.println(bhDemo2.delMin());    //6
        System.out.println(bhDemo2.delMin());    //9
        System.out.println(bhDemo2.delMin());    //11
    }
}

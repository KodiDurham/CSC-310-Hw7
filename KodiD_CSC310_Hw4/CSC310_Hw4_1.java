//a circular queue
class MyCircularDeque{
    int[] deque;                        //array to store
    int f;                              //the front spot
    int r;                              //the rear spot
    int max;                            //the max size of the queue
    int size;                           //the size of queue
     
    //constructor
    MyCircularDeque(int k){
        deque = new int[k];             //sets the array size
        f=0;                            //sets front to 0
        r=0;                            //sets rear to 0
        max = k;                        //sets the max to the array's size
        size =0;                        // keeps track of the the size of queue
    }
    
    
    //inserts element in the front of the queue
    public boolean insertFront(int n){
        if(isFull())            //checks if it is full and returns that op is false
            return false;
        try{
            if(f==0)            //checks if the number is either the start or end of array
                cycleNum(f);    //changes number is so
            else
                f-=1;
            deque[f]=n;         //sets the new element
            size++;             //increases size
            return true;
        }catch(Exception e){    //catches exceptions and return a fail
            return false;
        }
    }
    
    //inserts element in the rears of the queue
    public boolean insertLast(int n){
        if(isFull())            //checks if it is full and returns that op is false
            return false;
        try{
            deque[r]=n;         //sets the new element
            if(r==max-1)        //checks if the number is either the start or end of array
                cycleNum(r);    //changes number is so
            else
                r+=1;
            size++;             //increases size
            return true;
        }catch(Exception e){    //catches exceptions and return a fail
            return false;
        }
    }
    
    //deletes the front element (just moves the f var)
    public boolean deleteFront(){
        if(isEmpty())               //checks if is empty and send fail if it is
            return false;
        try{
            if(f==max-1)            //checks if need to cycle if so it does
                cycleNum(r);
            else
                f+=1;
            size--;                 //decease size
            return true;
        }catch(Exception e){        //catches fails
            return false;
        }
    }
    
    //deletes the front element (just moves the f var)
    public boolean deleteLast(){
        if(isEmpty())               //checks if is empty and send fail if it is
            return false;
        try{
            if(isFull()){           //checks if it is full for special case of full
                size--;             //decreease size
                return true;        //sends a success
            }
            if(r==0)                //checks if it need to cycle and does so
                cycleNum(r);
            else
                r-=1;               
            size--;                 //reduce size to match
            return true;
        }catch(Exception e){        //catches fail
            return false;
        }
    }
    
    //gets the first element of queue
    public int getFront(){
        if(isEmpty())
            return -1;
        return deque[f];
    }
    
    //gets the last element of queue
    public int getRear(){
        if(isEmpty())
            return -1;
        if(r==0)
            return deque[max-1];
        return deque[r-1];
    }
    
    //checks if queue is empty
    public boolean isEmpty(){
        if(size==0)
            return true;
        return false;
    } 
    
    //checks if the queue is full
    public boolean isFull(){
        if(max==size)
            return true;
        return false;
    }
    
    //cycles number if it is the max value of array or at 0
    private void cycleNum(int num){
        if(num == f){           //for the front
            if(f == 0)
                f=max-1;
            else
                f=0;
        }else{                  //for rear
            if(r == 0)      
                r=max-1;
            else
                r=0;
        }
    }
}

public class CSC310_Hw4_1 {    
    public static void main(String[] args) {
        ///*
        MyCircularDeque cd = new MyCircularDeque(3);
        System.out.println(cd.insertLast(1));       //true
        System.out.println(cd.insertLast(2));       //true
        System.out.println(cd.insertFront(3));      //true
        System.out.println(cd.insertFront(4));      //false
        System.out.println(cd.getRear());           //2
        System.out.println(cd.isFull());            //true
        System.out.println(cd.deleteLast());        //true
        System.out.println(cd.insertFront(4));      //true
        System.out.println(cd.getFront());          //4
        //*/
        /*
        MyCircularDeque cd = new MyCircularDeque(3);
        System.out.println(cd.insertLast(1));       //true
        System.out.println(cd.insertLast(2));       //true
        System.out.println(cd.insertFront(3));      //true
        System.out.println(cd.insertFront(4));      //false
        System.out.println(cd.getRear());           //2
        System.out.println(cd.isFull());            //true
        System.out.println(cd.deleteFront());       //true
        System.out.println(cd.insertFront(4));      //true
        System.out.println(cd.getFront());          //4
        */
        /*
        MyCircularDeque cd = new MyCircularDeque(3);
        System.out.println(cd.insertLast(1));       //true
        System.out.println(cd.insertLast(2));       //true
        System.out.println(cd.insertFront(3));      //true
        System.out.println(cd.deleteFront());       //true
        System.out.println(cd.deleteFront());       //true
        System.out.println(cd.deleteFront());       //true
        System.out.println(cd.deleteFront());       //false
        */
        /*
        MyCircularDeque cd = new MyCircularDeque(3);
        System.out.println(cd.deleteFront());       //false
        System.out.println(cd.deleteLast());       //false
        */
    }   
}

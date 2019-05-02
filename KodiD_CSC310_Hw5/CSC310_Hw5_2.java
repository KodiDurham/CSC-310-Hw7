import java.util.*; 

class Node{
    int value;
    Node parent;
    Node left;
    Node right;
    
    public Node(int x){
        value=x;
        parent=null;
        right=null;
        right=null;
    }
}

class Tree{
    Node root;
    
    Tree(){
        root=null;
    }
    
    public void inOrder(Node t){
        if (t==null)
            return;
        inOrder(t.left);
        System.out.print(t.value+" ");
        inOrder(t.right);
    }
    
    public void preOrder(Node t){
        if (t==null)
            return;
        System.out.print(t.value+" ");
        preOrder(t.left);
        preOrder(t.right);
    }
    
    public void postOrder(Node t){
        if (t==null)
            return;
        postOrder(t.left);
        postOrder(t.right);
        System.out.print(t.value+" ");
    }
}

public class CSC310_Hw5_2 {
    static void toTree(Node current, LinkedList<Integer> list, int n){
        int left=n*2+1;
        int right=n*2+2;
        
        
        if(left<=list.size() && list.get(left)!=null){
            Node leftN = new Node(list.get(left));
            current.left=leftN;
            toTree(leftN, list, left);
        }
        
        if(right<list.size() && list.get(right)!=null){
            Node rightN = new Node(list.get(right));
            current.right=rightN;
            toTree(rightN, list, right);
        }
    }
    
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LinkedList<Integer> list = new LinkedList<Integer>();
        int sizeOfList=0;
        
        while(true){
            try{
                System.out.print("Enter integer: ");
                String s = input.nextLine().toLowerCase();
                if (!s.equals("null")){
                    list.add(Integer.parseInt(s));
                    sizeOfList++;
                }else
                    list.add(null);
                
            }catch(Exception e){
                break;
            }
        }
        
        Tree t = new Tree();
        t.root = new Node(list.get(0));
        
        toTree(t.root,list,0);
        
        System.out.print("Inorder: ");
        t.inOrder(t.root);
        System.out.println("");
        System.out.print("Preorder: ");
        t.preOrder(t.root);
        System.out.println("");
    }
}

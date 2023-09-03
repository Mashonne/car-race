package competition;

public class Stack {
    private Node root;

    boolean isEmpty(){
        Node node = root;
        return node == null;
    }
    //Declare  a node and insert the entered value to the node
    public void push(int data){
        Node node = new Node(data);

        //Check whether the stack is empty or not
        if (isEmpty()){
            root = node;
        }
        else{
            //take the value of the current root
            Node temp = root;
            //make the new pushed element as root
            root = node;
            //store the stored value of the previous root to the node after the root
            node.next = temp;
        }
        //System.out.println(data + " Pushed to the Stack!");

    }

    //Push method for inserting Elements
    public void pop(){
        Node node = root;
        //Check whether the stack is empty or not
        if (isEmpty()){
            System.out.println("The Stack is Empty!!");
            System.exit(1);
        }
        else{
            int poppedValue = node.data;
            root = node.next;
            //System.out.println(poppedValue + " Popped from the Stack!!");
            System.out.println("========================================");
            System.out.println("Car no. " + poppedValue +" is Eliminated from the Race!!");
            System.out.println("========================================");
            System.out.println();
        }
    }

    //Check the current root method
    public void peek(){
        Node node = root;
        if (isEmpty()){
            System.out.println("The Stack is Empty!!");
            System.exit(1);
        }
        else{
            System.out.println("The top value is " + node.data + ".");
        }
    }

    //Print the Stack
    public void printStack(){
        Node node = root;
        if (isEmpty()){
            System.out.println("The Stack is Empty!!");
            System.exit(1);
        }
        else{
            System.out.print("     ");
            while (node.next != null){
                System.out.print(node.data + " ");
                node = node.next;
            }
            System.out.println(node.data);
        }
    }

    //Reset Stack
    public void resetStack(){
        if (isEmpty()){
            //System.out.println("The Stack is Empty!!");
            System.exit(1);
        }
        root = null;
    }

    //Create Array from the stack
    public int [] createArray(int terms){
        Node node = root;
        int [] array = new int[terms];
        int i = 0;
        while (node.next != null){
            array[i] = node.data;
            node = node.next;
            i++;
        }
        array[i] = node.data;
        return array;
    }

    //Linear Search Call
    public int linearSearch(int value){
        LinearSearch ls = new LinearSearch();
        int result = ls.linearSearchStack(root, value);
        return result;
    }
}

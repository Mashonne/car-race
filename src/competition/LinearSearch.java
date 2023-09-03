package competition;

public class LinearSearch {
    public int linearSearchArray(int [] carNumbers, int value, int firstIndex){
        //Taking the length of the Array
        int size = carNumbers.length;
        for (int i = 0; i < size; i++){
            //Checking whether the value of each index match with the inputted value
            if (carNumbers[i] == value){
                return i;
            }
        }
        //Return -1 if the inputted value cannot be found in the array
        return -1;
    }

    public int linearSearchStack(Node root, int value){
        Node node = root;
        int i;
        //Check the inputted value by incrementing the node until node.next is null
        for (i = 0; node.next != null; i++){
            if (node.data == value){
                return i;
            }
            node = node.next;
        }
        //Taking the last node in the stack and check whether the value of it equal to the
        //inputted value
        if (node.data == value){
            return i;
        }
        else{
            //Return -1 if the inputted value cannot be found in the stack
            return -1;
        }
    }

    public int linearSearchQueue(Node front, int value){
        Node node = front;
        int i;
        //Check the inputted value by incrementing the node until node.next is null
        for (i = 0; node.next != null; i++){
            if (node.data == value){
                return i;
            }
            node = node.next;
        }
        //Taking the last node in the stack and check whether the value of it equal to the
        //inputted value
        if (node.data == value){
            return i;
        }
        else{
            //Return -1 if the inputted value cannot be found in the stack
            return -1;
        }
    }
}

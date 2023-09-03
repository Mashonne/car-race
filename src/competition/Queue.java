package competition;

public class Queue {
    private Node front, rear;

    Queue() {
        front = rear = null;
    }

    boolean isEmpty() {
        Node node = rear;
        return node == null;
    }

    //Enqueue Operation
    public void enQueue(int data) {
        Node node = new Node(data);
        //Check whether the queue is empty or not
        if (isEmpty()) {
            //Assign the value of the node to the front and rear of the queue
            front = rear = node;
        } else {
            //Assign the data of newly created node to the rear.next
            rear.next = node;
            //Make the newly created node as the new rear
            rear = node;
        }
        //System.out.println(data + " Enqueued to the Queue!");
    }

    //Dequeue Operation
    public void deQueue() {
        //Assign the data of the front node to the node
        Node node = front;
        //Check whether the queue is empty or not
        if (isEmpty()) {
            System.out.println("The Queue is Empty!");
            System.exit(1);
        } else {
            //Taking the popping value from the current front
            int deQueueValue = front.data;
            //Making the next node after front as the new front node
            front = node.next;
            System.out.println(deQueueValue);
        }
    }

    //Get the front from the queue
    public int getFront() {
        if (isEmpty()) {
            System.out.println("The Queue is Empty!");
            System.exit(1);
        }
        return front.data;
    }

    //Print the Queue
    public void printQueue() {
        Node node = front;
        if (isEmpty()) {
            System.out.println("The Queue is Empty!");
            System.exit(1);
        } else {
            int i = 1;
            System.out.println();
            System.out.println("================");
            System.out.println(" FINAL RESULTS");
            System.out.println("================");
            System.out.println();
            while (node.next != null) {
                String place = placeShow(i);
                System.out.print(place + " Place: ");
                System.out.println(node.data);
                node = node.next;
                i++;
            }
            String place = placeShow(i);
            System.out.print(place + " Place: ");
            System.out.println(node.data);
        }
    }


    public String placeShow(int i){

        String place = "1st";
        if (i == 1){
            place = "1st";
        }
        else if(i == 2){
            place = "2nd";
        }
        else if(i == 3){
            place = "3rd";
        }
        else if(i == 4){
            place = "4th";
        }

        return place;
    }

    public int linearSearch(int value){
        LinearSearch ls = new LinearSearch();
        int result = ls.linearSearchQueue(front, value);
        return result;
    }
}

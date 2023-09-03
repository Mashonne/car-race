package competition;

import java.util.Scanner;

public class LinkedList {
    private Node head;

    boolean isEmpty(){
        return head == null;
    }
    public void insert(int data){
        Node node = new Node(data);
        if (isEmpty()){
            head = node;
        }
        else{
            Node temp = head;
            while (temp.next != null){
                temp = temp.next;
            }
            temp.next = node;
        }
        //System.out.println(data + " Pushed into the Stack!");
    }

    public void enterDataFromArray(int [] carNumbers){
        for (int carNumber : carNumbers) {
            insert(carNumber);
        }
    }

    public int [] registerCarDetails(int carNumber){
        Scanner scanner = new Scanner(System.in);
        StaticStack sts = new StaticStack();
        String [] newCarDetails = new String[4];
        newCarDetails[0] = Integer.toString(carNumber);
        for (int i = 1; i < 4; i++){
            String name = nameShower(i);
            System.out.print(name);
            String value = scanner.next();
            newCarDetails[i] = value;
        }
        sts.push(newCarDetails);
        sts.displayRegisteredCarDetails();
        System.out.println("-+-+-+-+-+-+-+-+-+-++-+-+-+-++-+-+-+");
        System.out.println("Car No. " + carNumber + " Registration SuccessFul!");
        System.out.println("-+-+-+-+-+-+-+-+-+-++-+-+-+-++-+-+-+");
        insert(carNumber);
        int [] carNumbers =  new int[6];
        carNumbers = updateArray(carNumbers);
        return carNumbers;
    }

    public int [] registerNewCar(){
        CarRegistration carReg = new CarRegistration();
        int carNumber =  carReg.positiveNumberCheck("Car No: ");
        int result = linearSearch(carNumber);
        while (result != -1){
            System.out.println("Car Number already Registered!");
            System.out.print("Car No: ");
            carNumber = carReg.positiveNumberCheck("Car No: ");
            result = linearSearch(carNumber);
        }
        int [] carNumbers = registerCarDetails(carNumber);
        return carNumbers;
    }

    public int [] updateArray(int [] carNumbers){
        Node node = head;
        int i;
        for (i = 0; node.next != null; i++){
            carNumbers[i] = node.data;
            node = node.next;
        }
        carNumbers[i] = node.data;
        return carNumbers;
    }

    public void printLinkList(){
        Node node = head;
        if (isEmpty()){
            System.out.println("Linked List is Empty!!");
            System.exit(1);
        }
        while (node.next != null){
            System.out.print(node.data + "  ");
            node = node.next;
        }
        System.out.println(node.data + "  ");
    }

    public void deleteAt(int index){
        int deletedNumber =  head.data;
        if (index == 0){
            head = head.next;
        }
        else{
            Node node = head;
            Node n1 = null;
            for (int i = 1; i < index; i++){
                node = node.next;
            }
            n1 = node.next;
            deletedNumber = n1.data;
            node.next = n1.next;
            n1 = null;
        }
        System.out.println("=============================================");
        System.out.println("  Car No: " + deletedNumber + " Deleted from the Registration!");
        System.out.println("=============================================");
        System.out.println();
    }

    public int linearSearch(int carNumber){
        LinearSearch ls = new LinearSearch();
        int index = ls.linearSearchQueue(head, carNumber);
        return index;
    }

    public void deleteCarNumber(int carNumber){
        int index = linearSearch(carNumber);
        if (index == -1){
            System.out.println("Car No: " + carNumber + " not found!!");
            System.exit(1);
        }
        deleteAt(index);
    }

    public String nameShower(int j){
        String place = "Car No:";
         if (j == 1)
            place = "Brand: ";
        else if (j == 2)
            place = "Sponsor: ";

        else if (j == 3)
            place = "Driver's Name: ";
        return place;
    }
}

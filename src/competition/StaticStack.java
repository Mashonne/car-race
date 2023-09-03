package competition;

import java.util.Arrays;

public class StaticStack{
        //Set a variable as MAX for setting the Capacity of the Stack
        private static final int MAX = 6;
        //Declare an associated array & set the Maximum capacity of it
        private static String [][] array = new String[MAX][];
        //Declare the top of the Stack
        private int top = -1;

        //Function for Check whether the Stack is Empty
        boolean isEmpty(){
            return top == -1;
        }
        //Function for Check whether the Stack is Full
        boolean isFull(){
            return top == MAX - 1;
        }

        public void push(String [] items){
            //Checking whether the stack is full
            if (isFull()){
                System.out.println("Stack is Full!");
                System.exit(1);
            }
            else{
                //Assign the new value to the new top of the Stack
                array[++top] = items;
                //System.out.println(Arrays.toString(items) + " Push to Stack!!");
            }
        }

        public String [] pop(){
            //Checking whether the stack is Empty
            if (isEmpty()){
                System.out.println("Stack is Empty!!");
                System.exit(1);
            }
            //Take the value of the popping element
            String [] poppedElement = array[top];
            top--; //Decrement the top index
            //System.out.println(Arrays.toString(poppedElement) + " Popped out from the Stack!");
            return poppedElement;
        }


        public void peek(){
            if (isEmpty()){
                System.out.println("Stack is Empty!!");
                System.exit(1);
            }
            String [] topElement = array[top];
            System.out.println(Arrays.toString(topElement));
        }

        public void displayRegisteredCarDetails(){
            //Checking whether the stack is Empty
            if (isEmpty()){
                System.out.println("Stack is Empty!!");
                System.exit(1);
            }

            System.out.println();
            System.out.println("REGISTERED CAR DETAILS");
            System.out.println("----------------------");
            System.out.println();
            System.out.println("============================");
            //Taking the value of top + 1 to the variable called boundary
            int boundary = top + 1;
            //Execute the loop until the value of i equal to the value of top
            for (int i = 0; i < boundary; i++){
                //Use the carShow function to display which number of car details are inputting
                String carShow = carShow(i);
                System.out.println("         Car No. " + carShow);
                System.out.println("============================");
                //Pop the stack and take the returned array and copy assign that array data to
                //a new array called element
                String [] element = pop();
                //Execute the loop until the variable j equal to the length of element array
                for (int j = 0; j < element.length; j++){
                    //Using nameShower function to show the type of the data fo the element array
                    String place = nameShower(j);
                    //Display the data taken from the element array with its data title
                    System.out.println(place + element[j]);
                }
                System.out.println("============================");
            }
        }

        public String nameShower(int j){
            String place = "Car No:";
            if (j == 0){
                place = "Car No: ";
            }
            else if (j == 1){
                place = "Brand: ";
            }
            else if (j == 2){
                place = "Sponsor: ";
            }
            else if (j == 3){
                place = "Driver's Name: ";
            }
            return place;
        }

        public String carShow(int j){
            String car = "06";
            if (j == 0){
                car = "06";
            }
            else if(j == 1){
                car = "05";
            }
            else if(j == 2){
                car = "04";
            }
            else if(j == 3){
                car = "03";
            }
            else if(j == 4){
                car = "02";
            }
            else if(j == 5){
                car = "01";
            }
            return car;
        }

    }





package competition;

import java.util.Scanner;

public class Competition {
    public void competition(int [] carNumbers){
        Stack s = new Stack();
        Queue q = new Queue();

        //Just for the User friendly purposes
        System.out.println("=======================");
        System.out.println("  COMPETITION BEGUN!!");
        System.out.println("=======================");
        System.out.println();

        //the variable for executing the 3 rounds
        int i = 0;
        //for showing the positions and round numbers
        String place = "1st";
        String round = "First";

        //the variable for inputting the results of each car
        int j = 0;
        //Number of cars in the ongoing round
        int noOfCars = 6;
        //Implementing a while loop for 3 rounds
        while (i < 3){
            round = roundsShow(i, round);
            System.out.println("================");
            System.out.println("  " +round + " ROUND ");
            System.out.println("================");
            System.out.println();
            while (j < noOfCars){
                place = placeShow(j, place);
                System.out.print(place + " Place: ");
                //getting the returned car number
                int result = checkCarNumber(carNumbers, place);

                //if it is not the final round, put it into the Stack
                if (i < 2){

                    //Check whether the car number already pushed into the Stack
                    result = stackCheck(carNumbers, place, j, s, result);
                    //If it's not exists in the Stack, push the return car number
                    s.push(result);
                }

                //if it's the final round, enqueue the car number to the Queue.
                else{

                    //Check whether the car number already pushed to the Queue
                    result = queueCheck(carNumbers, place, j, q, result);
                    //If it's not exists in the Queue, enqueue the return car number
                    q.enQueue(result);
                }
                j++;
            }
            //Displaying the selected cars to Round 2 and 3
            if (i < 2){
                System.out.println();
                s.pop();
                System.out.println("ELIGIBLE TO THE NEXT ROUND");
                System.out.println("==========================");
                s.printStack();
                System.out.println("==========================");
                System.out.println();
                //Replace the previous car numbers array with selected cars
                carNumbers = s.createArray(noOfCars);
                System.out.println();

            }
            else{
                System.out.println();
                //q.printQueue();

                //taking the first enqueued car number
                int winner = q.getFront();

                //Display the 1st, 2nd & 3rd places by dequeue the Queue
                deQueueFinalResults(q);
                System.out.println();
                System.out.println("-+-+-+-+-+-+-+-+-+-+-+-");
                //Display the Winner car number as the Winner
                System.out.println("   WINNER CAR NO. " + winner);
                System.out.println("-----------------------");
                System.out.println("   CONGRATULATIONS!!");
                System.out.println("-+-+-+-+-+-+-+-+-+-+-+-");
                System.out.println();
                System.out.println("=======================");
                System.out.println("      THANK YOU!!");
                System.out.println("=======================");
                System.out.println();
            }
            j = 0;
            i++;
            noOfCars--;
            //resetting the Stack for reusing it.
            s.resetStack();
        }
    }

    //Creating an error handler method for taking only Integer Numbers as the Car Number
    public int integerValidation(String place){
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNextInt()){
            System.out.println("Invalid Number!");
            System.out.print(place + " Place: ");
            scanner.next();
        }
        int value = scanner.nextInt();
        return value;

    }

    /*Creating an error handler method for taking only integer positive values as the Car Number
    public int positiveNumberCheck(String place){
        int value = integerValidation(place);
        while (value < 1){
            System.out.println("Invalid car Number!");
            System.out.print(place + " Place: ");
            value = integerValidation(place);
        }
        return value;
    } */

    //Check whether the car number has already entered to the current round results
    public int checkCarNumber(int [] carNumbers, String place){
        LinearSearch ls = new LinearSearch(); //Calling linear search
        int result = integerValidation(place);//Calling check integer

        //Check whether the car number is an eligible car number
        int checkNumber = ls.linearSearchArray(carNumbers, result, 0);

        //if it is available loop until the non-exists car number is entered
        while (checkNumber == -1){
            System.out.println("Car Number is not Available in the Race!");
            System.out.print(place + " Place: ");
            result = integerValidation(place);
            //Again check the car number within the loop
            checkNumber = ls.linearSearchArray(carNumbers, result, 0);

        }
        //return the corrected inputted car number
        return result;
    }

    public int stackCheck(int [] carNumbers, String place, int j, Stack s, int result){
        if (j > 0){
            //Using linear search for check whether car number already in the Stack
            int stackCheckResult = s.linearSearch(result);
            while (stackCheckResult != -1){
                System.out.println("This Car Number already in Results!");
                System.out.print(place + " Place: ");
                //Check whether the car number is an eligible car number
                result = checkCarNumber(carNumbers, place);
                //Again check the car number within the loop
                stackCheckResult = s.linearSearch(result);
            }
        }
        return result;
    }

    public int queueCheck(int [] carNumbers, String place, int j, Queue q, int result){
        if (j > 0){
            //Using linear search for check whether car number already in the Queue
            int queueCheckResult = q.linearSearch(result);
            while (queueCheckResult != -1){
                System.out.println("This Car Number already in Results!");
                System.out.print(place + " Place: ");
                //Check whether the car number is an eligible car number
                result = checkCarNumber(carNumbers, place);
                //Again check the car number within the loop
                queueCheckResult = q.linearSearch(result);
            }
        }
        return result;
    }

    //Dequeue the First to third places using while loop
    public void deQueueFinalResults(Queue q){
        int i = 0;
        String place = "1st";
        System.out.println();
        System.out.println("================");
        System.out.println(" FINAL RESULTS");
        System.out.println("================");
        System.out.println();
        while (i < 3){ //set this 4 to 3 to only print Final 1st, 2nd and 3rd results
            place = placeShow(i, place);
            System.out.print(place + " Place: "); q.deQueue();
            i++;
        }
    }

    //For changing the String parts of the Output
    public String roundsShow(int i, String round){

        if (i == 0){
            round = "FIRST";
        }
        else if(i == 1){
            round = "SECOND";
        }
        else if(i == 2){
            round = "FINAL";
        }
        return round;
    }

    //For changing the String parts of the Output
    public String placeShow(int j, String place){

        if (j == 0){
            place = "1st";
        }
        else if(j == 1){
            place = "2nd";
        }
        else if(j == 2){
            place = "3rd";
        }
        else if(j == 3){
            place = "4th";
        }
        else if(j == 4){
            place = "5th";
        }
        else if(j == 5){
            place = "6th";
        }
        return place;
    }
}

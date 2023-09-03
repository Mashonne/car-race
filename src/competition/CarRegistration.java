package competition;

import java.util.Arrays;
import java.util.Scanner;

public class CarRegistration {
    public void carRegistration(){
        //To Store the Registration Details
        StaticStack sts = new StaticStack();
        //Calling the Scanner class
        Scanner scanner =  new Scanner(System.in);
        //Declaring an array to store the Registered Car numbers
        int [] carNumbers = new int[6];
        System.out.println();
        System.out.println("=============================");
        System.out.println("ABC (Pvt) Ltd Car Competition");
        System.out.println("=============================");
        System.out.println();
        System.out.println("-----------------------------");
        System.out.println("     CAR REGISTRATION");
        System.out.println("-----------------------------");

        //Declare adn initialized terms variable to run the loop 6 times
        int terms = 0;
        String car = "01";
        //Repeat the loop and taking six cars registration details until terms = 5
        while (terms < 6){
            //Calling carShow method to display which positioned car details are being entered
            car = carShow(terms, car);
            System.out.println();
            System.out.println("========================");
            System.out.println("  Car " + car + " Registration");
            System.out.println("========================");
            System.out.print("Car No: ");
            //Taking a valid car number and assign that number to value variable
            int value = checkCarNumber(carNumbers, "Car No: ");
            System.out.print("Brand: ");
            //Taking the brand of the car
            String brand = scanner.next();
            System.out.print("Sponsor: ");
            //Taking the sponsor of the car
            String sponsor = scanner.next();
            //Taking the driver's name of the car
            System.out.print("Driver's Name: ");
            //Validate the driver name assigns it to driverName variable
            String driverName = checkName();
            //Store only the entered car number to the Array
            carNumbers[terms] = value;
            //Push the car details to the stack
            carRegInStack(value, brand, sponsor, driverName, sts);

            System.out.println("====================================");
            System.out.println("Car No. " + value + " Registration SuccessFul!");
            System.out.println("====================================");
            terms++;
        }
        //Pop out the Registered Car details Newest to Oldest
        sts.displayRegisteredCarDetails();
        //Direct to the Control Panel
        controlPanel(carNumbers);

    }

    public void controlPanel(int [] carNumbers){
        Competition com = new Competition();
        System.out.println();
        System.out.println("===================");
        System.out.println(" ABC CONTROL PANEL");
        System.out.println("===================");
        System.out.println();
        System.out.println("1. Start the Race");
        System.out.println("2. Search Car Details");
        System.out.println("3. Delete a Car Replace");
        System.out.println("4. Exit");
        System.out.println();
        System.out.print("Enter the Process Number: ");
        int choice = integerValidation("Enter the Process Number: ");
        if (choice == 1){
            printCarNumbers(carNumbers);
            com.competition(carNumbers);
        }
        else if (choice == 2){
            System.out.println();
            System.out.println("Search a Car");
            System.out.println("==================");
            System.out.println();
            System.out.print("Enter the Car No. you required to search: ");
            searchCar(carNumbers);
        }
        else if(choice == 3){
            System.out.println();
            System.out.println("DELETE AND REPLACE");
            System.out.println("==================");
            System.out.println();
            System.out.print("Enter the Car No. you required to delete: ");
            carNumbers = deleteCar(carNumbers);
            controlPanel(carNumbers);
        }
        else if(choice == 4){
            System.out.println();
            System.out.println("===================");
            System.out.println("     GOOD BYE!");
            System.out.println("===================");
            System.exit(1);
        }
        else{
            System.out.println("Invalid Choice!");
            controlPanel(carNumbers);
        }
    }

    public void printCarNumbers(int [] carNumbers){
        System.out.println();
        System.out.println("CAR NUMBERS TO COMPETE");
        System.out.println("======================");
        System.out.print("  ");
        for (int carNumber : carNumbers) {
            System.out.print(carNumber + " ");
        }
        System.out.println();
        System.out.println("----------------------");
        System.out.println();

    }

    //Creating an error handler method for taking only Integer Numbers as the Car Number
    public int integerValidation(String place){
        Scanner scanner = new Scanner(System.in);
        //If the input is not an integer value the loop starts
        while (!scanner.hasNextInt()){
            System.out.println("Invalid Number!");
            System.out.print(place);
            scanner.next();
        }
        //Taking the correct integer value
        int value = scanner.nextInt();
        return value;
    }

    public int positiveNumberCheck(String place){
        //First take a valid  Integer Number as the Car Number
        int value = integerValidation(place);
        //If the input is not an integer value the loop starts
        while (value < 1){
            System.out.println("Invalid car Number!");
            System.out.print(place);
            value = integerValidation(place);
        }
        //retuning the correct integer value
        return value;
    }

    //Check whether the car number has already entered to the current round results
    public int checkCarNumber(int [] carNumbers, String place){
        LinearSearch ls = new LinearSearch(); //Calling linear search
        int result = positiveNumberCheck(place); //Calling integer and positive number check

        //Check whether the car number is an eligible car number
        int checkNumber = ls.linearSearchArray(carNumbers, result, 0);

        //if it is available loop until the non-exists car number is entered
        while (checkNumber != -1){
            System.out.println("This Car Number already Registered!!");
            System.out.print("Car No: ");
            result = positiveNumberCheck(place);
            //Again check the car number within the loop
            checkNumber = ls.linearSearchArray(carNumbers, result, 0);
        }
        //return the corrected inputted car number
        return result;
    }

    public void carRegInStack(int carNo, String brand, String sponsor, String driverName, StaticStack sts){
        //Parsing the Car Number to a String
        String carNoString = Integer.toString(carNo);
        //Store the Car Details in the Array
        String [] carDetails = {carNoString, brand, sponsor, driverName};
        //Push the Array to the Stack
        sts.push(carDetails);

    }

    //Driver's name Validation
    public String checkName(){
        Scanner scanner =  new Scanner(System.in);
        String name = scanner.nextLine();
        while(true) {
            try {
                if (!name.matches("[a-zA-Z ]+")){
                    throw new Exception("  Invalid Name!");
                }
                return name;
            }
            catch(Exception error){
                System.out.println("-x-x-x-x-x-x-x-x-");
                System.out.println(error.getMessage());
                System.out.println("-x-x-x-x-x-x-x-x-");
                System.out.println();
                System.out.print("Driver's Name: ");
                name = scanner.nextLine();
            }
        }

    }

    public int checkCarNumbersForDeleteSearch(int [] carNumbers, String place){
        LinearSearch ls = new LinearSearch();
        int result = integerValidation(place);
        int checkNumber = ls.linearSearchArray(carNumbers, result, 0);
        while (checkNumber == -1){
            System.out.println("Invalid Car Number!");
            System.out.print(place);
            result = integerValidation(place);
            checkNumber = ls.linearSearchArray(carNumbers, result, 0);
        }
        return result;
    }

    public int [] deleteCar(int [] carNumbers){
        LinkedList ll = new LinkedList();
        ll.enterDataFromArray(carNumbers);
        int carNumber = checkCarNumbersForDeleteSearch(carNumbers, "Enter the Car No. you required to delete: ");
        ll.deleteCarNumber(carNumber);
        System.out.println("Current Car Numbers Available in the Race");
        System.out.println("-----------------------------------------");
        System.out.println();
        ll.printLinkList();
        System.out.println();
        System.out.println("Register New Car Details Below");
        System.out.println("------------------------------");
        System.out.print("Car No: ");
        carNumbers = ll.registerNewCar();
        return carNumbers;

    }

    public void searchCar(int [] carNumbers){
        BinarySearch bs = new BinarySearch();
        int carNumber = positiveNumberCheck("Enter the Car No. you required to search: ");
        bs.searchResults(carNumbers, carNumber);

    }

    public String carShow(int j, String car){

        if (j == 0){
            car = "01";
        }
        else if(j == 1){
            car = "02";
        }
        else if(j == 2){
            car = "03";
        }
        else if(j == 3){
            car = "04";
        }
        else if(j == 4){
            car = "05";
        }
        else if(j == 5){
            car = "06";
        }
        return car;
    }


}

package competition;

public class BinarySearch {
    public int binarySearch(int [] array, int value, int low, int high){
        while (low <= high){
            int mid = low + (high - low)/2;

            if (array[mid] == value){
                return mid;
            }
            if (array[mid] < value){
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public void searchResults(int [] carNumbers, int value){
        InsertionSorting is = new InsertionSorting();
        CarRegistration carReg = new CarRegistration();
        is.insertionSort(carNumbers); //Sorting Before Search
        int result = binarySearch(carNumbers, value, 0, 5);

        if (result == -1){
            System.out.println("============================================");
            System.out.println("   Car no. " + value + " cannot be Found! TRY AGAIN!!");
            System.out.println("============================================");
            System.out.println();
            choiceSelector(carNumbers, carReg);
        }
        else {
            System.out.println("============================================");
            System.out.println("    Car no. " + value + " is Available in the Race!");
            System.out.println("============================================");
            System.out.println();
            choiceSelector(carNumbers, carReg);
        }
    }

    public void choiceSelector(int [] carNumbers, CarRegistration carReg){
        System.out.println("1. Search Again");
        System.out.println("2. Back");
        System.out.println();
        System.out.print("Choose the process: ");
        int choice = carReg.positiveNumberCheck("Choose the process: ");
        System.out.println();
        if (choice == 1){
            System.out.print("Enter the Car No. you required to search: ");
            carReg.searchCar(carNumbers);
        }
        else if (choice == 2){
            carReg.controlPanel(carNumbers);
        }
        else{
            System.out.println("Invalid Process Number!");
            choiceSelector(carNumbers, carReg);
        }
    }
}

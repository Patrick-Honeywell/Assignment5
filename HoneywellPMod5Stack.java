import java.util.Stack;
import java.util.ListIterator;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class that inserts user input integers into a sorted Stack.
 * @author Patrick Honeywell
 * @version 1.0.0
 * @since Week 5 of Class 6301
 */
public class HoneywellPMod5Stack {
	
	
	/**
	 * Main method of the class.
	 * Initializes a scanner named "sc".
	 * Initializes an ArrayList from collections called "sortedArray".
	 * Uses a while statement to ask for an integer input that is added to the array sorted from least to greatest.
	 * After each integer input it prints the array.
	 * After non-integer input it ends the program, prints the sorted array, pushes list into Stack LIFO, then prints the stack using pop.
	 */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> sortedArray = new ArrayList<>();
        Stack<Integer> numberStack = new Stack<>();

        // Read input integers until a non-integer
        while (true) {
            System.out.print("Input an integer (non-integer to end): ");
            if (sc.hasNextInt()) {
                int number = sc.nextInt();
                
                //Insert user input (integer) into sortedArray
                insertSorted(sortedArray, number);
                
                // Print the sortedArray after each addition
                System.out.println("Sorted Array: " + sortedArray);
            } else {
            	System.out.print("Final Sorted Array: " + sortedArray);
                break; // Exit when non-integer is entered
            }
        }
        //Push array into stack
        for (int num : sortedArray) {
            numberStack.push(num);
        }
        
        //Print the Stack
        System.out.println("\nElements pushed into stack... ");
        System.out.println("\nPrinting the stack (LIFO)... ");
        System.out.println("");
        
        while (!numberStack.isEmpty()) {
        	System.out.println(numberStack.pop());
        }
        
        sc.close();
    }

    /**
     * Method to insert integer into a sorted Array.
     * @param sortedArray = ArrayList
     * @param number = input from the scanner
     */
    public static void insertSorted(ArrayList<Integer> sortedArray, int number) {
        ListIterator<Integer> it = sortedArray.listIterator();
        while (it.hasNext()) {
            int next = it.next();
            if (number < next) {
                it.previous();
                it.add(number);
                return;
            }
        }
        // If integer is greater than all values in Array, insert at end
        sortedArray.add(number);
    }
}

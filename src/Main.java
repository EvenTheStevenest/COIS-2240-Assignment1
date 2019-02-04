import java.util.Scanner;
import java.lang.System;
public class Main {

    public static void main(String[] args) {
        int count = 0, endValue, i = 0, n = 0, p = 0;
        System.out.println("How many times do you want to run this method? Answer with an integer");
        Scanner scanner = new Scanner(System.in); // takes in user input
        endValue = scanner.nextInt(); // sets the value to the user's input

        System.out.println("Entering recursive method");
        long startRec = System.nanoTime(); // saves the time before entering method
        fiboSeriesRec(count ,endValue, i, n, p);
        long finishRec = System.nanoTime(); // saves the time after doing the method
        long timeElapsedRec = finishRec - startRec;  // finds the total time elapsed
        System.out.print("Time elapsed is: " + timeElapsedRec + " ");

        System.out.println("Now entering iterative method");
        long startIte = System.nanoTime(); // saves the time
        fiboSeriesIte(endValue);
        long finishIte = System.nanoTime(); // saves the time
        long timeElapsedIte = finishIte - startIte; // finds the time elapsed
        System.out.print("Time elapsed is: " + timeElapsedIte);
    }

    public static int fiboSeriesRec(int count, int endValue, int i, int n, int p) {

        // exits the method if count equals endValue
        if (count == endValue) {
            System.out.println("Exiting method");
        }
        // else it runs this code
        else {
            p = n + i;
            System.out.print(p + " ");
            count = count + 1;

            // fibonacci sequence starts off like this: 0 1 1
            // we set n = 1, so the next time it prints, p will be 1
            if (count == 1) {
                n = 1;
            }
            // here, we set i equal to n, such that it becomes p = 1 + 1
            if (count == 3) {
                i = n;
            }
            // now we set the values such that it will output a proper fibonacci sequence, adding the two most recent numbers
            if (count > 3) {
                i = n;
                n = p;
            }
            // recursively calls itself
            fiboSeriesRec(count, endValue, i, n, p);
        }
        // exits the method
        return count;
    }

    public static void fiboSeriesIte(int endValue) {
        int i = 0, n = 0, p = 0;
        // uses a for loop that iterates through the value of count to print out a fibonacci sequence
        for (int count = 0; count < endValue; count = count + 1) {
            p = n + i;
            System.out.print(p + " ");

            // sets n = 1 so that it will print a 1 as the next integer
            if (count == 0) {
                n = 1;
            }
            // sets i = n so that it will print out a 2 as the next integer
            if (count == 2) {
                i = n;
            }
            // sets i = n, n = p, so that it will add the 2 most recent values for a proper fibonacci sequence
            if (count > 2) {
                i = n;
                n = p;
            }
        }
    }
}

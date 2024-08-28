import java.util.*;

public class quickksort { 
    // Define the QuickSort class

    // Method to partition the array
    private static int partition(int[] array, int low, int high) {
    
        int pivot = array[high]; // Choose the last element as the pivot
        int i = low - 1; // Index of the smaller element

        for (int j = low; j < high; j++) {
        
            if (array[j] <= pivot) { // If current element is smaller than or equal to the pivot
                i++; // Increment index of smaller element
                // Swap array[i] and array[j]
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        // Swap array[i+1] and array[high] (or pivot)
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1; // Return the partitioning index
    }

    // Main method to implement QuickSort
    private static void quickSort(int[] array, int low, int high) {
    
        if (low < high) { // Check if the low index is less than the high index
            // pi is the partitioning index
            int pi = partition(array, low, high);

            // Recursively sort elements before partition and after partition
            quickSort(array, low, pi - 1); // Recursively sort the left subarray
            quickSort(array, pi + 1, high); // Recursively sort the right subarray
        }
    }

    // Helper method to print the array
    private static void printArray(int[] array) {
    
        for (int i : array) { // Loop through each element in the array
            System.out.print(i + " "); // Print the element followed by a space
        }
        System.out.println(); // Print a new line after printing the array
    }

    // Main method
    public static void main(String[] args) {
    
        int[] array = {10, 7, 8, 9, 1, 5}; // Initialize the array with sample values
        int n = array.length; // Get the length of the array

        System.out.println("Original array:"); // Print a message
        printArray(array); // Print the original array

        quickSort(array, 0, n - 1); // Call the quickSort method to sort the array

        System.out.println("Sorted array:"); // Print a message
        printArray(array); // Print the sorted array
    }
}










/*
     Explanation:

    public class QuickSort {:
        Declares a public class named QuickSort.

    private static int partition(int[] array, int low, int high) {:
        Declares a private static method named partition that returns an integer. It takes an array and two integers (low and high) as parameters.

    int pivot = array[high];:
        Sets the pivot element as the last element of the array segment being considered.

    int i = low - 1;:
        Initializes the index of the smaller element.

    for (int j = low; j < high; j++) {:
        Starts a for loop to iterate from the low index to one less than the high index.

    if (array[j] <= pivot) {:
        Checks if the current element is smaller than or equal to the pivot.

    i++;:
        Increments the index of the smaller element.

    int temp = array[i]; array[i] = array[j]; array[j] = temp;:
        Swaps the elements at index i and j.

    int temp = array[i + 1]; array[i + 1] = array[high]; array[high] = temp;:
        Swaps the pivot element with the element at index i + 1.

    return i + 1;:
        Returns the partitioning index.

    private static void quickSort(int[] array, int low, int high) {:
        Declares a private static method named quickSort that takes an array and two integers (low and high) as parameters.

    if (low < high) {:
        Checks if the low index is less than the high index.

    int pi = partition(array, low, high);:
        Calls the partition method and stores the partitioning index.

    quickSort(array, low, pi - 1);:
        Recursively sorts the elements before the partition.

    quickSort(array, pi + 1, high);:
        Recursively sorts the elements after the partition.

    private static void printArray(int[] array) {:
        Declares a private static method named printArray that takes an array as a parameter.

    for (int i : array) { System.out.print(i + " "); }:
        Uses a for-each loop to iterate through the array and print each element.

    System.out.println();:
        Prints a new line.

    public static void main(String[] args) {:
        Declares the main method, the entry point of the program.

    int[] array = {10, 7, 8, 9, 1, 5};:
        Initializes an array with sample values.

    int n = array.length;:
        Gets the length of the array.

    System.out.println("Original array:");:
        Prints "Original array:".

    printArray(array);:
        Calls the printArray method to print the original array.

    quickSort(array, 0, n - 1);:
        Calls the quickSort method to sort the array.

    System.out.println("Sorted array:");:
        Prints "Sorted array:".

    printArray(array);:
        Calls the printArray method to print the sorted array.

This code defines a simple QuickSort implementation in Java, including methods for partitioning the array, performing the QuickSort recursively, and printing the array.
 */

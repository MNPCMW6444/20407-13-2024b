package michael;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * Main class to handle heap operations from user input and file.
 */
public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            System.out.println("Enter the type of heap (array/linked/other):");
            String type = scanner.nextLine().toLowerCase();

            System.out.println("Enter the file path for heap data:");
            String filePath = scanner.nextLine();
            File file = new File(filePath);
            Scanner fileScanner = new Scanner(file);

            MergeableHeap heap = MergeableHeap.heapMake();

            while (fileScanner.hasNextInt()) {
                heap.insert(fileScanner.nextInt());
            }
            fileScanner.close();

            boolean exit = false;
            while (!exit) {
                System.out.println("Choose an operation: insert (i), findMinimum (f), extractMin (e), print (p), union (u), exit (x)");
                String command = scanner.nextLine().toLowerCase();
                switch (command) {
                    case "i":
                        System.out.println("Enter a value to insert:");
                        int value = scanner.nextInt();
                        scanner.nextLine(); // consume newline
                        heap.insert(value);
                        break;
                    case "f":
                        System.out.println("Minimum value: " + heap.findMinimum());
                        break;
                    case "e":
                        System.out.println("Extracted minimum value: " + heap.extractMin());
                        break;
                    case "p":
                        System.out.println("Current Heap:");
                        printHeap(heap);
                        break;
                    case "u":
                        // For simplicity, assume user manually inputs values for another heap
                        MergeableHeap otherHeap = MergeableHeap.heapMake();
                        System.out.println("Enter number of elements to insert in new heap:");
                        int count = scanner.nextInt();
                        System.out.println("Enter elements for new heap:");
                        for (int i = 0; i < count; i++) {
                            otherHeap.insert(scanner.nextInt());
                        }
                        scanner.nextLine(); // consume newline
                        heap.union(otherHeap);
                        System.out.println("Heaps merged.");
                        break;
                    case "x":
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid command.");
                        break;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found. Please check the path and try again.");
        } finally {
            scanner.close();
        }
    }

    /**
     * Prints all elements in the heap in order.
     * @param heap The heap to print.
     */
    private static void printHeap(MergeableHeap heap) {
        System.out.println(heap);
    }
}

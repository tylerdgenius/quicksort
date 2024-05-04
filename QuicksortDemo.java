import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class QuicksortDemo {

    public static void main(String[] args) {
        // Create ArrayLists for each day's items
        ArrayList<Integer> items1000 = generateRandomItems(1000);
        ArrayList<Integer> items5000 = generateRandomItems(5000);
        ArrayList<Integer> items10000 = generateRandomItems(10000);
        ArrayList<Integer> items50000 = generateRandomItems(50000);
        ArrayList<Integer> items75000 = generateRandomItems(75000);
        ArrayList<Integer> items100000 = generateRandomItems(100000);
        ArrayList<Integer> items500000 = generateRandomItems(500000);

        // Sort each ArrayList using Quicksort
        quicksort(items1000, 0, items1000.size() - 1);
        quicksort(items5000, 0, items5000.size() - 1);
        quicksort(items10000, 0, items10000.size() - 1);
        quicksort(items50000, 0, items50000.size() - 1);
        quicksort(items75000, 0, items75000.size() - 1);
        quicksort(items100000, 0, items100000.size() - 1);
        quicksort(items500000, 0, items500000.size() - 1);

        // Display sorted items (for demonstration purposes)
        System.out.println("Sorted Items for Each Day:");
        System.out.println("1000 items: " + items1000);
        System.out.println("5000 items: " + items5000);
        System.out.println("10000 items: " + items10000);
        System.out.println("50000 items: " + items50000);
        System.out.println("75000 items: " + items75000);
        System.out.println("100000 items: " + items100000);
        System.out.println("500000 items: " + items500000);
    }

    // Quicksort implementation
    public static void quicksort(ArrayList<Integer> array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high);
            quicksort(array, low, pivotIndex - 1);
            quicksort(array, pivotIndex + 1, high);
        }
    }

    // Partition function for Quicksort
    public static int partition(ArrayList<Integer> array, int low, int high) {
        int pivot = array.get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (array.get(j) <= pivot) {
                i++;
                Collections.swap(array, i, j);
            }
        }
        Collections.swap(array, i + 1, high);
        return i + 1;
    }

    // Helper method to generate random items in the specified range
    public static ArrayList<Integer> generateRandomItems(int numItems) {
        ArrayList<Integer> items = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < numItems; i++) {
            int item = random.nextInt(500000 - 1000 + 1) + 1000; // Random number between 1000 and 500000
            items.add(item);
        }
        return items;
    }
}

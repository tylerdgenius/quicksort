
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Quicksort {

    public static void main(String[] args) {

        /** Creating an array list for all 7 days in company XYZ */

        // Monday array list
        ArrayList<Integer> items1000 = generateRandomItems(1000);
        // Tuesday array list
        ArrayList<Integer> items5000 = generateRandomItems(5000);
        // Wednesday array list
        ArrayList<Integer> items10000 = generateRandomItems(10000);
        // Thursday array list
        ArrayList<Integer> items50000 = generateRandomItems(50000);
        // Friday array list
        ArrayList<Integer> items75000 = generateRandomItems(75000);
        // Saturday array list
        ArrayList<Integer> items100000 = generateRandomItems(100000);
        // Sunday array list
        ArrayList<Integer> items500000 = generateRandomItems(500000);

        quicksort(items1000, 0, items1000.size() - 1);
        quicksort(items5000, 0, items5000.size() - 1);
        quicksort(items10000, 0, items10000.size() - 1);
        quicksort(items50000, 0, items50000.size() - 1);
        quicksort(items75000, 0, items75000.size() - 1);
        quicksort(items100000, 0, items100000.size() - 1);
        quicksort(items500000, 0, items500000.size() - 1);

        System.out.println("Sorted Items for Each Day:");
        System.out.println("1000 items: " + items1000);
        System.out.println("5000 items: " + items5000);
        System.out.println("10000 items: " + items10000);
        System.out.println("50000 items: " + items50000);
        System.out.println("75000 items: " + items75000);
        System.out.println("100000 items: " + items100000);
        System.out.println("500000 items: " + items500000);

        String destinationPath = "quicksort/";

        writeSortedItemsToCSV(destinationPath + "sorted_items.csv", items1000, items5000, items10000, items50000,
                items75000, items100000, items500000);
    }

    public static void quicksort(ArrayList<Integer> array, int low, int high) {

        try {

            if (low < high) {

                int pivotIndex = partition(array, low, high);
                // Trying to sort the subarray to the left of mt pivot
                quicksort(array, low, pivotIndex - 1);
                // Trying to sort the subarray to the right of my pivot
                quicksort(array, pivotIndex + 1, high);
            }
        } catch (Exception exception) {
            System.out.println(exception.getCause());

        }
    }

    public static int partition(ArrayList<Integer> array, int low, int high) {
        int pivot = array.get(high); // Trying to get the last element in the array
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

    public static ArrayList<Integer> generateRandomItems(int numItems) {
        ArrayList<Integer> items = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < numItems; i++) {
            int item = random.nextInt(500000 - 1000 + 1) + 1000; // Random number between 1000 and 500000
            items.add(item);
        }
        return items;
    }

    public static void writeSortedItemsToCSV(String fileName, ArrayList<Integer>... sortedLists) {
        try (FileWriter writer = new FileWriter(fileName)) {
            for (ArrayList<Integer> list : sortedLists) {
                writer.write("# Items: " + list.size() + "\n");
                StringBuilder sb = new StringBuilder();
                for (Integer item : list) {
                    sb.append(item).append(",");
                }
                sb.deleteCharAt(sb.length() - 1); // I want to remove the last comma
                writer.write(sb.toString());
                writer.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

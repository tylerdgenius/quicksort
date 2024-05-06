import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class SortingEfficiency {

    public static void main(String[] args) {
        testSortingAlgorithm("Quicksort", 1000);
        testSortingAlgorithm("Quicksort", 5000);
        testSortingAlgorithm("Quicksort", 10000);
        testSortingAlgorithm("Quicksort", 50000);
        // These ones below are causing a recursive infinite depth that keeps throwing
        // stack overflow error
        testSortingAlgorithm("Quicksort", 75000);
        testSortingAlgorithm("Quicksort", 100000);
        testSortingAlgorithm("Quicksort", 500000);
    }

    public static void testSortingAlgorithm(String algorithm, int numItems) {
        ArrayList<Integer> randomList = generateRandomItems(numItems);
        ArrayList<Integer> sortedList = new ArrayList<>(randomList);
        Collections.sort(sortedList); // Sorted list
        Collections.reverse(sortedList); // Reverse-sorted list

        long startTime, endTime;

        startTime = System.currentTimeMillis();
        if (algorithm.equals("Quicksort")) {
            quicksort(randomList, 0, randomList.size() - 1);
        }
        endTime = System.currentTimeMillis();
        System.out.println("Time taken to sort random list of " + numItems + " items with " + algorithm + ": "
                + (endTime - startTime) + " milliseconds");

        startTime = System.currentTimeMillis();
        if (algorithm.equals("Quicksort")) {
            quicksort(sortedList, 0, sortedList.size() - 1);
        }
        endTime = System.currentTimeMillis();
        System.out.println("Time taken to sort sorted list of " + numItems + " items with " + algorithm + ": "
                + (endTime - startTime) + " milliseconds");

        startTime = System.currentTimeMillis();
        if (algorithm.equals("Quicksort")) {
            quicksort(sortedList, 0, sortedList.size() - 1);
            Collections.reverse(sortedList);
        }
        endTime = System.currentTimeMillis();
        System.out.println("Time taken to sort reverse-sorted list of " + numItems + " items with " + algorithm + ": "
                + (endTime - startTime) + " milliseconds");
    }

    public static ArrayList<Integer> generateRandomItems(int numItems) {
        ArrayList<Integer> items = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < numItems; i++) {
            int item = random.nextInt(500000 - 1000 + 1) + 1000;
            items.add(item);
        }
        return items;
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
}

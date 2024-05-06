
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class HybridQuickSort {
    private static final int CUTOFF_SIZE = 10;

    public static void main(String[] args) {
        testHybridSortingAlgorithm(1000);
        testHybridSortingAlgorithm(5000);
        testHybridSortingAlgorithm(10000);
        testHybridSortingAlgorithm(50000);
        // These oes below are causing infinite recursive depth that's stopping my app
        // from running
        testHybridSortingAlgorithm(75000);
        testHybridSortingAlgorithm(100000);
        testHybridSortingAlgorithm(500000);
    }

    public static void testHybridSortingAlgorithm(int numItems) {
        ArrayList<Integer> randomList = generateRandomItems(numItems);
        ArrayList<Integer> sortedList = new ArrayList<>(randomList);
        Collections.sort(sortedList); // Sorted list
        Collections.reverse(sortedList); // Reverse-sorted list

        long startTime, endTime;

        startTime = System.currentTimeMillis();
        hybridQuicksort(randomList, 0, randomList.size() - 1);
        endTime = System.currentTimeMillis();
        System.out.println("Time taken to sort random list of " + numItems + " items with Hybrid Quicksort: "
                + (endTime - startTime) + " milliseconds");

        startTime = System.currentTimeMillis();
        hybridQuicksort(sortedList, 0, sortedList.size() - 1);
        endTime = System.currentTimeMillis();
        System.out.println("Time taken to sort sorted list of " + numItems + " items with Hybrid Quicksort: "
                + (endTime - startTime) + " milliseconds");

        startTime = System.currentTimeMillis();
        hybridQuicksort(sortedList, 0, sortedList.size() - 1);
        Collections.reverse(sortedList);
        endTime = System.currentTimeMillis();
        System.out.println("Time taken to sort reverse-sorted list of " + numItems + " items with Hybrid Quicksort: "
                + (endTime - startTime) + " milliseconds");
    }

    public static void hybridQuicksort(ArrayList<Integer> array, int low, int high) {
        if (low < high) {
            if (high - low + 1 <= CUTOFF_SIZE) {
                insertionSort(array, low, high); // Using insertion sort for small subarrays
            } else {
                int pivotIndex = partition(array, low, high);
                hybridQuicksort(array, low, pivotIndex - 1);
                hybridQuicksort(array, pivotIndex + 1, high);
            }
        }
    }

    public static void insertionSort(ArrayList<Integer> array, int low, int high) {
        for (int i = low + 1; i <= high; i++) {
            int key = array.get(i);
            int j = i - 1;
            while (j >= low && array.get(j) > key) {
                array.set(j + 1, array.get(j));
                j--;
            }
            array.set(j + 1, key);
        }
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

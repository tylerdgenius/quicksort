public class HybridQuickSort {
    private static final int CUTOFF_SIZE = 10; // Example cutoff size

    public static void main(String[] args) {
        // Test hybrid sorting algorithm efficiency
        testHybridSortingAlgorithm(1000);
        testHybridSortingAlgorithm(5000);
        testHybridSortingAlgorithm(10000);
        testHybridSortingAlgorithm(50000);
        testHybridSortingAlgorithm(75000);
        testHybridSortingAlgorithm(100000);
        testHybridSortingAlgorithm(500000);
    }

    // Method to test hybrid sorting algorithm efficiency
    public static void testHybridSortingAlgorithm(int numItems) {
        ArrayList<Integer> randomList = generateRandomItems(numItems);
        ArrayList<Integer> sortedList = new ArrayList<>(randomList);
        Collections.sort(sortedList); // Sorted list
        Collections.reverse(sortedList); // Reverse-sorted list

        long startTime, endTime;

        // Test random list
        startTime = System.currentTimeMillis();
        hybridQuicksort(randomList, 0, randomList.size() - 1);
        endTime = System.currentTimeMillis();
        System.out.println("Time taken to sort random list of " + numItems + " items with Hybrid Quicksort: "
                + (endTime - startTime) + " milliseconds");

        // Test sorted list
        startTime = System.currentTimeMillis();
        hybridQuicksort(sortedList, 0, sortedList.size() - 1);
        endTime = System.currentTimeMillis();
        System.out.println("Time taken to sort sorted list of " + numItems + " items with Hybrid Quicksort: "
                + (endTime - startTime) + " milliseconds");

        // Test reverse-sorted list
        startTime = System.currentTimeMillis();
        hybridQuicksort(sortedList, 0, sortedList.size() - 1);
        Collections.reverse(sortedList);
        endTime = System.currentTimeMillis();
        System.out.println("Time taken to sort reverse-sorted list of " + numItems + " items with Hybrid Quicksort: "
                + (endTime - startTime) + " milliseconds");
    }

    // Hybrid Quicksort implementation
    public static void hybridQuicksort(ArrayList<Integer> array, int low, int high) {
        if (low < high) {
            if (high - low + 1 <= CUTOFF_SIZE) {
                insertionSort(array, low, high); // Use insertion sort for small subarrays
            } else {
                int pivotIndex = partition(array, low, high);
                hybridQuicksort(array, low, pivotIndex - 1);
                hybridQuicksort(array, pivotIndex + 1, high);
            }
        }
    }

    // Insertion sort implementation
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

    // Partition function for Quicksort (same as earlier)
    public static int partition(ArrayList<Integer> array, int low, int high) {
        // Partition function for Quicksort
        // ...
    }
}

public class SortingPerformance {

    public static void main(String[] args) {
        // Test sorting algorithm efficiency on different list sizes and configurations
        testSortingAlgorithm("Quicksort", 1000);
        testSortingAlgorithm("Quicksort", 5000);
        testSortingAlgorithm("Quicksort", 10000);
        testSortingAlgorithm("Quicksort", 50000);
        testSortingAlgorithm("Quicksort", 75000);
        testSortingAlgorithm("Quicksort", 100000);
        testSortingAlgorithm("Quicksort", 500000);
    }

    // Method to test sorting algorithm efficiency
    public static void testSortingAlgorithm(String algorithm, int numItems) {
        ArrayList<Integer> randomList = generateRandomItems(numItems);
        ArrayList<Integer> sortedList = new ArrayList<>(randomList);
        Collections.sort(sortedList); // Sorted list
        Collections.reverse(sortedList); // Reverse-sorted list

        long startTime, endTime;

        // Test random list
        startTime = System.currentTimeMillis();
        if (algorithm.equals("Quicksort")) {
            quicksort(randomList, 0, randomList.size() - 1);
        }
        endTime = System.currentTimeMillis();
        System.out.println("Time taken to sort random list of " + numItems + " items with " + algorithm + ": "
                + (endTime - startTime) + " milliseconds");

        // Test sorted list
        startTime = System.currentTimeMillis();
        if (algorithm.equals("Quicksort")) {
            quicksort(sortedList, 0, sortedList.size() - 1);
        }
        endTime = System.currentTimeMillis();
        System.out.println("Time taken to sort sorted list of " + numItems + " items with " + algorithm + ": "
                + (endTime - startTime) + " milliseconds");

        // Test reverse-sorted list
        startTime = System.currentTimeMillis();
        if (algorithm.equals("Quicksort")) {
            quicksort(sortedList, 0, sortedList.size() - 1);
            Collections.reverse(sortedList);
        }
        endTime = System.currentTimeMillis();
        System.out.println("Time taken to sort reverse-sorted list of " + numItems + " items with " + algorithm + ": "
                + (endTime - startTime) + " milliseconds");
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

    // Quicksort implementation (same as earlier)
    public static void quicksort(ArrayList<Integer> array, int low, int high) {
        // Quicksort implementation
        // ...
    }

    public static int partition(ArrayList<Integer> array, int low, int high) {
        // Partition function for Quicksort
        // ...
    }
}

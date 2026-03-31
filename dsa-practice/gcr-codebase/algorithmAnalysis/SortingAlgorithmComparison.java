package algorithmAnalysis;
import java.util.*;

public class SortingAlgorithmComparison {

    // Bubble Sort Implementation
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Merge Sort Implementation
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        int mid = arr.length / 2;
        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];

        System.arraycopy(arr, 0, left, 0, mid);
        System.arraycopy(arr, mid, right, 0, arr.length - mid);

        mergeSort(left);
        mergeSort(right);

        merge(arr, left, right);
    }

    private static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }
        while (i < left.length) {
            arr[k++] = left[i++];
        }
        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }

    // Quick Sort Implementation
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        int[] dataSize = {1000, 10000};
        Random random = new Random();

        System.out.println("Sorting Algorithm Performance Comparison");

        for (int N : dataSize) {
            int[] ogData = new int[N];
            for (int i = 0; i < N; i++) {
                ogData[i] = random.nextInt(N * 10);
            }

            System.out.printf("\nDataset Size (N): %,d%n", N);

            // Bubble Sort Measurement
            int[] dataBubble = Arrays.copyOf(ogData, N);
            long stimeBubble = System.nanoTime();
            bubbleSort(dataBubble);
            long etimeBubble = System.nanoTime();
            long durBubble = (etimeBubble - stimeBubble) / 1_000_000; // milliseconds
            System.out.printf("  Bubble Sort Time: %d ms%n", durBubble);

            // Merge Sort Measurement
            int[] dataMerge = Arrays.copyOf(ogData, N);
            long stimeMerge = System.nanoTime();
            mergeSort(dataMerge);
            long etimeMerge = System.nanoTime();
            long durMerge = (etimeMerge - stimeMerge) / 1_000_000; // milliseconds
            System.out.printf("  Merge Sort Time: %d ms%n", durMerge);

            // Quick Sort Measurement
            int[] dataQuick = Arrays.copyOf(ogData, N);
            long stimeQuick = System.nanoTime();
            quickSort(dataQuick, 0, dataQuick.length - 1);
            long etimeQuick = System.nanoTime();
            long durQuick = (etimeQuick - stimeQuick) / 1_000_000; // milliseconds
            System.out.printf("  Quick Sort Time: %d ms%n", durQuick);
        }

    }
}
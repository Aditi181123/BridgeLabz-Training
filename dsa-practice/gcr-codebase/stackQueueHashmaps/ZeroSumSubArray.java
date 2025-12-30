package stackQueueHashmaps;
import java.util.*;

public class ZeroSumSubArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        findZeroSumSubarrays(arr);
       
    }

    static void findZeroSumSubarrays(int[] arr) {
        Map<Integer, List<Integer>> idxsum = new HashMap<>();
        int currSum = 0;
        idxsum.put(0, new ArrayList<>());
        idxsum.get(0).add(-1);

        boolean found = false;


        for (int i = 0; i < arr.length; i++) {
            currSum += arr[i];

            if (idxsum.containsKey(currSum)) {
                List<Integer> startIndices = idxsum.get(currSum);
                for (int start : startIndices) {
                    System.out.println("Zero-sum subarray: [" + (start + 1) + ", " + i + "]");
                    found = true;
                }
            }

            if (!idxsum.containsKey(currSum)) {
                idxsum.put(currSum, new ArrayList<>());
            }
            idxsum.get(currSum).add(i);
        }

        if (!found) {
            System.out.println("No subarrays with zero sum found.");
        }
    }
}
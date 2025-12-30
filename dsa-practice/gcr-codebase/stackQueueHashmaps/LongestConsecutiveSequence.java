package stackQueueHashmaps;

import java.util.*;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] nums = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int lon = find(nums);
        System.out.println("Length of longest consecutive sequence: " + lon);
        sc.close();
    }

    static int find(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int maxLen = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int curr = num;
                int len = 1;

                while (set.contains(curr + 1)) {
                    curr++;
                    len++;
                }

                if (len > maxLen) {
                    maxLen = len;
                }
            }
        }

        return maxLen;
    }
}

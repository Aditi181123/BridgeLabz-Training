import java.util.*;

public class missingnum {
    public static void main(String[] args) {
        int[] nums = {3, 0, 1};

        int result = missingNumber(nums);
        System.out.println("Missing number: " + result);
    }
    public static int missingNumber(int[] nums) {
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return nums.length;
    }
}

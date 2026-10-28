package kadane;

public class MainKadane {

    public static void main(String[] args) {
        int[] array = new int[] {4, -1, 2, -7, 3, 4};
//        kadane(array);
        System.out.println(brute(array));
        System.out.println(kadane(array));
        System.out.println(kadaneWindow(array));
    }

    public static int kadane(int[] nums) {
        int maxSum = nums[0];
        int currentSum = 0;
        for (int num : nums) {
            currentSum = Math.max(currentSum, 0);
            currentSum += num;
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public static int kadaneWindow(int[] nums) {
        int maxSum = nums[0];
        int currentSum = 0;
        int maxLeft = 0;
        int maxRight = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            if (currentSum < 0) {
                currentSum = 0;
                left = right;
            }

            currentSum += nums[right];
            if (currentSum > maxSum) {
                maxSum = currentSum;
                maxLeft = left;
                maxRight = right;
            }
        }

        return maxSum;
    }

    public static int brute(int[] nums) {
        int length = nums.length;
        int maxSum = nums[0];

        for (int i = 0; i < length; i++) {
            int currentSum = 0;
            for (int j = i; j < length; j++) {
                currentSum += nums[j];
                maxSum = Math.max(maxSum, currentSum);
            }
        }

        return maxSum;
    }
}

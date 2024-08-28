import java.util.Arrays;

public class MinDifferenceSubset {
    
    public static int minDifference(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        
        int n = nums.length;
        boolean[][] dp = new boolean[n + 1][sum + 1];
        
        // Initialize first column as true, since a sum of 0 can be achieved by not picking any element
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }
        
        // Fill the dp array
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (nums[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        
        // Find the minimum difference
        int minDiff = Integer.MAX_VALUE;
        for (int j = sum / 2; j >= 0; j--) {
            if (dp[n][j]) {
                minDiff = sum - 2 * j;
                break;
            }
        }
        
        return minDiff;
    }

    public static void main(String[] args) {
        int[] nums = {5,3,4};
        System.out.println("Minimum difference between two subsets: " + minDifference(nums));
    }
}


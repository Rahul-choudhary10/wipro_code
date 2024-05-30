package common;


import java.util.Arrays;

public class LongestIncreasingSubsequence {
	public static int lis(int[] arr) {
       int n = arr.length;
       int[] dp = new int[n];
       Arrays.fill(dp, 1); // Initialize all dp values as 1

       // Compute optimized LIS values in a bottom-up manner
       for (int i = 1; i < n; i++) {
           for (int j = 0; j < i; j++) {
               if (arr[i] > arr[j] && dp[i] < dp[j] + 1) {
                   dp[i] = dp[j] + 1;
               }
           }
       }

       // Find the maximum value in dp[]
       int max = 0;
       for (int i = 0; i < n; i++) {
           if (max < dp[i]) {
               max = dp[i];
           }
       }

       return max;
   }

   public static void main(String[] args) {
       int[] arr = {5,4,3,2,1};
       System.out.println("Length of LIS is " + lis(arr));
   }
}

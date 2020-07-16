import java.util.Arrays;

/**
 * LongestIncreasingSubsequence
 */
public class LongestIncreasingSubsequence {

    public static int LIS(int[] arr){
        /**
         * for {10,22,9,33,21,50,41,60}
         * longest increasing subsequence is 10,22,33,50,60 or 10,22,33,41,60
         * then return 5 in this case
         * O(n^2)
         */
        int[] lis = new int[arr.length];
        Arrays.fill(lis, 1);
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if ((arr[j] < arr[i]) && (lis[i] < lis[j] + 1)) {
                    lis[i] = lis[j] +1;
                }
            }
        }
        int longestIncreasingSubsequence = 0;
        for (int i = 0; i < lis.length; i++) {
            longestIncreasingSubsequence = Math.max(longestIncreasingSubsequence, lis[i]);
        }
        return longestIncreasingSubsequence;
    }

    public static void main(String[] args) {
        int[] arr = {10,22,9,33,21,50,41,60};
        System.out.println(LIS(arr));
    }
}
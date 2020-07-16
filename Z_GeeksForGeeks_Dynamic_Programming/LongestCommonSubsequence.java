public class LongestCommonSubsequence {

    private static int[] lastElementInLongestCommonSubsequencePosition = {0,0};

    private static int longestCommonSubsequenceLength = 0;

    private static void updateLastElementInLongestCommonSubsequencePosition(int number, int x, int y){
        if (number > longestCommonSubsequenceLength) {
            longestCommonSubsequenceLength = number;
            lastElementInLongestCommonSubsequencePosition[0] = x;
            lastElementInLongestCommonSubsequencePosition[1] = y;
        }
    }

    public static char[] LCS(char[] a, char[] b) {
        // initiate first row and column with zeroes
        int[][] LCS = new int[a.length+1][b.length+1];
        for (int i = 0; i < LCS[0].length; i++) {
            LCS[0][i] = 0;
        }
        for (int i = 0; i < LCS.length; i++) {
            LCS[i][0] = 0;
        }

        for (int i = 1; i < LCS.length; i++) {
            for (int j = 1; j < LCS[i].length; j++) {
                if (a[i-1] == b[j-1]) {
                    LCS[i][j] = LCS[i-1][j-1] + 1;
                    updateLastElementInLongestCommonSubsequencePosition(LCS[i][j],i,j);
                }else {
                    LCS[i][j] = Math.max(LCS[i-1][j], LCS[i][j-1]);
                }
            }
        }

        // now we generate the longest common subsequence from end to start
        char[] longestCommonSubsequence = new char[longestCommonSubsequenceLength];
        int[] currentPosition = {lastElementInLongestCommonSubsequencePosition[0],
            lastElementInLongestCommonSubsequencePosition[1]};
        longestCommonSubsequence[longestCommonSubsequenceLength-1] = a[currentPosition[0]-1];
        for (int i = longestCommonSubsequenceLength-2; i >= 0; i--) {
            if (LCS[currentPosition[0]][currentPosition[1]] > LCS[currentPosition[0]-1][currentPosition[1]]
            && LCS[currentPosition[0]][currentPosition[1]] > LCS[currentPosition[0]][currentPosition[1]-1]){
                // then move up diagonally
                currentPosition[0] = currentPosition[0]-1;
                currentPosition[1] = currentPosition[1]-1;
                // increase i because we didn't add to the result
                i++;
            }else if (LCS[currentPosition[0]][currentPosition[1]] > LCS[currentPosition[0]-1][currentPosition[1]]
            && LCS[currentPosition[0]][currentPosition[1]] == LCS[currentPosition[0]][currentPosition[1]-1]) {
                // then current number come from left then move left 
                currentPosition[1] = currentPosition[1]-1;
                // then add to our subsequence the current position
                longestCommonSubsequence[i] = a[currentPosition[0]-1];
            }else if (LCS[currentPosition[0]][currentPosition[1]] == LCS[currentPosition[0]-1][currentPosition[1]]
            && LCS[currentPosition[0]][currentPosition[1]] > LCS[currentPosition[0]][currentPosition[1]-1]) {
                // then current number come from up then move up
                currentPosition[0] = currentPosition[0]-1;
                // then add to our subsequence the current position
                longestCommonSubsequence[i] = a[currentPosition[0]-1];
            }else {
                // current number is equal to left and up then move in any but i will move left
                currentPosition[1] = currentPosition[1]-1;
                // then add to our subsequence the current position
                longestCommonSubsequence[i] = a[currentPosition[0]-1];
            }
        }
        return longestCommonSubsequence;
    }

    public static void main(String[] args) {
        char[] a = {'a','g','g','t','a','b'};
        char[] b = {'g','x','t','x','a','y','b'};
        char[] result = LCS(a, b);
        System.out.println("done!");
    }
}
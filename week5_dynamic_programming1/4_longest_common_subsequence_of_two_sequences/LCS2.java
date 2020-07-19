import java.util.*;

public class LCS2 {

    private static int lcs2(int[] a, int[] b) {
        //Write your code here
        int[][] LCS = new int[a.length+1][b.length+1];
        for (int i = 0; i < LCS[0].length; i++) {
            LCS[0][i]=0;
        }
        for (int i = 0; i < LCS.length; i++) {
            LCS[i][0]=0;
        }

        for (int i = 1; i < LCS.length; i++) {
            for (int j = 1; j < LCS[i].length; j++) {
                if (a[i-1] == b[j-1]) {
                    LCS[i][j] = LCS[i-1][j-1] + 1;
                }else{
                    LCS[i][j] = Math.max(LCS[i][j-1], LCS[i-1][j]);
                }
            }
        }
        return LCS[a.length][b.length];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        int m = scanner.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }
        int lcs = lcs2(a, b);
        System.out.println(lcs);
    }
}


import java.util.*;

public class LCS3 {

    private static int lcs3(int[] a, int[] b, int[] c) {
        //Write your code here
        int[][][] LCS = new int[a.length+1][b.length+1][c.length+1];

        for (int i = 0; i < LCS.length; i++) {
            LCS[i][0][0] =0;
        }
        for (int i = 0; i < LCS[0].length; i++) {
            LCS[0][i][0] =0;
        }
        for (int i = 0; i < LCS[0][0].length; i++) {
            LCS[0][0][i] =0;
        }

        for (int i = 1; i < LCS.length; i++) {
            for (int j = 1; j < LCS[i].length; j++) {
                for (int k = 1; k < LCS[i][j].length; k++) {
                    if (a[i-1] == b[j-1] && a[i-1] == c[k-1]) {
                        LCS[i][j][k] = LCS[i-1][j-1][k-1] + 1;
                    }else {
                        int max1 = Math.max(LCS[i][j-1][k], LCS[i][j][k-1]);
                        LCS[i][j][k] = Math.max(max1, LCS[i-1][j][k]);
                    }
                }
            }
        }
        return LCS[a.length][b.length][c.length];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int an = scanner.nextInt();
        int[] a = new int[an];
        for (int i = 0; i < an; i++) {
            a[i] = scanner.nextInt();
        }
        int bn = scanner.nextInt();
        int[] b = new int[bn];
        for (int i = 0; i < bn; i++) {
            b[i] = scanner.nextInt();
        }
        int cn = scanner.nextInt();
        int[] c = new int[cn];
        for (int i = 0; i < cn; i++) {
            c[i] = scanner.nextInt();
        }
        int result = lcs3(a,b,c);
        System.out.println(result);
    }
}


import java.util.*;

public class Knapsack {
    static int optimalWeight(int weight, int[] itemsWeights, int[] itemsValues) {
        int[][] values = new int[itemsWeights.length+1][weight+1];

        for (int i = 0; i < values.length; i++) {
          values[i][0] = 0;
        }
        for (int i = 0; i < values[0].length; i++) {
          values[0][i] = 0;
        }

        for (int i = 1; i < values.length; i++) {
          for (int j = 1; j < values[i].length; j++) {
            values[i][j] = values[i-1][j];
            if (itemsWeights[i-1] <= j) {
              // here items value or weight [i-1] because we have extra row of zeroes
              int val = values[i-1][j-itemsWeights[i-1]] + itemsValues[i-1];
              if (val > values[i][j]) {
                values[i][j] = val;
              }
            }
          }
        }
        return values[itemsWeights.length][weight];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W, n;
        W = scanner.nextInt();
        n = scanner.nextInt();
        int[] w = new int[n];
        int[] v = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
            v[i] = w[i];
        }
        System.out.println(optimalWeight(W, w, v));
    }
}


import java.util.*;
import java.io.*;

public class Partition3 {

    public static int arrSum(int[] arr){
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            result += arr[i];
        }
        return result;
    }

    public static int arrCalculateZeroes(int[] arr){
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
             result++;   
            }
        }
        return result;
    }

    public static int knapsack(int weight, int[] items) {
        int[][] values = new int[items.length+1][weight+1];
        for (int i = 0; i < values.length; i++) {
            values[i][0] = 0;
        }
        for (int i = 0; i < values[0].length; i++) {
            values[0][i] = 0;
        }

        int count = 0;
        for (int i = 1; i < values.length; i++) {
            for (int j = 1; j < values[i].length; j++) {
                values[i][j] = values[i-1][j];
                if (items[i-1] <= j) {
                    int val = values[i-1][j-items[i-1]] + items[i-1];
                    if (val > values[i][j]) {
                        values[i][j] = val;
                    }
                }
                if (values[i][j] == weight) {
                    count++;
                }
            }
        }
        return count < 3 ? 0:1;
    }

    private static int partition3(int[] weights) {
        //write your code here
        if (weights.length < 3) {
            return 0;
        }
        int totalWeight = arrSum(weights);

        if (totalWeight % 3 != 0) {
            return 0;
        }

        return knapsack(totalWeight/3, weights);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            weights[i] = scanner.nextInt();
        }
        int result = partition3(weights);
        System.out.println(result);
    }
}


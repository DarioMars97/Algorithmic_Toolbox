import java.util.Scanner;

public class ChangeDP {
    private static int getChange(int money, int[] change) {
        // write your code here
        int[] minNumberOfCoins = new int[money + 1];
        minNumberOfCoins[0] = 0;
        for (int i = 1; i < minNumberOfCoins.length; i++) {
            minNumberOfCoins[i] = 9999;
            for (int j = 0; j < change.length; j++) {
                int numberOfCoins;
                if (i >= change[j]) {
                    numberOfCoins = minNumberOfCoins[i - change[j]] + 1;
                    minNumberOfCoins[i] = Math.min(minNumberOfCoins[i], numberOfCoins);
                }
            }
        }
        return minNumberOfCoins[money];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int[] change = {1,3,4};
        System.out.println(getChange(m, change));

    }
}

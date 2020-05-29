import java.util.*;

import java.io.*;

public class MaxPairwiseProduct {
    static int getMaxPairwiseProduct(int[] numbers) {
        int max_product = 0;
        int n = numbers.length;

        for (int first = 0; first < n; ++first) {
            for (int second = first + 1; second < n; ++second) {
                max_product = Math.max(max_product,
                    numbers[first] * numbers[second]);
            }
        }

        return max_product;
    }

    /**
     * 
     * It gives a wrong answer in some cases.
     * like [2 1] it gives 4 instead of 2
     */
    
    public static long getMaxPairwiseProductFast(long[] numbers){
        int firstMaxNumIndex = -1;
        int secondMaxNumIndex = -1;

        for (int i = 0; i < numbers.length; i++) {
            if (firstMaxNumIndex == -1 || numbers[i] > numbers[firstMaxNumIndex]) {
                firstMaxNumIndex = i;
            }
        }

        for (int i = 0; i < numbers.length; i++) {
            if (secondMaxNumIndex == -1 ||
            (numbers[i] != numbers[firstMaxNumIndex] && numbers[i] > numbers[secondMaxNumIndex])) {
                secondMaxNumIndex = i;
            }
        }
        return numbers[firstMaxNumIndex] * numbers[secondMaxNumIndex];
    }

    public static long getMaxPairwiseProductFastAndCorrect(long[] numbers){
        Arrays.sort(numbers);
        int size = numbers.length;
        return numbers[size-1]*numbers[size-2];
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        long[] numbers = new long[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = (long)scanner.nextInt();
        }
        // System.out.println(getMaxPairwiseProduct(numbers));
        System.out.println(getMaxPairwiseProductFastAndCorrect(numbers));
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new
                    InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

}

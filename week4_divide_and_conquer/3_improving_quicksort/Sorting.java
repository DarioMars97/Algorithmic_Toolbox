import java.io.*;
import java.util.*;

public class Sorting {
    private static Random random = new Random();

    private static int[] partition3(int[] arr, int left, int right) {
        //write your code here
        int pivot = arr[left];
        int lessThan = left;
        int greaterThan = right;

        for (int i = left; i<=greaterThan;i++){
            if (arr[i]<pivot) {
                int temp = arr[lessThan];
                arr[lessThan] = arr[i];
                arr[i] = temp;

                lessThan++;
            }
            else if (arr[i]>pivot) {
                int temp = arr[greaterThan];
                arr[greaterThan] = arr[i];
                arr[i] = temp;

                greaterThan--; 
                i--; // to not affect our loop from left+1 to graterThan
            }
        }
        return new int[] {lessThan, greaterThan};
    }

    private static int partition2(int[] a, int l, int r) {
        int x = a[l];
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (a[i] <= x) {
                j++;
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }
        int t = a[l];
        a[l] = a[j];
        a[j] = t;
        return j;
    }

    private static void randomizedQuickSort(int[] a, int l, int r) {
        if (l >= r) {
            return;
        }
        int k = random.nextInt(r - l + 1) + l;
        int t = a[l];
        a[l] = a[k];
        a[k] = t;
        //use partition3
        int m = partition2(a, l, r);
        randomizedQuickSort(a, l, m - 1);
        randomizedQuickSort(a, m + 1, r);
    }

    public static void optimizedQuickSort(int[] arr, int left, int right) {
        while (left < right) {
            // choose pivot in the middle
            int k = left + ((right-left)/2);
            // swap arr[k] with arr[left]
            int temp = arr[k];
            arr[k] = arr[left];
            arr[left] = temp;
            int[] partitionPositions = partition3(arr, left, right);
            optimizedQuickSort(arr, left, partitionPositions[0] - 1);
            left = partitionPositions[1] + 1;
        }
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        optimizedQuickSort(a, 0, n - 1);
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
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


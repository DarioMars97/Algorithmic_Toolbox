import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class MergeSort {

    public static int[] merge(int[] leftArr, int[] rightArr) {
        int leftCounter = 0, rightCounter = 0;
        int[] mergedArray = new int[leftArr.length+rightArr.length];
        while (leftCounter < leftArr.length || rightCounter < rightArr.length) {
            if (leftCounter < leftArr.length && rightCounter < rightArr.length) {
                if (leftArr[leftCounter] < rightArr[rightCounter]) {
                    mergedArray[leftCounter+rightCounter] = leftArr[leftCounter];
                    leftCounter++;
                }else {
                    mergedArray[leftCounter+rightCounter] = rightArr[rightCounter];
                    rightCounter++;
                }   
            } else if (leftCounter < leftArr.length && rightCounter == rightArr.length) {
                mergedArray[leftCounter+rightCounter] = leftArr[leftCounter];
                leftCounter++;
            } else {
                mergedArray[leftCounter+rightCounter] = rightArr[rightCounter];
                rightCounter++;
            }
        }
        return mergedArray;
    }

    public static int[] mergeSort(int[] arr) {
        // for (int i : arr) {
        //     System.out.print(i);
        //     System.out.print(" ");
        // }
        // System.out.println();
        if (arr.length == 1) {
            return arr;
        }
        int[] leftArr = mergeSort(Arrays.copyOfRange(arr, 0, arr.length/2));
        int[] rightArr = mergeSort(Arrays.copyOfRange(arr, arr.length/2, arr.length));
        return merge(leftArr, rightArr);
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int[] arr = mergeSort(a);
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
            char[] stars = new char[arr[i]];
            Arrays.fill(stars, '*');
            System.out.print(new String(stars));
            System.out.println();
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
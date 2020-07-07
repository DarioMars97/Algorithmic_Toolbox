import java.util.*;
import java.io.*;

public class MajorityElement {
    public static int[] merge(int[] leftArr, int[] rightArr){
        int[] mergedArr = new int[rightArr.length+leftArr.length];
        int leftCounter = 0, rightCounter = 0;
        while (leftCounter < leftArr.length || rightCounter < rightArr.length) {
            if (leftCounter < leftArr.length && rightCounter < rightArr.length) {
                if (leftArr[leftCounter] <= rightArr[rightCounter]) {
                    mergedArr[leftCounter+rightCounter] = leftArr[leftCounter];
                    leftCounter++;
                }else{
                    mergedArr[leftCounter+rightCounter] = rightArr[rightCounter];
                    rightCounter++;
                }
            } else if (leftCounter < leftArr.length && rightCounter == rightArr.length) {
                mergedArr[leftCounter+rightCounter] = leftArr[leftCounter];
                leftCounter++;
            } else{
                mergedArr[leftCounter+rightCounter] = rightArr[rightCounter];
                rightCounter++;
            }
        }
        return mergedArr;
    }

    public static int[] mergeSort(int[] arr) {
        if (arr.length == 1) {
            return arr;
        }
        int[] leftArr = mergeSort(Arrays.copyOfRange(arr, 0, arr.length/2));
        int[] rightArr = mergeSort(Arrays.copyOfRange(arr, arr.length/2, arr.length));
        return merge(leftArr, rightArr);
    }

    private static int getMajorityElement(int[] a, int left, int right) {
        if (left == right) {
            return -1;
        }
        if (left + 1 == right) {
            return a[left];
        }
        //write your code here
        /**
         * first I will sort the array with any of merge sort or quick sort 
         * but I will use merge sort
         * then i will loop over the array and for each repeated number I will count it in a counter
         * if the counter exceeds the 50% of the length from left to right then I will return it
         * if the loop finished then it will return -1
         * I think this Algo T(n) = O(nlogn) + O(n)
         * then it will be O(nlogn)
         */
        // 1st sort
        int[] arr;
        if (right == a.length) {
            arr = mergeSort(Arrays.copyOfRange(a, left, right));
        }else {
            arr = mergeSort(Arrays.copyOfRange(a, left, right+1));
        }

        // 2nd loop
        int currentElement = arr[0];
        int currentElementCounter = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == currentElement){
                currentElementCounter++;
            } else{
                currentElement = arr[i];
                currentElementCounter = 1;
            }
            if (currentElementCounter > (arr.length/2)) {
                return currentElement;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        if (getMajorityElement(a, 0, a.length) != -1) {
            System.out.println(1);
        } else {
            System.out.println(0);
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


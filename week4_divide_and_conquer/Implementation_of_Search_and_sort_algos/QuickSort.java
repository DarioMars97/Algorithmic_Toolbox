import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class QuickSort {

    public static class Pair{
        private int first;
        private int second;

        Pair(int first, int second){
            this.first = first;
            this.second = second;
        }

        public int getFirst() {
            return first;
        }
        public int getSecond() {
            return second;
        }
        public void setFirst(int first) {
            this.first = first;
        }
        public void setSecond(int second) {
            this.second = second;
        }
    }

    public static Pair pivotPartition3(int[] arr, int left, int right) {
        int pivot = arr[left];
        int lessThan = left; 
        int greaterThan = right; 

        for (int i = left; i <= greaterThan; i++) {
            if (arr[i] < pivot) {
                int temp = arr[lessThan];
                arr[lessThan] = arr[i];
                arr[i] = temp;

                lessThan++;
            }else if (arr[i] > pivot){
                int temp = arr[greaterThan];
                arr[greaterThan] = arr[i];
                arr[i] = temp;

                greaterThan--;
                i--; // to not affect our loop from left+1 to greaterThan
            }
        }
        // no need to swap as i now move the pivot it self
        // swap the pivot "which is the first element in the array"
        // arr[lessThan] "which is the last element in the region that are smaller than the pivot"
        // arr[left] = arr[lessThan];
        // arr[lessThan] = pivot;
        return new Pair(lessThan, greaterThan);
    }

    public static int pivotPartition(int[] arr, int left, int right) {
        int pivot = arr[left];
        int i = left; // i is lessThanPivotRegionEndPosition
        int j;// j is moreThanPivotRegionEndPosition which starts with pivot +1

        for (j = left + 1; j <= right; j++) {
            if (arr[j] <= pivot) {
                // increase less than pivot region
                i++;
                // swap arr[i] with arr[j]
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        // swap the pivot "which is the first element in the array"
        // arr[i] "which is the last element in the region that are smaller than the pivot"
        arr[left] = arr[i];
        arr[i] = pivot;
        return i;
    }

    public static void quickSortAlgorithm(int[] arr, int left, int right) {
        if (left < right) {
            int pivotPosition = pivotPartition(arr, left, right);
            quickSortAlgorithm(arr, left, pivotPosition-1);
            quickSortAlgorithm(arr, pivotPosition+1, right);
        }
    }

    public static void randomizedQuickSort(int[] arr, int left, int right){
        if(left < right){
            int k = (int) ((Math.random() * (right - left)) + left);
            // swap arr[k] with arr[left]
            int temp = arr[left];
            arr[left] = arr[k];
            arr[k] = temp;

            int pivotPosition = pivotPartition(arr, left, right);
            quickSortAlgorithm(arr, left, pivotPosition-1);
            quickSortAlgorithm(arr, pivotPosition+1, right);
        }
    }

    public static void optimizedTimeQuickSort(int[] arr, int left, int right){
        /**
         * for the equal elements the normal algorithm works slow.
         * so we make 3 partitions rather than 2
         * p1 for elements < pivot
         * p2 for elements = pivot
         * p3 for elements > pivot
         * and sort just p1 and p3
         */
        if(left < right){
            int k = (int) ((Math.random() * (right - left)) + left);
            // swap arr[k] with arr[left]
            int temp = arr[left];
            arr[left] = arr[k];
            arr[k] = temp;

            Pair pivotPositions = pivotPartition3(arr, left, right);
            optimizedTimeQuickSort(arr, left, pivotPositions.getFirst()-1);
            optimizedTimeQuickSort(arr, pivotPositions.getSecond()+1, right);
        }
    }

    public static void optimizedTimeAndSpaceQuickSort(int[] arr, int left, int right){
        /**
         * to optimize space which in recursive calls 
         * we will use a trick called Tail Recursion Elimination
         */
        while (left < right) {
            int k = left + ((right - left)/2);
            // int k = (int) ((Math.random() * (right - left)) + left);
            // swap arr[k] with arr[left]
            int temp = arr[left];
            arr[left] = arr[k];
            arr[k] = temp;

            Pair pivotPositions = pivotPartition3(arr, left, right);
            optimizedTimeAndSpaceQuickSort(arr, left, pivotPositions.getFirst()-1);
            left = pivotPositions.getSecond()+1;
        }
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (arr.length <= right) {
            // quickSortAlgorithm(arr, left, arr.length-1);
            // randomizedQuickSort(arr, left, arr.length-1);
            // optimizedTimeQuickSort(arr, left, arr.length-1);
            optimizedTimeAndSpaceQuickSort(arr, left, arr.length-1);
        }else {
            // quickSortAlgorithm(arr, left, right);
            // randomizedQuickSort(arr, left, right);
            // optimizedTimeQuickSort(arr, left, right);
            optimizedTimeAndSpaceQuickSort(arr, left, right);
        }
    }

    public static void testRandom(int max) {
        for (int i = 0; i < 20; i++) {
            int random = (int)(Math.random()*max)%max;
            System.out.println(random);
            System.out.println(random <= max);
        }
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        quickSort(a, 0, n - 1);
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
            char[] stars = new char[a[i]];
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
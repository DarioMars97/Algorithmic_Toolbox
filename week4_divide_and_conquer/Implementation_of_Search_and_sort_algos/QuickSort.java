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
        int k = left; // k is equalPivotRegionEndPosition
        int i = left; // i is lessThanPivotRegionEndPosition
        int j;// j is moreThanPivotRegionEndPosition which starts with pivot +1

        for (j = left + 1; j <= right; j++) {
            if (arr[j] <= pivot) {
                // increase equal pivot region 
                k++;
                if(arr[j] < pivot){
                    // increase less than pivot region
                    i++;
                    // swap arr[i] with arr[k]
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }else if (arr[j] == pivot) {
                    // swap arr[i] with arr[k]
                    int temp = arr[j];
                    arr[j] = arr[k];
                    arr[k] = temp;
                }
            }
        }
        // swap the pivot "which is the first element in the array"
        // arr[i] "which is the last element in the region that are smaller than the pivot"
        arr[left] = arr[i];
        arr[i] = pivot;
        return new Pair(i, k);
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
            int k = right + ((left - right)/2);
            // int k = (int) ((Math.random() * (right - left)) + left);
            // swap arr[k] with arr[left]
            int temp = arr[left];
            arr[left] = arr[k];
            arr[k] = temp;

            Pair pivotPositions = pivotPartition3(arr, left, right);
            optimizedTimeQuickSort(arr, left, pivotPositions.getFirst()-1);
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
        // int[] arr = {9,9,9,5,5,5,2,2,2,4};
        int [] arr = {63,	42,	79,	30,	29,
            24,	23,	92,	42,	10
            };
        quickSort(arr, 0, 49);
        int i = 5;
    }
}
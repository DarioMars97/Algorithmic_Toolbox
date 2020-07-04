public class QuickSort {

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

    public static void QuickSort(int[] arr, int left, int right) {
        if (arr.length <= right) {
            quickSortAlgorithm(arr, left, right-1);
        }else {
            quickSortAlgorithm(arr, left, right);
        }
    }

    public static void main(String[] args) {
        int[] arr = {6,4,3,9,8,2,9,4,7,6,1};
        QuickSort(arr, 0, 10);
    }
}
import java.util.Arrays;


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
        int[] arr = {14,9,3,10,9,5,4,2,12};
        int[] resutl = mergeSort(arr);
        for (int i : resutl) {
            System.out.print(i);
            System.out.println();
        }
    }
}
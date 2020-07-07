import java.util.*;

public class Inversions {

    public static long nuOfInversions = 0;

    public static int[] merge(int[] leftArr, int[] rightArr) {
        int leftCounter = 0, rightCounter = 0;
        int[] mergedArray = new int[leftArr.length+rightArr.length];
        while (leftCounter < leftArr.length || rightCounter < rightArr.length) {
            if (leftCounter < leftArr.length && rightCounter < rightArr.length) {
                if (leftArr[leftCounter] <= rightArr[rightCounter]) {
                    mergedArray[leftCounter+rightCounter] = leftArr[leftCounter];
                    leftCounter++;
                }else {
                    mergedArray[leftCounter+rightCounter] = rightArr[rightCounter];
                    rightCounter++;

                    // if first element in remaining right array > first element in remaining left array
                    // then we use the remaining # of elements in leftArr which is 
                    // leftArr.length - leftCounter
                    nuOfInversions+= leftArr.length - leftCounter;
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
        if (arr.length == 1) {
            return arr;
        }
        int[] left = Arrays.copyOfRange(arr, 0, arr.length/2);
        int[] right = Arrays.copyOfRange(arr, arr.length/2, arr.length);
        int[] leftArr = mergeSort(left);
        int[] rightArr = mergeSort(right);
        return merge(leftArr, rightArr);
    }

    private static long getNumberOfInversions(int[] a, int[] b, int left, int right) {
        long numberOfInversions = 0;
        if (right <= left + 1) {
            return numberOfInversions;
        }
        int ave = (left + right) / 2;
        numberOfInversions += getNumberOfInversions(a, b, left, ave);
        numberOfInversions += getNumberOfInversions(a, b, ave, right);
        //write your code here
        return numberOfInversions;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int[] b = new int[n];
        // System.out.println(getNumberOfInversions(a, b, 0, a.length));
        mergeSort(a);
        System.out.println(nuOfInversions);
    }
}


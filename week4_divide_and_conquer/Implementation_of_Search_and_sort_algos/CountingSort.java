import java.util.Arrays;

public class CountingSort {

    public static int[] countingSort(int[] arr, int M) {
        /**
         * int[] arr has elements of values from 1 to M
         */
        int[] countArr = new int[M+1];
        Arrays.fill(countArr, 0);
        int[] resultArr = new int[arr.length];
        Arrays.fill(resultArr, 0);

        // counting each element repeated how much.
        for (int i = 0; i < arr.length; i++) {
            countArr[arr[i]] += 1;
        }

        int addingCounter = 0;
        for (int i = 0; i < countArr.length; i++) {
            for (int j = 0; j < countArr[i]; j++) {
                resultArr[addingCounter] = i;
                addingCounter++;
            }
        }
        return resultArr;
    }
    public static void main(String[] args) {
        int[] arr = {9,4,2,6,2,1,6,8,4,2,6,5,3,6,67,3,2,6,7,4,2,5,7,8,0,6,4,3,5,6,9,7,5,3,3,2,9,6,4,3,12,23,64,75,87,45,87,54,43,86,23,65,23,32,11,32,1};
        int[] resultArr = countingSort(arr, 87);
        for (int i = 0; i < resultArr.length; i++) {
            System.out.print(resultArr[i] + " ");
        }
    }
}
public class QuickSort2ArraysBasedOnSortingOneArray {
    public static void swap2ElementsInArray(int[] arr, int firstIndex, int secondIndex) {
        int temp = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = temp;
    }

    public static int[] patition3(int[] baseArr, int[] sideArr, int left, int right) {
        int lt = left;
        int gt = right;
        int pivot = baseArr[left];

        for (int i = left; i <= gt; i++) {
            if (baseArr[i] < pivot) {
                swap2ElementsInArray(baseArr, i, lt);
                swap2ElementsInArray(sideArr, i, lt);
                lt++;
            }else if (baseArr[i] > pivot){
                swap2ElementsInArray(baseArr, i, gt);
                swap2ElementsInArray(sideArr, i, gt);
                gt--;
                i--;
            }
        }

        return new int[] {lt, gt};
    }

    public static void quickSort2ArraysBasedOnSortingOne(int[] baseArr,int[] sideArr, int left, int right){
        while (left < right) {
            int k = left+(right - left)/2;
            swap2ElementsInArray(baseArr, left, k);
            swap2ElementsInArray(sideArr, left, k);
            int[] partitions = patition3(baseArr, sideArr, left, right);
            quickSort2ArraysBasedOnSortingOne(baseArr, sideArr, left, partitions[0]-1);
            left = partitions[1]+1;
        }
    }

    public static void main(String[] args) {
        System.out.println("everything is OK In Shaa' Allah");
    }
}
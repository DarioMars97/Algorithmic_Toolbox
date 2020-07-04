public class BinarySearch {

    public static int BinarySearchRecursive(int[] arr, int low, int high, int x) {
        if (high < low) {
            return -1;
        }
        int mid = low + ((high - low) / 2);

        if (arr[mid] == x) {
            return mid;
        } else if (arr[mid] < x) {
            low = mid + 1;
        } else {
            high = mid - 1;
        }
        return BinarySearchRecursive(arr, low, high, x);
    }

    public static int BinarySearchIterative(int[] arr, int low, int high, int x) {
        while (low <= high) {
            int mid = low + ((high-low)/2);

            if (arr[mid] < x) {
                low = mid + 1;
            }else if(arr[mid] > x){
                high = mid - 1;
            }else{
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 4, 6, 8, 10, 14, 20, 25, 29, 34, 40 };
        int x = BinarySearchRecursive(arr, 0, 9, 20);
        int y = BinarySearchIterative(arr, 0, 9, 20);
        System.out.println(x);
        System.out.println(y);
    }
}
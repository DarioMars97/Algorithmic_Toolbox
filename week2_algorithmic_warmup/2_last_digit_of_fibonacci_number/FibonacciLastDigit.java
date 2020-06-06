import java.util.*;

public class FibonacciLastDigit {
    private static int getFibonacciLastDigitNaive(int n) {
        if (n <= 1)
            return n;

        int previous = 0;
        int current  = 1;

        for (int i = 0; i < n - 1; ++i) {
            int tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
        }

        return current % 10;
    }


    /**
     * this is my implementation and it solvs the problem 
     * 0,1,1,2,3,5,8,13,21,34,55,89,144,233.377
     * try to add just the last number
     * 0,1,1,2,3,5,8,3,1,4,5,9,4,3,7
     * @param args
     */
     private static int getFibonacciLastDigiteffecient(int n) {
         if (n<=1) {
             return n;
         }

         int previous=0;
         int current=1;

         for (int i = 0; i < n-1; i++) {
             int temp = previous;
             previous = current;
             current = (temp + current)%10;
         }
         return current;
     }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int c = getFibonacciLastDigiteffecient(n);
        System.out.println(c);
    }
}


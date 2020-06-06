import java.util.Scanner;

public class Fibonacci {
  private static long calc_fib(int n) {
    if (n <= 1)
      return n;

    return calc_fib(n - 1) + calc_fib(n - 2);
  }

  /** 
   * this is mine function to return Fn with the temporary variable
   * O(n)*/ 
  private static long calc_fib_temp_method(int n){

    if (n <= 1)
      return n;
    
    long last2= 0;
    long last1= 1;
    long result =0;
    for (int i = 1; i < n; i++) {
      result = last1+last2;
      last2 = last1;
      last1 = result;
    }
    return result;
  }

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();

    // System.out.println(calc_fib(n));
    System.out.println(calc_fib_temp_method(n));
  }
}

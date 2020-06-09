import java.util.*;

public class GCD {
  private static int gcd_naive(int a, int b) {
    int current_gcd = 1;
    for(int d = 2; d <= a && d <= b; ++d) {
      if (a % d == 0 && b % d == 0) {
        if (d > current_gcd) {
          current_gcd = d;
        }
      }
    }

    return current_gcd;
  }

  /**
   * This is my implementation
   * the bigger d that a and b can be multiplied with
   * 
   */
  private static int EuclidGCD(int a, int b) {
    if (b == 0) {
      return a;
    }

    int a_= a%b;
    return EuclidGCD(b, a_);
  }
  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    // System.out.println(gcd_naive(a, b));
    System.out.println(EuclidGCD(a, b));
  }
}

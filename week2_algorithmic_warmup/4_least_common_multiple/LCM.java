import java.util.*;

public class LCM {
  private static long lcm_naive(int a, int b) {
    for (long l = 1; l <= (long) a * b; ++l)
      if (l % a == 0 && l % b == 0)
        return l;

    return (long) a * b;
  }

  private static int EuclidGCD(int a, int b) {
    if (b == 0) {
      return a;
    }

    int a_= a%b;
    return EuclidGCD(b, a_);
  }

  /**
   * least common multiple example: lcm(5,8)
   * multiples of 6: 6 12 18 24 30 36 42 48 45 
   * multiples of 8: 8 16 24 32 40 48 56 64 72
   * lcm is 24
   * if we take the GCD of 6 and 8 would be 2 and it is the (6*8)/24 
   * so lcm of a and b is (a*b)/gcd
   */

  private static long lcmEffective(int a, int b) {
    return (a*(long)b)/EuclidGCD(a, b);
  }
  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    // System.out.println(lcm_naive(a, b));
    System.out.println(lcmEffective(a, b));
  }
}

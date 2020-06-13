import java.util.*;

public class FibonacciSumSquares {
    private static long getFibonacciSumSquaresNaive(long n) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;
        long sum      = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
            sum += current * current;
        }

        return sum % 10;
    }

    private static ArrayList<Integer> getPisanoPeriod(int m) {
        /**
         * pisano period starts with 0, 1
         * returns the list of pisano period
         */
        ArrayList<Integer> pisanoPeriodArray = new ArrayList<>();
        int pisanoPeriod=2;

        pisanoPeriodArray.add(Integer.valueOf(0));
        pisanoPeriodArray.add(Integer.valueOf(1));
        while (true) {
            if (pisanoPeriod != 2 && pisanoPeriodArray.get(pisanoPeriod-2) == 0 && 
            pisanoPeriodArray.get(pisanoPeriod-1) == 1) {
                pisanoPeriodArray.remove(pisanoPeriod-1);
                pisanoPeriodArray.remove(pisanoPeriod-2);
                break;
            }
            pisanoPeriodArray.add(
                (pisanoPeriodArray.get(pisanoPeriod-2) +
                pisanoPeriodArray.get(pisanoPeriod-1))%
                m);
            pisanoPeriod++;
        }
        return pisanoPeriodArray;
    }

    private static int getFibonacciHuge(long n, int m) {
        if (n <= 1)
            return (int)n;

        ArrayList pisanoPeriod = getPisanoPeriod(m);
        int thePairOfNInPisanoPeriod = (int)(n%pisanoPeriod.size());
        return (int)pisanoPeriod.get(thePairOfNInPisanoPeriod);
    }

    private static int getFibonacciSumSquares(long n) {
        /**
         * sum of squares is (f(n) + f(n-1))*f(n)
         */

         if (n<=1) {
             return (int)n;
         }
         int fN = getFibonacciHuge(n, 10);
         int fNPrevious = getFibonacciHuge(n-1, 10);
         return ((fN + fNPrevious)*fN)%10;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        int s = getFibonacciSumSquares(n);
        System.out.println(s);
    }
}


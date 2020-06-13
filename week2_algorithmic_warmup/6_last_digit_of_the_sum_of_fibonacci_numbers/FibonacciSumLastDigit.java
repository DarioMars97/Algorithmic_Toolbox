import java.util.*;

public class FibonacciSumLastDigit {
    private static long getFibonacciSumNaive(long n) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;
        long sum      = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
            sum += current;
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

    private static int getFibonacciSumHuge(long n) {
        /**
         * sum(n) = f(n+2) -1
         * last digit is remainder 10 and it has pisano period of 60
         * so we can find it by (n+2)%60=p then get f(p) and subtract 1 from it
         * if the output = 0 then the subtraction will give -1 and the real number is 9
         */
        if (n <= 1)
            return (int)(n%10);
        
        n+=2;
        ArrayList pisanoPeriod = getPisanoPeriod(10);
        int thePairOfNInPisanoPeriod = (int)(n%pisanoPeriod.size());
        return ((int)pisanoPeriod.get(thePairOfNInPisanoPeriod) != 0)?
        ((int)pisanoPeriod.get(thePairOfNInPisanoPeriod) -1):
        9;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        // long s = getFibonacciSumNaive(n);
        int s = getFibonacciSumHuge(n);
        System.out.println(s);
    }
}


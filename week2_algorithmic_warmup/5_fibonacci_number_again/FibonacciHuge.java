import java.util.*;

public class FibonacciHuge {
    private static long getFibonacciHugeNaive(long n, long m) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
        }

        return current % m;
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

    private static long getFibonacciHuge(long n, int m) {
        if (n <= 1)
            return n;

        ArrayList pisanoPeriod = getPisanoPeriod(m);
        int thePairOfNInPisanoPeriod = (int)(n%pisanoPeriod.size());
        return (int)pisanoPeriod.get(thePairOfNInPisanoPeriod);
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        int m = scanner.nextInt();
        // System.out.println(getFibonacciHugeNaive(n, m));
        System.out.println(getFibonacciHuge(n, m));
    }
}


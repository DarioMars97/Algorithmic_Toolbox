import java.util.*;

public class FibonacciPartialSum {
    private static long getFibonacciPartialSumNaive(long from, long to) {
        long sum = 0;

        long current = 0;
        long next  = 1;

        for (long i = 0; i <= to; ++i) {
            if (i >= from) {
                sum += current;
            }

            long new_current = next;
            next = next + current;
            current = new_current;
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

    private static int getFibonacciPartialSum(long from, long to) {
        /**
         * bounded summation is equal to s(to) - s(from-1)
         */
        int toOut = getFibonacciSumHuge(to);
        int fromOut = from == 0? 0 : getFibonacciSumHuge(from - 1);
        int result = (toOut >= fromOut)? toOut - fromOut: toOut + 10 - fromOut;
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long from = scanner.nextLong();
        long to = scanner.nextLong();
        System.out.println(getFibonacciPartialSum(from, to));
    }
}


import java.util.*;

public class SumOfFibAgain {
    private static long pisanoPeriod(long m) {
        long a = 0, b = 1, c = a + b;
        for (int i = 0; i < m * m; i++) {
            c = (a + b) % m;
            a = b;
            b = c;
            if (a == 0 && b == 1) {
                return i + 1;
            }
        }
        return 0;
    }

    private static long partialSum(long from, long to, long m) {
        long period = pisanoPeriod(m);
        long remainderFrom = from % period;
        long remainderTo = to % period;

        long sum = 0;
        long current = 0;
        long next = 1;

        if (remainderTo < remainderFrom) {
            remainderTo += period;
        }

        for (long i = 0; i <= remainderTo; ++i) {
            if (i >= remainderFrom) {
                sum = (sum + current) % m;
            }

            long temp = next;
            next = (next + current) % m;
            current = temp;
        }

        return sum % 10;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long from = in.nextLong();
        long to = in.nextLong();
        long m = 10;

        long result = partialSum(from, to, m);
        System.out.println(result);
    }
}

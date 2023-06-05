import java.util.*;

public class FibSquare {
    private static int fibSquareSum(long n) {
        int pisanoPeriod = 60;
        int rem = (int) (n % pisanoPeriod);
        int previous = 0;
        int current = 1;

        if (rem <= 1) {
            return rem;
        }

        int sum = 1;

        for (int i = 0; i < rem - 1; i++) {
            int temp = previous;
            previous = current;
            current = (temp + current) % 10;
            sum = (sum + current * current) % 10;
        }

        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        int sumSquares = fibSquareSum(n);
        System.out.println(sumSquares);
    }
}

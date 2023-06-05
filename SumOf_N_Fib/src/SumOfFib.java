import java.sql.SQLOutput;
import java.util.Scanner;

public class SumOfFib
{
    private static long fib_sum(long n)
    {
        if (n <= 1)
            return n;

        long first = 0;
        long next  = 1;
        long sum   = 1;

        for (long i = 0; i < n - 1; ++i)
        {
            long tmp_previous = first;
            first = next;
            next = tmp_previous + next;
            sum += next;
        }

        return sum % 10;
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        long a = in.nextLong();
        a=a%60;
        System.out.println(fib_sum(a));
    }
}
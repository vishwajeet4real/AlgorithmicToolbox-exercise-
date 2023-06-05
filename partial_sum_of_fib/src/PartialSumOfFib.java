import java.util.Scanner;

public class PartialSumOfFib
{
    private static long partial_sum(long from, long to)
    {
        if (to <= 1)
            return to;

        long previous = 0;
        long current  = 1;

        for (long i = 0; i < from - 1; ++i)
        {
            long temp = previous;
            previous = current;
            current = (temp + current)%10;
        }
        if(to==-1)
            return current;
        long sum = current;

        for (long i = 0; i < to - from; ++i)
        {
            long temp = previous;
            previous = current;
            current =(temp + current)%10;
            sum += current;
        }
        return sum%10;
    }
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        long a = in.nextLong();
        long b = in.nextLong();
        long c=b-a;
        a=a%60;
        b=b+c;
        c=c%60;
        System.out.println(partial_sum(a, a+c));
    }
}
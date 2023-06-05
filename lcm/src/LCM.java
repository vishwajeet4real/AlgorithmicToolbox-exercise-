import java.util.Scanner;

public class LCM {
    private static long gcd(long a, long b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    private static long lcm(long a, long b) {
        long gcdValue = gcd(a, b);
        return (a * b) / gcdValue;
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        long a = in.nextLong();
        long b = in.nextLong();

        System.out.println(lcm(a, b));
    }
}

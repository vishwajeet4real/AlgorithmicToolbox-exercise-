import java.util.Scanner;

public class FibonacciNumberAgain {
    private static long[][] multiplyMatrix(long[][] a, long[][] b, long m) {
        long[][] result = new long[2][2];
        result[0][0] = (a[0][0] * b[0][0] + a[0][1] * b[1][0]) % m;
        result[0][1] = (a[0][0] * b[0][1] + a[0][1] * b[1][1]) % m;
        result[1][0] = (a[1][0] * b[0][0] + a[1][1] * b[1][0]) % m;
        result[1][1] = (a[1][0] * b[0][1] + a[1][1] * b[1][1]) % m;
        return result;
    }

    private static long[][] powerMatrix(long[][] matrix, long exponent, long m) {
        if (exponent == 1) {
            return matrix;
        }

        long[][] half = powerMatrix(matrix, exponent / 2, m);
        long[][] result = multiplyMatrix(half, half, m);

        if (exponent % 2 == 1) {
            result = multiplyMatrix(result, matrix, m);
        }

        return result;
    }

    private static long fibMod(long n, long m) {
        if (n <= 1) {
            return n;
        }

        long[][] matrix = {{1, 1}, {1, 0}};
        matrix = powerMatrix(matrix, n - 1, m);

        return matrix[0][0] % m;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        System.out.println(fibMod(n, m));
    }
}

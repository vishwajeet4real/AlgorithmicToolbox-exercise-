import java.util.*;

public class FibNumAgain {
    private static long[][] multiply(long[][] matrix1, long[][] matrix2, long mod) {
        int rows1 = matrix1.length;
        int cols1 = matrix1[0].length;
        int cols2 = matrix2[0].length;

        long[][] result = new long[rows1][cols2];

        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                for (int k = 0; k < cols1; k++) {
                    result[i][j] = (result[i][j] + matrix1[i][k] * matrix2[k][j]) % mod;
                }
            }
        }

        return result;
    }

    private static long[][] power(long[][] matrix, long n, long mod) {
        int size = matrix.length;

        if (n == 0) {
            long[][] identityMatrix = new long[size][size];
            for (int i = 0; i < size; i++) {
                identityMatrix[i][i] = 1;
            }
            return identityMatrix;
        }

        long[][] result = power(matrix, n / 2, mod);
        result = multiply(result, result, mod);

        if (n % 2 == 1) {
            result = multiply(result, matrix, mod);
        }

        return result;
    }

    private static long fib(long n, long mod) {
        if (n <= 1) {
            return n;
        }

        long[][] matrix = {{1, 1}, {1, 0}};
        long[][] result = power(matrix, n - 1, mod);

        return result[0][0] % mod;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        long mod = in.nextLong();
        long result = fib(n, mod);
        System.out.println(result);
    }
}

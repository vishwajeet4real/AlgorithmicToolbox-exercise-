import java.util.Scanner;

public class Paranthesis {
    private static long getMaxValue(String expression) {
        int length = expression.length();
        int numCount = (length + 1) / 2;
        long[][] maxValues = new long[numCount][numCount];
        long[][] minValues = new long[numCount][numCount];

        for (int i = 0; i < numCount; i++) {
            maxValues[i][i] = Long.parseLong(Character.toString(expression.charAt(2 * i)));
            minValues[i][i] = Long.parseLong(Character.toString(expression.charAt(2 * i)));
        }

        for (int s = 0; s < numCount - 1; s++) {
            for (int i = 0; i < numCount - s - 1; i++) {
                int j = i + s + 1;
                long[] minAndMax = getMinAndMax(i, j, maxValues, minValues, expression);
                minValues[i][j] = minAndMax[0];
                maxValues[i][j] = minAndMax[1];
            }
        }

        return maxValues[0][numCount - 1];
    }

    private static long[] getMinAndMax(int i, int j, long[][] maxValues, long[][] minValues, String expression) {
        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;

        for (int k = i; k < j; k++) {
            long a = eval(maxValues[i][k], maxValues[k + 1][j], expression.charAt(2 * k + 1));
            long b = eval(maxValues[i][k], minValues[k + 1][j], expression.charAt(2 * k + 1));
            long c = eval(minValues[i][k], maxValues[k + 1][j], expression.charAt(2 * k + 1));
            long d = eval(minValues[i][k], minValues[k + 1][j], expression.charAt(2 * k + 1));
            min = Math.min(min, Math.min(a, Math.min(b, Math.min(c, d))));
            max = Math.max(max, Math.max(a, Math.max(b, Math.max(c, d))));
        }

        return new long[]{min, max};
    }

    private static long eval(long a, long b, char operator) {
        if (operator == '+') {
            return a + b;
        } else if (operator == '-') {
            return a - b;
        } else if (operator == '*') {
            return a * b;
        } else {
            throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.next();
        System.out.println(getMaxValue(expression));
    }
}

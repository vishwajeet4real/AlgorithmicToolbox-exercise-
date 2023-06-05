import java.util.*;

public class DifferentSummands {
    private static List<Integer> optimalSummands(int n) {
        List<Integer> summands = new ArrayList<>();

        int remaining = n;
        int current = 1;

        while (remaining > 0) {
            if (remaining <= 2 * current) {
                summands.add(remaining);
                break;
            }

            summands.add(current);
            remaining -= current;
            current++;
        }

        return summands;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> summands = optimalSummands(n);
        System.out.println(summands.size());
        for (Integer summand : summands) {
            System.out.print(summand + " ");
        }
    }
}

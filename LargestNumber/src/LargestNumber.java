import java.util.*;

public class LargestNumber {
    private static String largestNumber(String[] a) {
        Arrays.sort(a, new NumberComparator());

        StringBuilder result = new StringBuilder();
        for (String number : a) {
            result.append(number);
        }

        return result.toString();
    }

    private static class NumberComparator implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            String order1 = a + b;
            String order2 = b + a;
            return order2.compareTo(order1); // Compare in descending order
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next();
        }
        System.out.println(largestNumber(a));
    }
}

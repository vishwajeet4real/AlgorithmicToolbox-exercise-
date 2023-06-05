import java.util.Scanner;

public class BinarySearchDuplicate {
    static int findFirstOccurrence(int[] a, int key) {
        int left = 0;
        int right = a.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (a[mid] == key) {
                result = mid;
                right = mid - 1;
            } else if (a[mid] < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the size of the sequence and the sequence itself
        int n = scanner.nextInt();
        int[] sequence = new int[n];
        for (int i = 0; i < n; i++) {
            sequence[i] = scanner.nextInt();
        }

        // Read the number of queries and the queries themselves
        int m = scanner.nextInt();
        int[] queries = new int[m];
        for (int i = 0; i < m; i++) {
            queries[i] = scanner.nextInt();
        }

        // Find the first occurrence of each query in the sequence
        for (int i = 0; i < m; i++) {
            int query = queries[i];
            int index = findFirstOccurrence(sequence, query);
            System.out.print(index + " ");
        }
    }
}

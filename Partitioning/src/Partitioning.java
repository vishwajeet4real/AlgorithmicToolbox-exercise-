import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Partitioning {
    static boolean partition_search(List<Long> A, int index, List<Long> partitions, long target) {
        if (index >= A.size()) return true;
        for (int i = 0; i < partitions.size(); i++) {
            if (partitions.get(i) + A.get(index) <= target) {
                partitions.set(i, partitions.get(i) + A.get(index));
                if (partition_search(A, index + 1, partitions, target)) {
                    return true;
                }
                partitions.set(i, partitions.get(i) - A.get(index));
            }
        }
        return false;
    }

    static boolean partition3(List<Long> A) {
        long n = 0;
        for (long x : A) {
            n += x;
        }
        if (n % 3 != 0 || A.size() < 3 || Collections.max(A) > n / 3) {
            return false;
        }

        Collections.sort(A, Collections.reverseOrder());
        List<Long> partitions = new ArrayList<>(3);
        partitions.add(0L);
        partitions.add(0L);
        partitions.add(0L);
        return partition_search(A, 0, partitions, n / 3);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Long> A = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            A.add(scanner.nextLong());
        }
        System.out.println(partition3(A) ? 1 : 0);
    }
}

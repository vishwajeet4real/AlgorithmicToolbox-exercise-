import java.util.*;
import java.io.*;

public class MajorityElement {
    private static int getMajorityElement(int[] arr, int left, int right) {
        if (left == right) {
            return -1;
        }
        if (left + 1 == right) {
            return arr[left];
        }

        // Use HashMap to count the occurrences of each element
        Map<Integer, Integer> counts = new HashMap<>();
        for (int i = left; i < right; i++) {
            int num = arr[i];
            counts.put(num, counts.getOrDefault(num, 0) + 1);

            // If the count exceeds half the array size, return the majority element
            if (counts.get(num) > (right - left) / 2) {
                return num;
            }
        }

        return -1;  // No majority element found
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        if (getMajorityElement(arr, 0, arr.length) != -1) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}

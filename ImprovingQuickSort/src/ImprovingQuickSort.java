import java.io.*;
import java.util.*;

public class ImprovingQuickSort {
    private static Random random = new Random();

    private static int[] partition3(int[] arr, int left, int right) {
        int pivot = arr[left];
        int mid1 = left;
        int mid2 = right;
        int i = left + 1;

        while (i <= mid2) {
            if (arr[i] < pivot) {
                swap(arr, i, mid1);
                mid1++;
                i++;
            } else if (arr[i] > pivot) {
                swap(arr, i, mid2);
                mid2--;
            } else {
                i++;
            }
        }

        int[] m = { mid1, mid2 };
        return m;
    }

    private static int partition2(int[] arr, int left, int right) {
        int pivot = arr[left];
        int j = left;

        for (int i = left + 1; i <= right; i++) {
            if (arr[i] <= pivot) {
                j++;
                swap(arr, i, j);
            }
        }

        swap(arr, left, j);
        return j;
    }

    private static void randomizedQuickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int k = random.nextInt(right - left + 1) + left;
        swap(arr, left, k);

        int[] m = partition3(arr, left, right);
        randomizedQuickSort(arr, left, m[0] - 1);
        randomizedQuickSort(arr, m[1] + 1, right);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        randomizedQuickSort(arr, 0, n - 1);
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
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

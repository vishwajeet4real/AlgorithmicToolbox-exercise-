import java.util.*;

public class Inversion {

    private static long countInversions(int[] arr, int[] aux, int left, int right) {
        long inversions = 0;
        if (right <= left + 1) {
            return inversions;
        }
        int mid = (left + right) / 2;
        inversions += countInversions(arr, aux, left, mid);
        inversions += countInversions(arr, aux, mid, right);
        inversions += merge(arr, aux, left, mid, right);
        return inversions;
    }

    private static long merge(int[] arr, int[] aux, int left, int mid, int right) {
        long inversions = 0;
        int i = left;
        int j = mid;
        int k = left;

        while (i < mid && j < right) {
            if (arr[i] <= arr[j]) {
                aux[k++] = arr[i++];
            } else {
                aux[k++] = arr[j++];
                inversions += mid - i;  // Count inversions
            }
        }

        while (i < mid) {
            aux[k++] = arr[i++];
        }

        while (j < right) {
            aux[k++] = arr[j++];
        }

        System.arraycopy(aux, left, arr, left, right - left);  // Copy merged elements back to the original array

        return inversions;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int[] aux = new int[n];
        System.out.println(countInversions(arr, aux, 0, n));
    }
}

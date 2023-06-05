import java.io.*;
import java.util.*;

public class Closest {

    static class Point {
        long x, y;

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    static double minimalDistance(int[] x, int[] y) {
        Point[] points = new Point[x.length];
        for (int i = 0; i < x.length; i++) {
            points[i] = new Point(x[i], y[i]);
        }

        Arrays.sort(points, Comparator.comparingLong(point -> point.x));
        return closestPair(points, 0, points.length - 1);
    }

    static double closestPair(Point[] points, int left, int right) {
        if (right - left <= 2) {
            return bruteForce(points, left, right);
        }

        int mid = (left + right) / 2;
        double leftMinDist = closestPair(points, left, mid);
        double rightMinDist = closestPair(points, mid + 1, right);
        double minDist = Math.min(leftMinDist, rightMinDist);

        List<Point> strip = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (Math.abs(points[i].x - points[mid].x) <= minDist) {
                strip.add(points[i]);
            }
        }

        Collections.sort(strip, Comparator.comparingLong(point -> point.y));

        double stripMinDist = minDist;
        for (int i = 0; i < strip.size(); i++) {
            for (int j = i + 1; j < strip.size() && (strip.get(j).y - strip.get(i).y) < stripMinDist; j++) {
                double dist = distance(strip.get(i), strip.get(j));
                minDist = Math.min(minDist, dist);
            }
        }

        return minDist;
    }

    static double bruteForce(Point[] points, int left, int right) {
        double minDist = Double.POSITIVE_INFINITY;
        for (int i = left; i <= right; i++) {
            for (int j = i + 1; j <= right; j++) {
                double dist = distance(points[i], points[j]);
                minDist = Math.min(minDist, dist);
            }
        }
        return minDist;
    }

    static double distance(Point p1, Point p2) {
        long dx = p1.x - p2.x;
        long dy = p1.y - p2.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            String[] coordinates = reader.readLine().split(" ");
            x[i] = Integer.parseInt(coordinates[0]);
            y[i] = Integer.parseInt(coordinates[1]);
        }
        System.out.println(minimalDistance(x, y));
    }
}

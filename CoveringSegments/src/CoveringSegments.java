import java.util.*;

public class CoveringSegments {

    private static int[] optimalPoints(Segment[] segments) {
        Arrays.sort(segments, Comparator.comparingInt(s -> s.end)); // Sort segments based on the end points

        List<Integer> pointsList = new ArrayList<>();
        int currentPoint = segments[0].end;
        pointsList.add(currentPoint);

        for (int i = 1; i < segments.length; i++) {
            if (currentPoint < segments[i].start || currentPoint > segments[i].end) {
                currentPoint = segments[i].end;
                pointsList.add(currentPoint);
            }
        }

        int[] points = new int[pointsList.size()];
        for (int i = 0; i < points.length; i++) {
            points[i] = pointsList.get(i);
        }

        return points;
    }

    private static class Segment {
        int start, end;

        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Segment[] segments = new Segment[n];
        for (int i = 0; i < n; i++) {
            int start, end;
            start = scanner.nextInt();
            end = scanner.nextInt();
            segments[i] = new Segment(start, end);
        }
        int[] points = optimalPoints(segments);
        System.out.println(points.length);
        for (int point : points) {
            System.out.print(point + " ");
        }
    }
}

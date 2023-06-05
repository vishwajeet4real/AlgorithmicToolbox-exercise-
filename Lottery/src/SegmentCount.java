import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Segment implements Comparable<Segment> {
    int start;
    int end;

    public Segment(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Segment other) {
        return this.start - other.start;
    }
}

class Point implements Comparable<Point> {
    int value;
    int index;

    public Point(int value, int index) {
        this.value = value;
        this.index = index;
    }

    @Override
    public int compareTo(Point other) {
        return this.value - other.value;
    }
}

public class SegmentCount {
    public static List<Integer> computePayoffs(List<Segment> segments, List<Point> points) {
        List<Integer> payoffs = new ArrayList<>();

        // Sort segments by their start points
        Collections.sort(segments);

        // Sort points by their values
        Collections.sort(points);

        int[] segmentCounts = new int[segments.size()];
        int segmentIndex = 0;

        for (int i = 0; i < points.size(); i++) {
            int count = 0;

            while (segmentIndex < segments.size() && segments.get(segmentIndex).start <= points.get(i).value) {
                if (segments.get(segmentIndex).end >= points.get(i).value) {
                    count++;
                }
                segmentIndex++;
            }

            segmentCounts[i] = count;
        }

        // Map the segment counts to the original order of points
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < points.size(); i++) {
            indexMap.put(points.get(i).index, segmentCounts[i]);
        }

        for (int i = 0; i < points.size(); i++) {
            payoffs.add(indexMap.get(i));
        }

        return payoffs;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Segment> segments = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            segments.add(new Segment(start, end));
        }

        List<Point> points = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int value = Integer.parseInt(st.nextToken());
            points.add(new Point(value, i));
        }

        br.close();

        List<Integer> payoffs = computePayoffs(segments, points);

        for (int payoff : payoffs) {
            System.out.print(payoff + " ");
        }
    }
}

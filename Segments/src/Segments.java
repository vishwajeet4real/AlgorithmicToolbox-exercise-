import java.util.Arrays;
import java.util.Scanner;

public class Segments {
    enum PointType {
        SEGMENT_START,
        POINT,
        SEGMENT_END,
    }

    static class SuperPoint {
        final PointType type;
        final int x;
        final int index;

        public SuperPoint(final PointType type, final int x) {
            this(type, x, -1);
        }

        public SuperPoint(final PointType type, final int x, final int index) {
            this.type = type;
            this.x = x;
            this.index = index;
        }
    }

    private static int[] countSegments(final SuperPoint[] allPoints, final int pointsCount) {
        Arrays.sort(allPoints, (o1, o2) -> {
            if (o1.x < o2.x)
                return -1;
            if (o1.x > o2.x)
                return 1;
            return Integer.compare(o1.type.ordinal(), o2.type.ordinal());
        });

        final int[] result = new int[pointsCount];
        int counter = 0;

        for (final SuperPoint superPoint : allPoints) {
            switch (superPoint.type) {
                case SEGMENT_START:
                    counter++;
                    break;
                case SEGMENT_END:
                    counter--;
                    break;
                case POINT:
                    result[superPoint.index] = counter;
                    break;
                default:
                    throw new IllegalArgumentException(String.format("Unknown SuperPoint type: %s", superPoint.type));
            }
        }

        return result;
    }

    public static void main(final String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            final int numberOfSegments = scanner.nextInt();
            final int numberOfPoints = scanner.nextInt();

            final SuperPoint[] allPoints = new SuperPoint[(numberOfSegments * 2) + numberOfPoints];
            int allPointsIndex = 0;

            for (int i = 0; i < numberOfSegments; i++) {
                final int start = scanner.nextInt();
                final int end = scanner.nextInt();

                allPoints[allPointsIndex] = new SuperPoint(PointType.SEGMENT_START, start);
                allPointsIndex++;

                allPoints[allPointsIndex] = new SuperPoint(PointType.SEGMENT_END, end);
                allPointsIndex++;
            }

            for (int i = 0; i < numberOfPoints; i++) {
                final int x = scanner.nextInt();

                allPoints[allPointsIndex] = new SuperPoint(PointType.POINT, x, i);
                allPointsIndex++;
            }

            final int[] pointsSegmentsCounts = countSegments(allPoints, numberOfPoints);

            for (final int count : pointsSegmentsCounts) {
                System.out.print(count+ " ");
            }
        }
    }
}

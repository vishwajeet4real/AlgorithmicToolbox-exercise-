import java.util.Scanner;

public class CarFueling {
    static int computeMinRefills(int distance, int tankCapacity, int[] stations) {
        int numRefills = 0;
        int currentRefill = 0;
        int lastRefill = -1;
        int numStations = stations.length;

        while (currentRefill < numStations - 1) {
            lastRefill = currentRefill;

            while (currentRefill < numStations - 1 && stations[currentRefill + 1] - stations[lastRefill] <= tankCapacity) {
                currentRefill++;
            }

            if (currentRefill == lastRefill) {
                // Unable to reach the next station
                return -1;
            }

            if (currentRefill < numStations - 1) {
                numRefills++;
            }
        }

        if (distance - stations[lastRefill] > tankCapacity) {
            // Unable to reach the destination
            return -1;
        }

        return numRefills;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int distance = scanner.nextInt();
        int tankCapacity = scanner.nextInt();
        int numStations = scanner.nextInt();
        int[] stations = new int[numStations + 2];
        stations[0] = 0;
        for (int i = 1; i <= numStations; i++) {
            stations[i] = scanner.nextInt();
        }
        stations[numStations + 1] = distance;

        System.out.println(computeMinRefills(distance, tankCapacity, stations));
    }
}

import java.util.*;

public class MaxLoot{
    private static double value(int capacity, int[] itemValues, int[] itemWeights) {
        int numItems = itemValues.length;
        double[] valuePerWeight = new double[numItems];
        for (int i = 0; i < numItems; i++) {
            valuePerWeight[i] = (double) itemValues[i] / itemWeights[i];
        }

        sortItemsByValuePerWeight(itemValues, itemWeights, valuePerWeight);

        double totalValue = 0.0;
        int remainingCapacity = capacity;

        for (int i = 0; i < numItems; i++) {
            if (remainingCapacity == 0) {
                break;
            }

            int currentWeight = Math.min(itemWeights[i], remainingCapacity);
            totalValue += currentWeight * valuePerWeight[i];
            remainingCapacity -= currentWeight;
        }

        return totalValue;
    }

    private static void sortItemsByValuePerWeight(int[] itemValues, int[] itemWeights, double[] valuePerWeight) {
        int numItems = itemValues.length;

        for (int i = 0; i < numItems - 1; i++) {
            int maxIndex = i;

            for (int j = i + 1; j < numItems; j++) {
                if (valuePerWeight[j] > valuePerWeight[maxIndex]) {
                    maxIndex = j;
                }
            }

            swapItems(itemValues, itemWeights, valuePerWeight, i, maxIndex);
        }
    }

    private static void swapItems(int[] itemValues, int[] itemWeights, double[] valuePerWeight, int i, int j) {
        int tempValue = itemValues[i];
        itemValues[i] = itemValues[j];
        itemValues[j] = tempValue;

        int tempWeight = itemWeights[i];
        itemWeights[i] = itemWeights[j];
        itemWeights[j] = tempWeight;

        double tempRatio = valuePerWeight[i];
        valuePerWeight[i] = valuePerWeight[j];
        valuePerWeight[j] = tempRatio;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int numItems = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] itemValues = new int[numItems];
        int[] itemWeights = new int[numItems];
        for (int i = 0; i < numItems; i++) {
            itemValues[i] = scanner.nextInt();
            itemWeights[i] = scanner.nextInt();
        }
        System.out.println(value(capacity, itemValues, itemWeights));
    }
}

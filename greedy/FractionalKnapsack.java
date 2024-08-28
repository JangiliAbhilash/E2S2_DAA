import java.util.Arrays;
import java.util.Scanner;

class Item {
    int weight;
    int value;

    Item(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }
}

public class FractionalKnapsack {
    private static double getMaxValue(int capacity, Item[] items) {
        Arrays.sort(items, (a, b) -> (b.value * a.weight) - (a.value * b.weight)); // Sort items by value-to-weight ratio

        double totalValue = 0;
        for (Item item : items) {
            if (capacity - item.weight >= 0) {
                capacity -= item.weight;
                totalValue += item.value;
            } else {
                double fraction = (double) capacity / (double) item.weight;
                totalValue += item.value * fraction;
                break;
            }
        }

        return totalValue;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of items: ");
        int n = scanner.nextInt();
        Item[] items = new Item[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter weight and value for item " + (i + 1) + ": ");
            int weight = scanner.nextInt();
            int value = scanner.nextInt();
            items[i] = new Item(weight, value);
        }

        System.out.print("Enter the capacity of the knapsack: ");
        int capacity = scanner.nextInt();

        double maxValue = getMaxValue(capacity, items);
        System.out.println("Maximum value we can obtain = " + maxValue);

        scanner.close();
    }
}


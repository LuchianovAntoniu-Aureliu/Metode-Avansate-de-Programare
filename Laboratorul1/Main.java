import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        // Exercise 1
        int[] grades = {29, 37, 38, 41, 84, 67};

        System.out.println("EXERCISE 1");
        System.out.println("Failing grades: "
                + Arrays.toString(
                Exercise1.failingGrades(grades)));

        System.out.printf("Average: %.2f%n",
                Exercise1.averageGrade(grades));

        System.out.println("Rounded grades: "
                + Arrays.toString(
                Exercise1.roundedGrades(grades)));

        System.out.println("Highest rounded grade: "
                + Exercise1.highestRoundedGrade(grades));

        // Exercise 2
        int[] numbers = {4, 8, 3, 10, 17};

        System.out.println("\nEXERCISE 2");
        System.out.println("Maximum: "
                + Exercise2.maximum(numbers));

        System.out.println("Minimum: "
                + Exercise2.minimum(numbers));

        System.out.println("Maximum sum of n-1: "
                + Exercise2.maximumSumOfNMinusOne(numbers));

        System.out.println("Minimum sum of n-1: "
                + Exercise2.minimumSumOfNMinusOne(numbers));

        // Exercise 3
        System.out.println("\nEXERCISE 3");

        System.out.println("Addition: "
                + Arrays.toString(Exercise3.add(
                new int[]{1, 3, 0, 0, 0, 0, 0, 0, 0},
                new int[]{8, 7, 0, 0, 0, 0, 0, 0, 0})));

        System.out.println("Subtraction: "
                + Exercise3.subtract(
                new int[]{8, 3, 0},
                new int[]{5, 4, 0}));

        System.out.println("Negative subtraction: "
                + Exercise3.subtract(
                new int[]{5, 4, 0},
                new int[]{8, 3, 0}));

        System.out.println("Multiplication: "
                + Arrays.toString(Exercise3.multiply(
                new int[]{2, 3, 6}, 2)));

        System.out.println("Division: "
                + Arrays.toString(Exercise3.divide(
                new int[]{2, 3, 6}, 2)));

        // Exercise 4
        int[] keyboards = {40, 50, 60};
        int[] usbDrives = {8, 12};
        int budget = 60;

        System.out.println("\nEXERCISE 4");

        System.out.println("Cheapest keyboard: "
                + Exercise4.cheapestKeyboard(
                new int[]{40, 35, 70, 15, 45}));

        System.out.println("Most expensive item: "
                + Exercise4.mostExpensiveItem(
                new int[]{15, 20, 10, 35},
                new int[]{20, 15, 40, 15}));

        System.out.println("Most expensive affordable USB: "
                + Exercise4.mostExpensiveAffordableUSB(
                new int[]{15, 45, 20}, 30));

        System.out.println("Maximum spending: "
                + Exercise4.maximumSpending(
                budget, keyboards, usbDrives));
    }
}
public class Exercise2 {

    // 1. Find the maximum number.
    public static int maximum(int[] numbers) {
        checkArray(numbers);

        int max = numbers[0];

        for (int number : numbers) {
            if (number > max) {
                max = number;
            }
        }

        return max;
    }

    // 2. Find the minimum number.
    public static int minimum(int[] numbers) {
        checkArray(numbers);

        int min = numbers[0];

        for (int number : numbers) {
            if (number < min) {
                min = number;
            }
        }

        return min;
    }

    // 3. Maximum sum of n-1 numbers.
    // Exclude the smallest number.
    public static long maximumSumOfNMinusOne(int[] numbers) {
        checkArray(numbers);

        long sum = 0;

        for (int number : numbers) {
            sum += number;
        }

        return sum - minimum(numbers);
    }

    // 4. Minimum sum of n-1 numbers.
    // Exclude the largest number.
    public static long minimumSumOfNMinusOne(int[] numbers) {
        checkArray(numbers);

        long sum = 0;

        for (int number : numbers) {
            sum += number;
        }

        return sum - maximum(numbers);
    }

    private static void checkArray(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException(
                    "Array cannot be empty.");
        }
    }
}
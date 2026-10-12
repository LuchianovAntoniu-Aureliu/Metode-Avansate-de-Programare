import java.util.Arrays;

public class Exercise3 {

    // Represents a number using its sign and digit array.
    public static class SignedNumber {
        private final boolean negative;
        private final int[] digits;

        public SignedNumber(boolean negative, int[] digits) {
            this.digits = digits.clone();

            boolean isZero = true;

            for (int digit : this.digits) {
                if (digit != 0) {
                    isZero = false;
                    break;
                }
            }

            // Zero is never negative.
            this.negative = negative && !isZero;
        }

        public boolean isNegative() {
            return negative;
        }

        public int[] getDigits() {
            return digits.clone();
        }

        @Override
        public String toString() {
            String number = Arrays.toString(digits);
            return negative ? "-" + number : number;
        }
    }

    // 1. Add two numbers represented as digit arrays.
    public static int[] add(int[] a, int[] b) {
        checkSameLength(a, b);

        int n = a.length;
        int[] result = new int[n + 1];
        int carry = 0;

        for (int i = n - 1; i >= 0; i--) {
            int sum = a[i] + b[i] + carry;

            result[i + 1] = sum % 10;
            carry = sum / 10;
        }

        result[0] = carry;

        if (carry == 0) {
            return Arrays.copyOfRange(result, 1, n + 1);
        }

        return result;
    }

    // 2. Subtract b from a, supporting either order.
    public static SignedNumber subtract(int[] a, int[] b) {
        checkSameLength(a, b);

        int comparison = compare(a, b);

        if (comparison == 0) {
            return new SignedNumber(false, new int[a.length]);
        }

        if (comparison > 0) {
            return new SignedNumber(false, subtractDigits(a, b));
        }

        return new SignedNumber(true, subtractDigits(b, a));
    }

    // Subtract the smaller number from the larger number.
    private static int[] subtractDigits(int[] a, int[] b) {
        int n = a.length;
        int[] result = new int[n];
        int borrow = 0;

        for (int i = n - 1; i >= 0; i--) {
            int digit = a[i] - b[i] - borrow;

            if (digit < 0) {
                digit += 10;
                borrow = 1;
            } else {
                borrow = 0;
            }

            result[i] = digit;
        }

        return result;
    }

    // 3. Multiply a large number by one digit (0-9).
    public static int[] multiply(int[] a, int digit) {
        checkDigits(a);

        if (digit < 0 || digit > 9) {
            throw new IllegalArgumentException(
                    "Multiplier must be a single digit.");
        }

        int n = a.length;
        int[] result = new int[n + 1];
        int carry = 0;

        for (int i = n - 1; i >= 0; i--) {
            int product = a[i] * digit + carry;

            result[i + 1] = product % 10;
            carry = product / 10;
        }

        result[0] = carry;

        if (carry == 0) {
            return Arrays.copyOfRange(result, 1, n + 1);
        }

        return result;
    }

    // 4. Integer division by one digit (1-9).
    public static int[] divide(int[] a, int divisor) {
        checkDigits(a);

        if (divisor < 1 || divisor > 9) {
            throw new IllegalArgumentException(
                    "Divisor must be a digit from 1 to 9.");
        }

        int[] result = new int[a.length];
        int remainder = 0;

        for (int i = 0; i < a.length; i++) {
            int current = remainder * 10 + a[i];

            result[i] = current / divisor;
            remainder = current % divisor;
        }

        return result;
    }

    // Compare two equal-length digit arrays.
    private static int compare(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return Integer.compare(a[i], b[i]);
            }
        }

        return 0;
    }

    private static void checkSameLength(int[] a, int[] b) {
        checkDigits(a);
        checkDigits(b);

        if (a.length != b.length) {
            throw new IllegalArgumentException(
                    "Both numbers must have the same length.");
        }
    }

    private static void checkDigits(int[] a) {
        if (a == null || a.length == 0) {
            throw new IllegalArgumentException(
                    "Digit array cannot be empty.");
        }

        for (int digit : a) {
            if (digit < 0 || digit > 9) {
                throw new IllegalArgumentException(
                        "Every array element must be a digit.");
            }
        }
    }
}
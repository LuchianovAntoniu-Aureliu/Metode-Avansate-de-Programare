public class Exercise4 {

    // 1. Find the cheapest keyboard.
    public static int cheapestKeyboard(int[] keyboards) {
        checkPrices(keyboards);

        int cheapest = keyboards[0];

        for (int price : keyboards) {
            if (price < cheapest) {
                cheapest = price;
            }
        }

        return cheapest;
    }

    // 2. Find the most expensive item from both lists.
    public static int mostExpensiveItem(
            int[] keyboards, int[] usbDrives) {

        checkPrices(keyboards);
        checkPrices(usbDrives);

        return Math.max(
                maximum(keyboards),
                maximum(usbDrives)
        );
    }

    // 3. Find the most expensive USB drive within budget.
    // Return -1 if none is affordable.
    public static int mostExpensiveAffordableUSB(
            int[] usbDrives, int budget) {

        checkPrices(usbDrives);

        int best = -1;

        for (int price : usbDrives) {
            if (price <= budget && price > best) {
                best = price;
            }
        }

        return best;
    }

    // 4. Maximize spending while buying exactly
    // one keyboard and one USB drive.
    // Return -1 if no pair is affordable.
    public static int maximumSpending(
            int budget, int[] keyboards, int[] usbDrives) {

        checkPrices(keyboards);
        checkPrices(usbDrives);

        int best = -1;

        for (int keyboard : keyboards) {
            for (int usb : usbDrives) {
                int total = keyboard + usb;

                if (total <= budget && total > best) {
                    best = total;
                }
            }
        }

        return best;
    }

    private static int maximum(int[] prices) {
        int max = prices[0];

        for (int price : prices) {
            if (price > max) {
                max = price;
            }
        }

        return max;
    }

    private static void checkPrices(int[] prices) {
        if (prices == null || prices.length == 0) {
            throw new IllegalArgumentException(
                    "Price list cannot be empty.");
        }
    }
}
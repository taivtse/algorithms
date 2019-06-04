public class MaximumMinimumArray {
    public static void largestAndSmallest(int[] numbers) {
        int max, min;
        min = max = numbers[0];

        for (int number : numbers) {
            if (number > max) {
                max = number;
            } else if (number < min) {
                min = number;
            }
        }

        System.out.println(String.format("Max: %d - Min: %d", max, min));
    }

    public static void main(String[] args) {
        MaximumMinimumArray.largestAndSmallest(new int[]{1, 7, 8, 10, -1});
    }
}

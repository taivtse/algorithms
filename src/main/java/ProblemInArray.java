import sorting.QuickSort;

import java.util.HashSet;
import java.util.Set;

public class ProblemInArray {
    public static void printPairs(int[] array, int sum) {
        new QuickSort().sort(array);

        int left = 0;
        int right = array.length - 1;

        int temp;
        while (right >= left) {
            temp = array[left] + array[right];

            if (temp == sum) {
                System.out.println("Pair number: " + array[left] + " - " + array[right]);
                left++;
                right--;
            } else if (temp > sum) {
                right--;
            } else {
                left++;
            }
        }
    }

    public static void printPairsNotDuplicate(int[] array, int sum) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> alreadySet = new HashSet<>();

        for (int i = 0; i < array.length; i++) {
            int target = sum - array[i];

            if (alreadySet.contains(target) || alreadySet.contains(array[i])) {
                continue;
            }

            if (!set.contains(target)) {
                set.add(array[i]);
            } else {
                alreadySet.add(array[i]);
                System.out.printf("(%d, %d) %n", array[i], target);
            }
        }
    }

    public static void reverseArray(int[] input) {
        for (int i = 0; i < input.length / 2; i++) {
            int temp = input[i];
            input[i] = input[input.length - 1 - i];
            input[input.length - 1 - i] = temp;
        }

        for (int i = 0; i < input.length; i++) {
            System.out.println(input[i]);
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 9, 4, 5, 6, 2, 7, 8, 0, -1, 5, 8, 1, 9, 2, 8};
//        ProblemInArray.printPairs(array, 10);
//        ProblemInArray.printPairsNotDuplicate(array, 10);
        ProblemInArray.reverseArray(new int[] {1, 3});
    }
}

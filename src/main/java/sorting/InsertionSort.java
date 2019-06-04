package sorting;

import java.util.Random;

public class InsertionSort {
    public static void sort(int[] array) {
        int[] numbers = array;
        for (int i = 1; i < numbers.length; i++) {
            int numberToInsert = numbers[i];

            int compareIndex = i;
            while (compareIndex > 0 && numbers[compareIndex - 1] > numberToInsert) {
                numbers[compareIndex] = numbers[compareIndex - 1];
                compareIndex--;
            }
            numbers[compareIndex] = numberToInsert;
        }

//        System.out.println("Sorted array:");
//        for (int number : numbers) {
//            System.out.print("   " + number);
//        }
    }

    public static void main(String[] args) {
        int[] array = new int[100000];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
        }

        long start = System.nanoTime();
        InsertionSort.sort(array);
        long end = System.nanoTime();
        System.out.println("Insertion takes: " + (end - start));

        start = System.nanoTime();
        new QuickSort().sort(array);
        end = System.nanoTime();
        System.out.println("QuickSort takes: " + (end - start));
    }
}

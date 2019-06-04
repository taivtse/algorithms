package sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SelectionSort {
    private static void sort(List<Integer> list) {
        int size = list.size();
        for (int i = 0; i < size - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < size; j++) {
                if (list.get(j) < list.get(minIndex)) {
                    minIndex = j;
                }
            }

            if (minIndex != i){
                Collections.swap(list, i, minIndex);
            }
        }

        System.out.println(list);
    }

    public static void main(String[] args) {
        SelectionSort.sort(Arrays.asList(1, -1, 8, 3, 5, 9, 0));
    }
}

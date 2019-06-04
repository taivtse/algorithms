package sorting;

import java.util.Collections;
import java.util.List;

public class BubbleSort {
    private static void sort(List<Integer> list) {
        int lastIndex = list.size() - 1;
        for (int i = 0; i < lastIndex; i++) {
            for (int j = 0; j < lastIndex - i; j++) {
                if (list.get(j) > list.get(j + 1)) {
                    Collections.swap(list, j, j + 1);
                }
            }
        }

        System.out.println(list);
    }
}
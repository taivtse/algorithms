package dinamic_programing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LongestAscendingSequence {
    private List<Integer> list;
    private List<Integer> count;
    private List<Integer> prev;

    public LongestAscendingSequence(int[] array) {
        list = Arrays.stream(array).boxed().collect(Collectors.toList());

        count = new ArrayList<>();
        prev = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            count.add(0);
            prev.add(null);
        }
    }

    public int findLongestLength() {
//        buoc co so cua quy hoach dong
        count.set(0, 1);

//        luu gia tri max tu dau den phan tu i
        int maxCountIndex;

//        bat dau quy hoach dong
        for (int i = 1; i < list.size(); i++) {
            maxCountIndex = -1;
//            tim phan tu nho hon gan nhat o truoc i
            for (int j = 0; j < i; j++) {
                if (list.get(j) < list.get(i)) {
                    if (maxCountIndex == -1 || count.get(j) > count.get(maxCountIndex)) {
                        maxCountIndex = j;
                    }
                }
            }

            if ((maxCountIndex == -1)) {
                count.set(i, 1);
            } else {
                count.set(i, count.get(maxCountIndex) + 1);
                prev.set(i, maxCountIndex);
            }
        }

        System.out.println(list);
        System.out.println(count);
        System.out.println(prev);

        Integer index = count.indexOf(Collections.max(count));
        this.printLongestAscendingSequence(index);
        System.out.println("\n-------------------");
        this.printLongestAscendingSequenceRecursive(index);

        return Collections.max(count);
    }

    private void printLongestAscendingSequence(Integer index) {
        while (index != null) {
            System.out.print(list.get(index) + " - ");
            index = prev.get(index);
        }
    }

    private void printLongestAscendingSequenceRecursive(Integer index) {
        if (index == null) {
            return;
        }
        int curIndex = index;
        this.printLongestAscendingSequenceRecursive(prev.get(index));
        System.out.print(list.get(curIndex) + " - ");
    }

    public static void main(String[] args) {
        LongestAscendingSequence program = new LongestAscendingSequence(new int[]{12, 3, 5, 11, 15, 5, 4, 24, 50, 10});
        System.out.println("\nDo dai day con tang dan dai nhat la: " + program.findLongestLength());
    }
}

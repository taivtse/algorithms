package sorting;

public class BubbleSortPractice {
    private int[] array;

    public BubbleSortPractice(int[] array) {
        this.array = array;
    }

    public void sort() {
        if (array == null || array.length == 0) {
            return;
        }

        this.bubbleSort();
    }

    private void bubbleSort() {
        int lastIndex = array.length - 1;
        for (int i = 0; i < lastIndex; i++) {
            for (int j = 0; j < lastIndex - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] input = new int[]{2, 12, 6, 0, 100, -1};
        new BubbleSortPractice(input).sort();
        for (int i : input) {
            System.out.println(i);
        }
    }
}

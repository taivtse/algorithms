package sorting;

public class QuickSortPractice {
    private int[] array;

    public QuickSortPractice(int[] array) {
        this.array = array;
    }

    public void sort() {
        if (array == null || array.length == 0) {
            return;
        }

        quickSort(0, array.length - 1);
    }

    private void quickSort(int low, int high) {
        if (low == high) {
            return;
        }

        int left = low;
        int pivot = (high + low) / 2;
        int right = high;

        while (left <= right) {
            while (array[left] < array[pivot]) {
                left++;
            }
            while (array[right] > array[pivot]) {
                right--;
            }

            if (left <= right) {
                if (left != right) {
                    this.swap(left, right);
                }

                left++;
                right--;
            }
        }

        if (left < high) {
            this.quickSort(left, high);
        }

        if (right > low) {
            this.quickSort(low, right);
        }
    }

    private void swap(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 8, 2, 5, 7, 1, 4, 7, 2, 0};
        new QuickSortPractice(array).sort();

        for (int i : array) {
            System.out.println(i);
        }
    }
}

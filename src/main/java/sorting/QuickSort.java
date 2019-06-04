package sorting;

public class QuickSort {
    private int[] input;

    public void sort(int[] input) {
        if (input == null || input.length == 0) {
            return;
        }

        this.input = input;
        this.quicksort(0, input.length - 1);
    }

    private void quicksort(int low, int high) {
        int i = low;
        int j = high;

        int pivot = (high + low) / 2;

        // divide into 2 array
        while (i <= j) {
            // make i increase if elements at i are less than the pivot element
            while (input[i] < input[pivot]) {
                i++;
            }

            // make j decrease if elements at j are greater than the pivot element
            while (input[j] > input[pivot]) {
                j--;
            }

            if (i <= j) {
                if (i != j) {
                    this.swap(i, j);
                }
                // move index to next position on both sides i++; j--;
                i++;
                j--;
            }
        }

        if (j > low) {
            quicksort(low, j);
        }

        if (i < high) {
            quicksort(i, high);
        }
    }

    private void swap(int i, int j) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }

    private void sout() {
        System.out.println("\n--------------------------------------------------------------");
        for (int i : input) {
            System.out.print(String.format("%5d", i));
        }
    }

    public static void main(String[] args) {
        int[] input = new int[]{2, 12, 6, 0, 100};

//        new sorting.QuickSort().sort(input);
    }
}

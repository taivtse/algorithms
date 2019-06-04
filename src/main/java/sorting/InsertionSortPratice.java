package sorting;

public class InsertionSortPratice {
    private int[] array;

    public InsertionSortPratice(int[] array) {
        this.array = array;
    }

    public void sort() {
        if (array == null || array.length == 0) {
            return;
        }
        this.insertionSort();
    }

    private void insertionSort() {
        for (int i = 1; i < array.length; i++){
            int numberToInsert = array[i];

            int compareIndex = i;
            while (compareIndex > 0 && array[compareIndex - 1] > numberToInsert){
                array[compareIndex] = array[compareIndex - 1];
                compareIndex--;
            }

            array[compareIndex] = numberToInsert;
        }
    }

    public static void main(String[] args) {
        int[] input = new int[]{2, 12, 6, 0, 100, -1, 32};
        new InsertionSortPratice(input).sort();
        for (int i : input) {
            System.out.println(i);
        }
    }
}

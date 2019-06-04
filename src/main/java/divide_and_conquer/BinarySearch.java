package divide_and_conquer;

public class BinarySearch {
    private int[] array;

    public BinarySearch(int[] array) {
        this.array = array;
        this.checkAscendingSorted();
    }

    private void checkAscendingSorted() {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                throw new RuntimeException("The array must be ascending sorting");
            }
        }
    }

    public int indexOf(int number) {
        int left = 0;
        int right = array.length - 1;
        int mid;

        while (left <= right) {
            System.out.println("loop");
            mid = (right + left) / 2;

            if (array[mid] == number) {
                while (array[mid] == number){
                    mid--;
                }
                return mid + 1;
            } else if (array[mid] > number) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch(new int[]{-5, 0, 0, 0, 3, 4, 5, 7, 8, 8, 9});

        System.out.println(binarySearch.indexOf(3));
    }
}

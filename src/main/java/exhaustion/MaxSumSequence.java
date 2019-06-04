package exhaustion;

public class MaxSumSequence {
    private int[] array;
    private int start;
    private int end;

    public MaxSumSequence(int[] array) {
        this.array = array;
    }

    public void findMaxSumSequence() {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i; j++){
                int sum = 0;
                for (int k = j; k < array.length - i; k++) {
                    sum += this.array[k];
                }
                if (sum > max){
                    max = sum;
                    start = j;
                    end = array.length - i - j;
                }
            }
        }

        System.out.println("Do dai mang con lien tuc co tong lon nhat la: " + max);
        System.out.println("Mang con lien tuc dai nhat la: ");
        for (int i = start; i <= end; i++) {
            System.out.printf("%4d", this.array[i]);
        }
    }

    public static void main(String[] args) {
        MaxSumSequence maxSumSequence = new MaxSumSequence(new int []{-2, 1, 4, -3, 9, -8, 10, -4});
        maxSumSequence.findMaxSumSequence();
    }
}

import java.util.Arrays;
import java.util.BitSet;

public class MissingNumberInArray {
    public static BitSet convert(long value) {
        BitSet bits = new BitSet();
        int index = 0;
        while (value != 0L) {
            if (value % 2L != 0) {
                bits.set(index);
            }
            ++index;
            value = value >>> 1;
        }
        return bits;
    }

    public static long convert(BitSet bits) {
        long value = 0L;
        for (int i = 0; i < bits.length(); ++i) {
            value += bits.get(i) ? (1L << i) : 0L;
        }
        return value;
    }

    public static void printMissingNumber(int[] numbers, int count) {
        BitSet bitSet = new BitSet(count);

        for (int number : numbers) {
            bitSet.set(number - 1);
        }

        int missingCount = (count - bitSet.cardinality());
        System.out.println("So luong so con thieu: " + missingCount);
        System.out.println("Cac so do la:");

        int missingIndex = 0;
        for (int i = 0; i < missingCount; i++) {
            missingIndex = bitSet.nextClearBit(missingIndex);
            System.out.print((++missingIndex) + "  ");
        }
    }

    public static void removeDuplicates(int[] numbers) {
        Arrays.sort(numbers);

        int prev = numbers[0];

        System.out.print(prev + "   ");
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] != prev) {
                prev = numbers[i];
                System.out.print(prev + "   ");
            }
        }
    }

    public static void findDuplicates(int[] numbers) {
        Arrays.sort(numbers);

        int prev = numbers[0];

        int numberExistCount = 1;
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] == prev && numberExistCount == 1) {
                System.out.print(prev + "   ");
                numberExistCount++;
            } else if (numbers[i] != prev){
                prev = numbers[i];
                numberExistCount = 1;
            }
        }
    }

    public static void main(String[] args) {
//        MissingNumberInArray.printMissingNumber(new int[]{1, 2, 5, 6, 8, 10}, 10);
//        MissingNumberInArray.removeDuplicates(new int[]{1, 5, 2, 2, 5, 6, 6, 2, 8, 10, 10});
        MissingNumberInArray.findDuplicates(new int[]{1, 5, 2, 2, 5, 6, 2, 8, 10, 10, 2, 5});
    }
}

package exhaustion;

public class Exhaustion1Problem {
    private boolean checkIsTriangle(int a, int b, int c) {
        return (a > 0 && b > 0 && c > 0 && (a + b) > c && (a + c) > b && (b + c) > a);
    }

    public void findTriangle(int[] input) {
        for (int i = 0; i < input.length - 2; i++) {
            for (int j = i + 1; j < input.length - 1; j++) {
                for (int k = j + 1; k < input.length; k++) {
                    if (checkIsTriangle(input[i], input[j], input[k])) {
                        System.out.printf("%4d %4d %4d%n", input[i], input[j], input[j + 1]);
                    }
                }
            }
        }
    }

    public void findNPairsUCLN(int[] input) {
        int countMax = 0;
        int count;

        int x = 0, y = 0;
        for (int i = 0; i < input.length - 1; i++) {
            for (int j = i + 1; j < input.length; j++) {
                count = this.demSoUocChung(input[i], input[j]);

                if (count > countMax) {
                    countMax = count;
                    x = i;
                    y = j;
                }
            }
        }

        System.out.println("Cap so co uoc chung nhieu nhat la: " + input[x] + " - " + input[y]);
        System.out.println("Cac uoc chung la: ");
        int min = input[x] < input[y] ? input[x] : input[y];
        for (int k = 1; k <= min; k++) {
            if (input[x] % k == 0 && input[y] % k == 0) {
                System.out.println(k);
            }
        }
    }

    private int demSoUocChung(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        int min = (a < b) ? a : b;
        int count = 0;

        for (int k = 1; k <= min; k++) {
            if (a % k == 0 && b % k == 0) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Exhaustion1Problem exhaustion1Problem = new Exhaustion1Problem();
//        exhaustion1Problem.findTriangle(new int[]{2, 3, 4, 6, 9, 1});
        exhaustion1Problem.findNPairsUCLN(new int[]{1, 6, 9, 5, 8, 12});
    }
}

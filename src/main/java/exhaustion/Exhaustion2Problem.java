package exhaustion;

import java.sql.SQLOutput;

public class Exhaustion2Problem {
    public int ucln(int a, int b) {
        if (a == 0 && b == 0)
            throw new IllegalArgumentException("Tham so dau vao khong hop le");
        if (a == 0)
            return b;
        if (b == 0)
            return a;
        return ucln(b, a % b);
    }

    public int ucln3Cua3So(int a, int b, int c) {
        int u = this.ucln(a, b);
        return this.ucln(u, c);
    }

    public int bcnn(int a, int b) {
        return (a * b) / this.ucln(a, b);
    }

    public int bcnnCuaArray(int[] array) {
        int bcnn = array[0];
        for (int i = 1; i < array.length; i++) {
            bcnn = this.bcnn(bcnn, array[i]);
        }
        return bcnn;
    }

    public void bo3CoUCLNLN(int[] array) {
        int countMax = 0;
        int count = 0;
        int[] bo3UCLN = new int[3];
        for (int i = 0; i < array.length - 2; i++) {
            for (int j = i + 1; j < array.length - 1; j++) {
                for (int k = j + 1; k < array.length; k++) {
                    count = this.ucln3Cua3So(array[i], array[j], array[k]);
                    if (count > countMax) {
                        countMax = count;
                        bo3UCLN[0] = i;
                        bo3UCLN[1] = j;
                        bo3UCLN[2] = k;
                    }
                }
            }
        }

        System.out.printf("Bo 3 co UCLN la: (%d, %d, %d)%n", array[bo3UCLN[0]], array[bo3UCLN[1]], array[bo3UCLN[2]]);
        System.out.println("UCLN la: " + this.ucln3Cua3So(array[bo3UCLN[0]], array[bo3UCLN[1]], array[bo3UCLN[2]]));
    }

    public void mangConLienTucCoTongLonNhat(int[] array) {
        int sumMax = Integer.MIN_VALUE;
        int sum;
        int start = -1;
        int end = -1;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i; j < array.length; j++) {
                sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += array[k];
                }

                if (sum > sumMax) {
                    sumMax = sum;
                    start = i;
                    end = j;
                }
            }
        }

        System.out.println("Tong day con lien tuc co tong lon nhat la: " + sumMax);
        System.out.println("Day con: ");
        for (int i = start; i <= end; i++) {
            System.out.printf("%4d", array[i]);
        }
    }

    public static void main(String[] args) {
        Exhaustion2Problem exhaustion2Problem = new Exhaustion2Problem();
//        System.out.println(exhaustion2Problem.ucln(6, 12));
//        System.out.println(exhaustion2Problem.ucln3Cua3So(6, 12, 8));
//        System.out.println(exhaustion2Problem.bcnn(3, 5));
//        System.out.println(exhaustion2Problem.bcnnCuaArray(new int[]{1, 2, 3, 2, 5, 6}));
//        exhaustion2Problem.bo3CoUCLNLN(new int[]{8, 4, 3, 9, 6, 4, 1, 10});
        exhaustion2Problem.mangConLienTucCoTongLonNhat(new int[]{-2, 1, 4, -3, 9, -8, 4});
    }
}

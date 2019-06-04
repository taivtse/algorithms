public class SomeThings {
    public static void palindrome(int i) {
        int result = 0;
        while (true) {
            result += i % 10;
            i /= 10;

            if (i == 0) {
                break;
            }
            result *= 10;
        }

        System.out.println(result);
    }

    public static void fibonacci(int i) {
        int t1 = 0;
        int t2 = 1;
        int temp;

        for (int j = 1; j <= i; j++) {
            System.out.print(t1 + " - ");

            temp = t1;
            t1 = t2;
            t2 = t2 + temp;
        }
    }

    public static void fibonacciRecursive(int t1, int t2, int index) {
        if (index == 0)
            return;

        System.out.print(t1 + " - ");

        int temp;
        temp = t1;
        t1 = t2;
        t2 = t2 + temp;

        fibonacciRecursive(t1, t2, --index);
    }

    public static long fibonacciAt(long t1, long t2, int index) {
        if (index == 1)
            return t2;

        long temp;
        temp = t1;
        t1 = t2;
        t2 = t2 + temp;

        return fibonacciAt(t1, t2, --index);
    }

    public static int fibonacciAtWay2(int index) {
        if (index <= 1)
            return index;
        return fibonacciAtWay2(index - 1) + fibonacciAtWay2(index - 2);
    }

    public static int ucln(int a, int b) {
        if (b == 0)
            return a;
        return ucln(b, a % b);
    }

    public static int bcnn(int a, int b) {
        return a * b / ucln(a, b);
    }

    public static void main(String[] args) {
//        0 1 1 2 3 5 8 11
//        System.out.println(SomeThings.fibonacciAt(0, 1, 91));
//        System.out.println(SomeThings.fibonacciAtWay2(90));

        System.out.println(SomeThings.ucln(6, 15));
        System.out.println(SomeThings.bcnn(6, 15));
    }
}
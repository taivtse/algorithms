package dinamic_programing;

import java.util.ArrayList;
import java.util.List;

public class Fibonacci {
    private List<Long> lookUp;

    public Fibonacci() {
        this.lookUp = new ArrayList<>();
        for (int i = 0; i < 150; i++) {
            this.lookUp.add(null);
        }
    }

    public Long fibonacciAt(int n) {
        if (this.lookUp.get(n) == null) {
            if (n <= 1) {
                this.lookUp.set(n, (long) n);
            } else {
                Long result = this.fibonacciAt(n - 1) + this.fibonacciAt(n - 2);
                this.lookUp.set(n, result);
            }
        }

        return this.lookUp.get(n);
    }

    public static void main(String[] args) {
//        0   1   1   2   3   5   8   11
        Fibonacci programing = new Fibonacci();
        System.out.println(programing.fibonacciAt(90));
    }
}

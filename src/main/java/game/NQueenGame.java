package game;

public class NQueenGame {
    private int n;
    private boolean[] col;
    private boolean[] leftDiagonal;
    private boolean[] rightDiagonal;

    public NQueenGame(int n) {
        this.n = n;
        col = new boolean[n];
        leftDiagonal = new boolean[n];
        rightDiagonal = new boolean[n];
    }

    public static void main(String[] args) {
        new NQueenGame(5);
    }
}

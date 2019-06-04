package game;

import java.util.Random;

public class Minesweeper {
    private int width;
    private int numOfMines;

    private int[][] matrix;

    public Minesweeper(int width, int numOfMines) {
        this.width = width;
        this.numOfMines = numOfMines;
        matrix = new int[width][width];
        this.init();
        this.generateMatrix();
        this.display();
    }

    private void init() {
        int randRow;
        int randCol;
        final Random random = new Random();
        for (int i = 1; i <= numOfMines; i++) {
            randRow = random.nextInt(width);
            randCol = random.nextInt(width);
            matrix[randRow][randCol] = -1;
        }
    }

    public void display() {
        for (int[] row : matrix) {
            for (int col : row) {
                System.out.print(String.format("%4s", col));
            }
            System.out.println();
        }
    }

    private void generateMatrix() {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (matrix[row][col] != -1) {
                    matrix[row][col] = this.countMines(row, col);
                }
            }
        }
    }

    private int countMines(final int row, final int col) {
        int count = 0;
        int i = row - 1;
        int j = col - 1;
        int mark = 1;
        while (mark <= 8) {
            try {
                if (matrix[i][j] == -1) {
                    count++;
                }
            } catch (ArrayIndexOutOfBoundsException ignore) {
            }
            mark++;
            if (i == row - 1 && j <= col) {
                j++;
            } else if (i == row + 1 && j >= col) {
                j--;
            } else if (j == col + 1 && i <= row) {
                i++;
            } else if (j == col - 1 && i >= row) {
                i--;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Minesweeper minesweeper = new Minesweeper(10, 15);
    }
}

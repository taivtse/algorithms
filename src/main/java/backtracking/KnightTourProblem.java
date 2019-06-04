package backtracking;

public class KnightTourProblem {
    private int width = 8;
    private int[][] matrix = new int[width][width];
    private final Coordinate starCoordinate;
    private final int completeStep = width*width;
    private boolean isSolve = false;

    public class Coordinate {
        int row;
        int col;

        public Coordinate(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public KnightTourProblem(int rowStart, int colStart) {
        this.starCoordinate = new Coordinate(rowStart, colStart);
        this.matrix[starCoordinate.row][starCoordinate.col] = 1;
        this.solve(starCoordinate, 2);
        this.display();
    }

    private void solve(Coordinate curCoordinate, int curStep) {
        if (curStep > completeStep){
            isSolve = true;
            return;
        }
//        duyet qua 8 vi tri xung quanh
        for (int i = 1; i <= 8 && !isSolve; i++) {
            Coordinate nextCoordinate = this.getNextCoordinate(curCoordinate, i);
            try {
                if (this.matrix[nextCoordinate.row][nextCoordinate.col] != 0){
                    continue;
                }
            }catch (ArrayIndexOutOfBoundsException ex){
                continue;
            }

            this.matrix[nextCoordinate.row][nextCoordinate.col] = curStep;
            this.solve(nextCoordinate, curStep + 1);
        }
        if(!isSolve){
            this.matrix[curCoordinate.row][curCoordinate.col] = 0;
        }
    }

    private Coordinate getNextCoordinate(Coordinate curCoordinate, int step) {
        int curRow = curCoordinate.row;
        int curCol = curCoordinate.col;
        switch (step){
            case 1:
                return new Coordinate(curRow - 2, curCol + 1);
            case 2:
                return new Coordinate(curRow - 1, curCol + 2);
            case 3:
                return new Coordinate(curRow + 1, curCol + 2);
            case 4:
                return new Coordinate(curRow + 2, curCol + 1);
            case 5:
                return new Coordinate(curRow + 2, curCol - 1);
            case 6:
                return new Coordinate(curRow + 1, curCol - 2);
            case 7:
                return new Coordinate(curRow - 1, curCol - 2);
            case 8:
                return new Coordinate(curRow - 2, curCol - 1);
        }
        return null;
    }

    public void display() {
        for (int[] row : matrix) {
            for (int col : row) {
                System.out.print(String.format("%4s", col));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        KnightTourProblem knightTourProblem = new KnightTourProblem(0, 0);
    }
}

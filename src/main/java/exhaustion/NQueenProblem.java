package exhaustion;

public class NQueenProblem {
    private int numOfRow;
    private int[] check;

    public NQueenProblem(int numOfRow) {
        this.numOfRow = numOfRow;
        this.check = new int[numOfRow];
        this.sovle();
    }

    private boolean isOk(int row, int col) {
        for (int curRow = 0; curRow < row; curRow++) {
            if (check[curRow] == col || Math.abs(curRow - row) == Math.abs(check[curRow] - col)){
                return false;
            }
        }
        return true;
    }

    private void sovle(){
        this.tryRecursive(0);
    }

    private void tryRecursive(int solvingRow){
        if(solvingRow == this.numOfRow){
            this.display();
            System.out.println("----------------------------------------");
            return;
        }

        for (int col = 0; col < this.numOfRow; col++) {
            if (isOk(solvingRow, col)){
                this.check[solvingRow] = col;
                this.tryRecursive(solvingRow + 1);
            }
        }
    }

    private void display(){
        for (int i = 0; i < this.numOfRow; i++) {
            for (int j = 0; j < this.numOfRow; j++) {
                if (j == this.check[i]){
                    System.out.print(String.format("%4s", "[X]"));
                }else{
                    System.out.print(String.format("%4s", "[ ]"));
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        NQueenProblem nQueenProblem = new NQueenProblem(8);
    }
}

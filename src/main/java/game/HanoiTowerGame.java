package game;

public class HanoiTowerGame {
    public static void findSolution(int numOfDisk, String fromPole, String sparePole, String toPole){
        if (numOfDisk == 1){
            System.out.println("Move 1 disk from " + fromPole + " -> " + toPole);
        }else{
            findSolution(numOfDisk - 1, fromPole, toPole, sparePole);
            findSolution(1, fromPole, sparePole, toPole);
            findSolution(numOfDisk - 1, sparePole, fromPole, toPole);
        }
    }

    public static void main(String[] args) {
        HanoiTowerGame.findSolution(20, "A", "B", "C");
    }
}

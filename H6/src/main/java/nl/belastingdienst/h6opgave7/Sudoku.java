package nl.belastingdienst.h6opgave7;

public class Sudoku {
    private static final int side = 3;
    private final int[][] sudoku;

    public Sudoku() {
        sudoku = new int[side][side];

        int[] availableNumbers = new int[side*side];
        for(int i = 0; i < side*side ; i++) {
            availableNumbers[i] = i + 1;
        }

        int currentIndex;
        for (int i = 0; i < side*side; i++) {
            currentIndex = (int) ((side*side - i) * Math.random());
            sudoku[i/side][i%side] = availableNumbers[currentIndex];
            System.arraycopy(availableNumbers, currentIndex + 1, availableNumbers, currentIndex, side*side - currentIndex - 1);
        }
    }

    public void printSudoku() {
        for (int i = 0; i < side; i++) {
            System.out.print("| ");
            for (int j = 0; j < side; j++) {
                System.out.printf("%d | ", sudoku[i][j]);
            }
            System.out.print("\n");
        }
    }
}

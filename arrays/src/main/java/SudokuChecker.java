import java.util.List;

public class SudokuChecker {

    /*
    5.16
    */

    public static boolean isValidSudoku(List<List<Integer>> partialAssignment) {
        // Invalid input
        if (partialAssignment == null || partialAssignment.size() == 0 ||
                partialAssignment.size() != 9 || partialAssignment.get(0).size() != 9) {
            return false;
        }

        int[] rows = new int[10]; // 9 + 1
        int[] cols = new int[10];

        // First validate against the rows and cols
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (partialAssignment.get(i).get(j) == 0) continue;

                int num = partialAssignment.get(i).get(j);
                if (rows[num] != 0) return false;
                rows[num] = num;

                num = partialAssignment.get(j).get(i);
                if (cols[num] != 0) return false;
                cols[num] = num;
            }
            rows = new int[10];
            cols = new int[10];
        }

        // Then check every square
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                if (!isValidSudokuSquare(partialAssignment, i, j))
                    return false;
            }
        }

        return true;
    }

    private static boolean isValidSudokuSquare(List<List<Integer>> partialAssignment, int row, int col) {
        int[] square = new int[10];

        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                int num = partialAssignment.get(i).get(j);
                if (square[num] != 0) {
                    return false;
                }
                square[num] = num;
            }
        }

        return true;
    }
}

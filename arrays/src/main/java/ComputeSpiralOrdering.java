import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComputeSpiralOrdering {

    /*
    5.18
    */

    public static List<Integer> matrixInSpiralOrder(List<List<Integer>> squareMatrix) {
        if (squareMatrix == null || squareMatrix.size() == 0 || squareMatrix.get(0).size() == 0) {
            return Collections.emptyList();
        }

        final List<Integer> result = new ArrayList<>();

        int topRow = 0, botRow = squareMatrix.size() - 1;
        int leftCol = 0, rightCol = squareMatrix.get(0).size() - 1;

        while (topRow <= botRow && leftCol <= rightCol) {
            // Add top row from left to right
            for (int i = leftCol; i <= rightCol; i++) {
                result.add(squareMatrix.get(topRow).get(i));
            }
            topRow++;

            // Add right col from top to bot
            for (int i = topRow; i <= botRow; i++) {
                result.add(squareMatrix.get(i).get(rightCol));
            }
            rightCol--;

            if (topRow <= botRow) {
                // Add bot row from right to left
                for (int i = rightCol; i >= leftCol; i--) {
                    result.add(squareMatrix.get(botRow).get(i));
                }
                botRow--;
            }

            if (leftCol <= rightCol) {
                // Add left col from bot to top
                for (int i = botRow; i >= topRow; i--) {
                    result.add(squareMatrix.get(i).get(leftCol));
                }
                leftCol++;
            }
        }

        return result;
    }
}

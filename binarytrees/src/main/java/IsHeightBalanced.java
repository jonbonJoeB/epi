public class IsHeightBalanced {

    /*
    9.1
    */

    public static boolean isBalanced(BinaryTree<Integer> tree) {
        return heightCheck(tree) != -1;
    }

    private static int heightCheck(BinaryTree<Integer> tree) {
        if (tree == null) {
            return 0;
        }

        int leftHeight = heightCheck(tree.left);
        if (leftHeight == -1) {
            return -1;
        }

        int rightHeight = heightCheck(tree.right);
        if (rightHeight == -1) {
            return -1;
        }

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        return 1 + Math.max(leftHeight, rightHeight);
    }
}

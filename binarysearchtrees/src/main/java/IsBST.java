public class IsBST {

    /*
    14.1
    */

    public static boolean isBST(BinaryTree<Integer> tree) {
        return isBST(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean isBST(BinaryTree<Integer> tree, int min, int max) {
        if (tree == null) return true;
        if (min > tree.data || tree.data > max) {
            return false;
        }

        return isBST(tree.left, min, tree.data) && isBST(tree.right, tree.data, max);
    }
}
